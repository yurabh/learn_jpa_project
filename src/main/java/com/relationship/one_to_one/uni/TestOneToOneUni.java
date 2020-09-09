package com.relationship.one_to_one.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOneUni {

    public static void main(String[] args) {

        Address address = new Address("Gorodocka");

        Person person = new Person("Andriy", 10);

        person.setAddress(address);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(person);

        Person person1 = em.find(Person.class, 12);

        person1.getAddress().setCity("New York");

        person1.setAge(121212);

        em.remove(person1);

        transaction.commit();

        em.close();

        emf.close();
    }
}
