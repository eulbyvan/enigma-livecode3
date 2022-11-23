package com.enigmacamp.livecode3.repository.implementations;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.ITraineeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class TraineeRepo implements ITraineeRepo {
    private final EntityManager em;

    public TraineeRepo(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public void create(Trainee trainee) {
        try {
            em.getTransaction().begin();
            em.persist(trainee);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.printf(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trainee findByEmail(String email) {
        TypedQuery<Trainee> traineeTypedQuery = em.createNamedQuery("Trainee.findByEmail", Trainee.class);
        traineeTypedQuery.setParameter("email", email);

        Trainee trainee = new Trainee();

        try {
            trainee = traineeTypedQuery.getSingleResult();
        } catch (Exception e) {
            // empty catch so that trainee can be null
        }

        return trainee;
    }
}
