package com.relationship.many_to_many.bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBiManyToMany {

    public static void main(String[] args) {

        Stores stores = new Stores("Natala");

        Products products = new Products("sale");

        Products productsTwo = new Products("tomato");

        stores.addProduct(products);

        stores.addProduct(productsTwo);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(stores);

        Stores storeTwo = em.find(Stores.class, 54);

        storeTwo.setName("Phones");

        Products productsFind = em.find(Products.class, 55);

        productsFind.setDescription("My book");

        transaction.commit();

        em.close();

        emf.close();
    }
}
