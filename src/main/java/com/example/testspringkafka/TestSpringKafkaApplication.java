package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
import com.fis.search.dto.SearchCombinationDTO;
import com.fis.search.service.ElasticSearchService;
import com.fis.search.service.impl.ElasticSearchServiceImpl;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class TestSpringKafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringKafkaApplication.class, args);
	}

	@Autowired
	KafkaTemplate<String, BatchMessage> kafkaTemplate; // <1>

	@Override
	public void run(String... args) throws Exception {
//		ElasticSearchService elasticSearchService = new ElasticSearchServiceImpl(null);
//		elasticSearchService.searchCombinationByTerm(new SearchCombinationDTO());



		String bootstrapServers = "localhost:9092"; // Thay bằng bootstrap server của bạn
		String topicName = "my-first-topic";

		Properties props = new Properties();
		props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

		try (AdminClient adminClient = AdminClient.create(props)) {
			KafkaFuture<Map<String, TopicDescription>> future = adminClient.describeTopics(Collections.singletonList(topicName)).all();
			Map<String, TopicDescription> topics = future.get(); // Lấy thông tin topic
			TopicDescription topicDescription = topics.get(topicName);

			System.out.println("Topic: " + topicName);
			System.out.println("Số partition: " + topicDescription.partitions().size());
			System.out.println("Chi tiết partitions: " + topicDescription.partitions());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
