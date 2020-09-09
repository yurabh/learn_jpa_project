package com.relationship.many_to_many.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;

public class TestUniManyToMany {

    public static void main(String[] args) {

        Product product = new Product("milk");

        Product productTwo = new Product("tomato");

        Product productThree = new Product("apple");


        Store store = new Store();

        store.setAddress("Gorodocjka");

        store.addProduct(product);

        store.addProduct(productTwo);

        store.addProduct(productThree);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(store);

        Store storeTwo = em.find(Store.class, 45);

        Product product1 = new Product();

        product1.setName("color");

        storeTwo.addProduct(product1);

        em.persist(product1);


        Product product2 = em.find(Product.class, 53);

        product2.setName("kola");

        Store storeUpdate = em.find(Store.class, 45);

        storeUpdate.setAddress("selena");

        storeUpdate.setProducts(Collections.singleton(product2));


        Store storeDelete = em.find(Store.class, 49);

        em.remove(storeDelete);

        Product product4 = em.find(Product.class, 50);

        storeDelete.removeProduct(product4);

        em.remove(product4);

        transaction.commit();

        em.close();

        emf.close();
    }
}
