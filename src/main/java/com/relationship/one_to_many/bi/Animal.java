package com.relationship.one_to_many.bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "animal",
            fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Leg> legs = new ArrayList<Leg>();

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void addLeg(Leg leg) {
        legs.add(leg);
    }
}
