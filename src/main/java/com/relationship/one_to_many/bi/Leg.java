package com.relationship.one_to_many.bi;

import javax.persistence.*;

@Entity
public class Leg {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int size;

    @ManyToOne
    @JoinColumn(name = "animal_fk_id")
    private Animal animal;

    public Leg() {
    }

    public Leg(int size) {
        this.size = size;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
