package com.Pluralsight;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.hibernate.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


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

    public static List<Transactions> getFromDatabase(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT t FROM Transactions t";

        TypedQuery<Transactions> query = em.createQuery(jpql, Transactions.class);
        List<Transactions> list = query.getResultList();
        em.close();
        emf.close();
        return list;
    }

    public static void getFromCSV(){

        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Transactions> transactions = new ArrayList<>();

            bufferedReader.readLine(); // Skip line with the column headings
            String line ;
            while( (line=bufferedReader.readLine())!=null ){
                Transactions transactions1 = new Transactions(line);
                transactions.add(transactions1);
                addToDatabase(transactions1);
                addToDatabase(transactions1);
            }
           /*
           Transaction::getDate extracts the date from a Transaction object
           Comparator.comparing takes in that function and returns a comparator using the date as a sort key
           i.e it's basically saying "given a list of objects of type X, which part of X do you want sort by?"
           I decided to use it here so transactions would be sorted by date in the ArrayList
            */
            bufferedReader.close();
            transactions.sort(Comparator.comparing(Transactions::getDate));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

