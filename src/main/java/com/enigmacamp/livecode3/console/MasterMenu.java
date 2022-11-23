package com.enigmacamp.livecode3.console;

import com.enigmacamp.livecode3.constants.Education;
import com.enigmacamp.livecode3.entity.Trainee;
import com.enigmacamp.livecode3.entity.UserCredential;
import com.enigmacamp.livecode3.repository.implementations.TraineeRepo;
import com.enigmacamp.livecode3.repository.implementations.UserCredentialRepo;
import com.enigmacamp.livecode3.service.implementations.TraineeService;
import com.enigmacamp.livecode3.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class MasterMenu {
    private static final Scanner in = new Scanner(System.in);
    private static Boolean isClosed = false;
    private static final EntityManager em = JpaUtil.getEntityManager();
    private static final TraineeRepo traineeRepo = new TraineeRepo(em);
    private static final UserCredentialRepo usrRepo = new UserCredentialRepo(em);
    private static final TraineeService traineeService = new TraineeService(traineeRepo, usrRepo);
    private static String selectMenu() {
        String menu =   "\n=== main menu ===\n"
                + "\n1. register\n"
                + "2. activate user\n"
                + "3. sign in\n"
                + "0. exit\n";
        System.out.println(menu);

        System.out.print("select menu : ");

        return in.nextLine();
    }

    public static void run() throws SQLException {
        System.out.println("=== yuk ngoding ===");
        startMenu();
    }

    private static void startMenu() throws SQLException {
        String selectedMenu = selectMenu();

        while (!isClosed) {
            try {
                if (selectedMenu.equalsIgnoreCase("1")) {
                    System.out.println("\n=== register ===");

                    System.out.print("enter first name: ");
                    String firstName = in.nextLine();
                    System.out.print("enter last name: ");
                    String lastName = in.nextLine();
                    System.out.print("enter nickname: ");
                    String nickname = in.nextLine();
                    System.out.print("enter address: ");
                    String address = in.nextLine();
                    System.out.print("enter email: ");
                    String email = in.nextLine();
                    System.out.print("enter phone number: ");
                    String phoneNumber = in.nextLine();
                    System.out.print("enter id card number: ");
                    String idCardNumber = in.nextLine();
                    System.out.print("enter last education (SMA, SMK, S1, S2, D3, D4): ");
                    String lastEducation = in.nextLine();

                    Education enumLastEducation = null;

                    for (Education ed : Education.values()) {
                        if(ed.toString().equalsIgnoreCase(lastEducation)) enumLastEducation = ed;
                    }

                    Trainee trainee = new Trainee();
                    trainee.setFirstName(firstName);
                    trainee.setLastName(lastName);
                    trainee.setNickname(nickname);
                    trainee.setAddress(address);
                    trainee.setEmail(email);
                    trainee.setPhoneNumber(phoneNumber);
                    trainee.setIdCardNumber(idCardNumber);
                    trainee.setLastEducation(enumLastEducation);

                    UserCredential userCredential = new UserCredential();
                    userCredential.setEmail(trainee.getEmail());
                    userCredential.setPassword(null);
                    userCredential.setIsActive(false);

                    trainee.setUserCredential(userCredential);

                    traineeService.register(trainee);

                    startMenu();
                } else if (selectedMenu.equalsIgnoreCase("2")) {
                    System.out.println("\n=== activate user ===");

                    System.out.print("enter registered email: ");

                    String registeredEmail = in.nextLine();

                    UserCredential usr = traineeService.findUserByEmail(registeredEmail);

                    if (usr == null) {
                        System.out.println("user not found");
                    } else {
                        System.out.print("user found, enter new password: ");
                        String password = in.nextLine();

                        traineeService.setUserPassword(usr, password);
                        traineeService.generateActivationCode(usr);
                        traineeService.activateUser(usr);

                        System.out.printf("your activation code: %s", usr.getActivationCode() + "\n");
                    }

                    startMenu();
                } else if (selectedMenu.equalsIgnoreCase("3")) {
                    System.out.println("\n=== sign in ===");

                    startMenu();
                } else if (selectedMenu.equalsIgnoreCase("0")) {
                    System.out.println("\n=== goodbye ===");
                    em.close();
                    isClosed = true;
                    break;
                } else {
                    System.err.println("invalid input\n");
                    startMenu();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                startMenu();
            }
        }
    }
}
