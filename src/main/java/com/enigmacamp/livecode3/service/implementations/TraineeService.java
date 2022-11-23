package com.enigmacamp.livecode3.service.implementations;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.implementations.TraineeRepo;
import com.enigmacamp.livecode3.repository.implementations.UserCredentialRepo;
import com.enigmacamp.livecode3.service.ITraineeService;

import java.util.UUID;
import java.util.regex.Pattern;

public class TraineeService implements ITraineeService {
    private final TraineeRepo traineeRepo;
    private final UserCredentialRepo usrRepo;

    public TraineeService(TraineeRepo traineeRepo, UserCredentialRepo usrRepo) {
        this.traineeRepo = traineeRepo;
        this.usrRepo = usrRepo;
    }

    @Override
    public void register(Trainee trainee) {
        traineeRepo.create(trainee);
        System.out.println("new trainee has been added successfully");
    }

    @Override
    public void activateUser(UserCredential usr) {
        usrRepo.update(usr);
        System.out.printf("user %s has been activated successfully%n", usr.getEmail());
    }

    @Override
    public UserCredential findUserByEmail(String email) {
        return traineeRepo.findByEmail(email).getUserCredential();
    }

    @Override
    public void generateActivationCode(UserCredential usr) {
        usr.setActivationCode(UUID.randomUUID().toString());
        usr.setIsActive(true);
    }

    @Override
    public void setUserPassword(UserCredential usr, String password) {
        usr.setPassword(password);
    }


}
