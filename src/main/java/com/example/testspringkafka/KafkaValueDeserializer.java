package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class KafkaValueDeserializer implements Deserializer<BatchMessage> {

    @Override
    public BatchMessage deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        objectMapper.setDateFormat(df);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objectMapper.findAndRegisterModules();
        try {
            return objectMapper.readValue(data, BatchMessage.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
