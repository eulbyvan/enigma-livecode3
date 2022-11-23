package com.enigmacamp.livecode3.service.implementations;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.implementations.TraineeRepo;
import com.enigmacamp.livecode3.service.ITraineeService;

public class TraineeService implements ITraineeService {
    private final TraineeRepo traineeRepo;

    public TraineeService(TraineeRepo traineeRepo) {
        this.traineeRepo = traineeRepo;
    }

    @Override
    public void register(Trainee trainee) {
        traineeRepo.create(trainee);
        System.out.println("new trainee has been added successfully");
    }

    @Override
    public void activateUser(UserCredential userCredential) {
        System.out.printf("user %s has been activated successfully%n", userCredential.getEmail());
    }
}
