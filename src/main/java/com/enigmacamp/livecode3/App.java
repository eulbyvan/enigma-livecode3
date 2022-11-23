package com.enigmacamp.livecode3;

import com.enigmacamp.livecode3.console.MasterMenu;
import com.enigmacamp.livecode3.repository.implementations.TraineeRepo;
import com.enigmacamp.livecode3.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        try {
            MasterMenu.run();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
