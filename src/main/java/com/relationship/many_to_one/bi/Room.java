package com.relationship.many_to_one.bi;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column
    private int count;

    @ManyToOne
    @JoinColumn(name = "fk_house_id")
    private House house;


    public Room() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", count=" + count +
                ", house=" + house +
                '}';
    }
}
