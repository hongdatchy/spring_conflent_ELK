package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
import com.fis.search.dto.SearchCombinationDTO;
import com.fis.search.service.ElasticSearchService;
import com.fis.search.service.impl.ElasticSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TestSpringKafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringKafkaApplication.class, args);
	}

	@Autowired
	KafkaTemplate<String, BatchMessage> kafkaTemplate; // <1>

	@Override
	public void run(String... args) throws Exception {
		ElasticSearchService elasticSearchService = new ElasticSearchServiceImpl(null);
		elasticSearchService.searchCombinationByTerm(new SearchCombinationDTO());
	}
}
