package com.criteria;

import com.domain.Man;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class LearnCriteria {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("learn_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();


        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Man> query = builder.createQuery(Man.class);

        Root<Man> root = query.from(Man.class);

        query.select(root);

        TypedQuery<Man> emQuery = em.createQuery(query);

        List<Man> resultList = emQuery.getResultList();

        emQuery.getResultStream().forEach(System.out::println);


//        Path<Integer> pathId = root.get(Man_.id);
//
//        Path<String> pathName = root.get(Man_.name);
//
//        query.where(builder.equal(pathId, 1)).where(builder.equal(pathName, "John"));
//
//        query.orderBy(builder.desc(pathId));
//
//
//        CriteriaDelete<Man> criteriaDelete = builder.createCriteriaDelete(Man.class);
//
//        Root<Man> root1 = criteriaDelete.from(Man.class);

//        Path<Integer> path = root1.get(Man_.id);


//        criteriaDelete.where(builder.equal(path, 3));
//
//        em.createQuery(criteriaDelete).executeUpdate();

        transaction.commit();

        em.close();

        emf.close();
    }
}
