package com.relationship.one_to_one.bi;

import javax.persistence.*;

@Entity
public class Wheel {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int size;

    @OneToOne
    private Car car;

    public Wheel(int size) {
        this.size = size;
    }

    public Wheel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
