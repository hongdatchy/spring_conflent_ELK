package com.example.testspringkafka.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String age;
    private Date birthday;

    public Student(int i) {
        this.name = "Teacher" + i;
        this.age = "major" + i;
        this.birthday = new Date();
    }
}
