package com.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMan {

    public static void main(String[] args) {
        Man man = new Man("Jack", 11);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(man);

        Man manFound = em.find(Man.class, 1);

        System.out.println(manFound.toString());

        transaction.commit();

        em.close();
    }
}
