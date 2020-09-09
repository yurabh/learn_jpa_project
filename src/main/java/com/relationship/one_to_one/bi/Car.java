package com.relationship.one_to_one.bi;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "car")
    private Wheel wheel;

    public Car(String name, Wheel wheel) {
        this.name = name;
        this.wheel = wheel;
    }

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wheel=" + wheel +
                '}';
    }
}
