package com.relationship.many_to_one.bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String cost;

    @OneToMany(mappedBy = "house", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Room> rooms = new ArrayList<>();

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", cost='" + cost + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
}
