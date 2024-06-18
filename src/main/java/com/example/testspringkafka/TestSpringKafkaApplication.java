package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
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

	}
}
