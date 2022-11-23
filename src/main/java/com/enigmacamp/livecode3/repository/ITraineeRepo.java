package com.enigmacamp.livecode3.repository;

import com.enigmacamp.livecode3.entity.Trainee;

public interface ITraineeRepo {
    void create(Trainee trainee);
    Trainee findOne(int id);
}
