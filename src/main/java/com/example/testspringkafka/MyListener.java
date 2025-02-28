package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @KafkaListener(topics = "my-first-topic", groupId = "my-first-app", concurrency = "2")
    public void listen(BatchMessage batchMessage, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received Message: " + batchMessage + " from partition: " + partition);
    }

}
