package com.Gradle.Gradle.Model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class PersonDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String name,age;
}