package com.relationship.many_to_one.uni;

import javax.persistence.*;

@Entity
@Table(name = "ordersItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Order order;


    public OrderItem() {
    }

    public OrderItem(String name, Order order) {
        this.name = name;
        this.order = order;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
