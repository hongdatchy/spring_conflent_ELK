package com.example.testspringkafka.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String name;
    private String major;

    public Teacher(int i) {
        this.name = "Teacher" + i;
        this.major = "major" + i;
    }
}
