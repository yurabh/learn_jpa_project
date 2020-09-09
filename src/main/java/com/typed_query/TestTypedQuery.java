package com.typed_query;

import com.domain.Man;

import javax.persistence.*;

public class TestTypedQuery {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<Man> query = em.createQuery("FROM Man m WHERE m.name LIKE 'J%'", Man.class);

        Man result = query.getSingleResult();

        result.setAge(120);

        System.out.println(result);

        TypedQuery<Man> typedQuery = em.createQuery("FROM Man m WHERE m.name LIKE :pattern", Man.class);

        typedQuery.setParameter("pattern", "J%");

        Man manTwo = typedQuery.getSingleResult();

        System.out.println(manTwo);

        transaction.commit();

        em.close();

        emf.close();
    }
}
