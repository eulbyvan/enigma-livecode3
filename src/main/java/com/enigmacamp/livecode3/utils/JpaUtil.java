package com.enigmacamp.livecode3.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory;

    private static void getEntityManagerFactory() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        if (factory == null) {
            getEntityManagerFactory();
        }

        return factory.createEntityManager();
    }

    public static void shutDown() {
        if (factory != null) {
            factory.close();
        }
    }
}