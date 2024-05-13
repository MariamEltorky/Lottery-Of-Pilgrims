package com.LotteryOfPilgrims.LotteryOfPilgrims.model;

import javax.persistence.*;

@Entity
public class Pilgrims {

    @Id
    private Long id;
    private String Name;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pilgrims() {
    }

    public Pilgrims(Long id, String name, int age) {
        this.id = id;
        this.Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
