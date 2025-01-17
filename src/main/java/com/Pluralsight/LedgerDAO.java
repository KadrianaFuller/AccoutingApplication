package com.Pluralsight;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class LedgerDAO {

    public static void addToDatabase(Transactions transaction) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(transaction);

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Transaction saved successfully!");
    }
}

