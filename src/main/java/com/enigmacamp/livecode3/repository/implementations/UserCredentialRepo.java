package com.enigmacamp.livecode3.repository.implementations;

import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.IUserCredentialRepo;
import com.enigmacamp.livecode3.utils.PasswordEncrypt;
import jakarta.persistence.EntityManager;

public class UserCredentialRepo implements IUserCredentialRepo {
    private final EntityManager em;

    public UserCredentialRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void update(UserCredential usr) {
        String encrypted = PasswordEncrypt.startEncrypt(usr.getPassword());
        usr.setPassword(encrypted);

        try {
            em.getTransaction().begin();
            em.merge(usr);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
