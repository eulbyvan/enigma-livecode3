package com.enigmacamp.livecode3.service;

import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;

public interface ITraineeService {
    void register(Trainee trainee);
    Trainee findTraineeByEmail(String email);
    void activateUser(UserCredential userCredential);
    UserCredential findUserByEmail(String email);
    void generateActivationCode(UserCredential usr);
    void setUserPassword(UserCredential usr, String password);
    Boolean authUser(String email, String password);
}
