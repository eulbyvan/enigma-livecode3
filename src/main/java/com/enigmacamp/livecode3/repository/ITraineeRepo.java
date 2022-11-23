package com.enigmacamp.livecode3.repository;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;

public interface ITraineeRepo {
    void create(Trainee trainee);
    Trainee findByEmail(String email);
}
