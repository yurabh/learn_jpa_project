package com.relationship.one_to_many.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToManyUni {

    public static void main(String[] args) {

        Leaf leaf1 = new Leaf(2);

        Leaf leaf2 = new Leaf(3);

        Tree tree = new Tree("Oak");

        tree.addLeaf(leaf1);

        tree.addLeaf(leaf2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(tree);

        Tree tree1 = em.find(Tree.class, 23);

        em.remove(tree1);

        transaction.commit();

        em.close();

        emf.close();
    }
}
