package com.example.tp_blumestein_esnault;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TableGenerator;

public class ConnectBdd {

    private static EntityManager em;

    public static void initConnection() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        em = emf.createEntityManager();

    }

    public static EntityManager getEntityManager() {
        return em;
    }

    public static void startTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void commitTransaction() {
        getEntityManager().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        getEntityManager().getTransaction().rollback();
    }

    public static void closeConnection() {
        em.close();
    }

}