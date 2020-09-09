package com.relationship.many_to_one.bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBiManyToOne {

    public static void main(String[] args) {

        House house = new House();
        house.setCost("10000");


        Room room = new Room();
        room.setCount(4);
        room.setHouse(house);

        Room roomTwo = new Room();
        roomTwo.setCount(6);
        roomTwo.setHouse(house);

        house.addRoom(room);
        house.addRoom(roomTwo);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(house);

        em.persist(room);

        House houseFind = em.find(House.class, 39);

        houseFind.setCost("222");

        Room roomFind = em.find(Room.class, 40);

        roomFind.setCount(19);

        em.remove(houseFind);

        em.remove(roomFind);

        transaction.commit();

        em.close();

        emf.close();
    }
}
