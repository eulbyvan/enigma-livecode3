package com.enigmacamp.livecode3;

import com.enigmacamp.livecode3.console.MasterMenu;
import com.enigmacamp.livecode3.constants.Education;
import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.implementations.TraineeRepo;
import com.enigmacamp.livecode3.utils.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
//        try {
//            MasterMenu.run();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }

        EntityManager em = JpaUtil.getEntityManager();
        TraineeRepo tr = new TraineeRepo(em);

        System.out.println(tr.findByEmail("stu@pid"));
    }
}
