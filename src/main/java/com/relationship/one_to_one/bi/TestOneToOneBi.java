package com.relationship.one_to_one.bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOneBi {

    public static void main(String[] args) {

        Wheel wheel = new Wheel(4);

        Car car = new Car("BMW", wheel);

        wheel.setCar(car);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(car);

        Car car1 = em.find(Car.class, 16);

        em.remove(car1);

        transaction.commit();

        em.close();

        emf.close();
    }
}
