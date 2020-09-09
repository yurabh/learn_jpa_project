package com.optimi_pessimis_locking;

import com.domain.Man;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOptimisticPessimisticLocking {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

                EntityManager em = emf.createEntityManager();

                EntityTransaction transaction = em.getTransaction();

                transaction.begin();

                Man manOne = em.find(Man.class, 1);

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                em.refresh(manOne);

                manOne.setName("Yura");

                transaction.commit();

                em.close();

                emf.close();
            }
        };

        new Thread(runnable).start();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Man man = em.find(Man.class, 1);

        man.setName("kola");

        transaction.commit();

        em.close();

        emf.close();
    }
}
