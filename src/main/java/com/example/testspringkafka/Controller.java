package com.example.testspringkafka;

import com.example.testspringkafka.data.BatchMessage;
import com.example.testspringkafka.data.Student;
import com.example.testspringkafka.data.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    KafkaTemplate<String, BatchMessage> kafkaTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/sendBathDataToKafka/{numberBatches}")
    public ResponseEntity<Object> sendBathDataToKafka(@PathVariable int numberBatches) {

        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < numberBatches; i++) {
            Student student = new Student(i);
            Teacher teacher = new Teacher(i);
            students.add(student);
            teachers.add(teacher);
        }
        List<Object> list = new ArrayList<>();
        list.addAll(students);
        list.addAll(teachers);


        kafkaTemplate.send("my-first-topic", new Random().nextInt()/2 ==0 ? "key1": "key2",new BatchMessage("hello ", list));
        System.out.println("sent students and teachers to my-first-topic");
        return ResponseEntity.ok("sent students and teachers to my-first-topic");
    }

    //

}
