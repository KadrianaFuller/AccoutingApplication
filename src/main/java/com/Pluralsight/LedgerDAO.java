package com.Pluralsight;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class LedgerDAO {

    public static void addToDatabase(Transactions transaction) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(transaction);

        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Transaction saved successfully!");
    }
}

