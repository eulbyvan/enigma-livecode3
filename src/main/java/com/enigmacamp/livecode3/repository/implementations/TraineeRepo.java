package com.enigmacamp.livecode3.repository.implementations;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.repository.ITraineeRepo;
import jakarta.persistence.EntityManager;

public class TraineeRepo implements ITraineeRepo {
    private EntityManager em;

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
    public Trainee findOne(int id) {
        return em.find(Trainee.class, id);
    }
}
