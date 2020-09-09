package com.relationship.many_to_one.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUniManyToOne {

    public static void main(String[] args) {

        Order order = new Order();

        order.setCost("1200");

        OrderItem orderItem = new OrderItem();

        orderItem.setName("Milk");

        orderItem.setOrder(order);

        OrderItem orderItem1 = new OrderItem();

        orderItem1.setName("Apple");

        orderItem1.setOrder(order);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(orderItem);
        em.persist(orderItem1);
        em.persist(order);


        Order orderFind = em.find(Order.class, 34);

        OrderItem newOrderItem = new OrderItem();

        newOrderItem.setName("Olio");

        newOrderItem.setOrder(orderFind);

        em.persist(newOrderItem);


        OrderItem orderItem2 = em.find(OrderItem.class, 32);

        em.remove(orderItem2);

        em.persist(orderItem2.getOrder());


        transaction.commit();

        em.close();

        emf.close();
    }
}
