package com.relationship.one_to_many.bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToManyBi {

    public static void main(String[] args) {

        Leg leg1 = new Leg(4);

        Leg leg2 = new Leg(6);

        Animal animal = new Animal("Lion");

        animal.addLeg(leg1);

        animal.addLeg(leg2);

        leg1.setAnimal(animal);

        leg2.setAnimal(animal);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(animal);

        Animal animal1 = em.find(Animal.class, 26);

        em.remove(animal1);

        Animal animal2 = em.find(Animal.class, 5);

        animal2.getLegs().set(0, null);

        animal2.getLegs().clear();

        transaction.commit();

        em.close();

        emf.close();
    }
}
