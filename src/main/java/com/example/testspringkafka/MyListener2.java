//package com.example.testspringkafka;
//
//import com.example.testspringkafka.data.BatchMessage;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyListener2 {
//
//    @KafkaListener(topics = {"my-first-topic"}, groupId = "my-first-app")
//    public void listen2(BatchMessage batchMessage) {
//
//        System.out.println("listen Received Message in group - group-id: 2" + batchMessage);
//    }
//
//}
