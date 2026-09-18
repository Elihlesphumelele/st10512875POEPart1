package com.mycompany.main;

// Imports Scanner so we can get user input
import java.util.Scanner;

// Create the Main class
public class Main {

    // Create Scanner for user input
    static Scanner input = new Scanner(System.in);

    // Store the user's entered details
    static String username;
    static String password;
    static String cellphone;

    // Store the registered username
    static String registeredUsername;

    // Store the registered password
    static String registeredPassword;

    // Store the registered cellphone number
    static String registeredCellphone;

    // Create the username checking method
    public static boolean checkUserName(String username) {

        // Username must have exactly 5 characters
        // and must contain an underscore
        if (username.length() == 5 && username.contains("_")) {
            return true;
        } else {
            return false;
        }
    }

    // Create the password checking method
    public static boolean checkPasswordComplexity(String password) {

        // Password must have at least 8 characters
        // and contain:
        // - At least one uppercase letter
        // - At least one lowercase letter
        // - At least one number
        // - At least one special character

        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*")) {

            return true;

        } else {
            return false;
        }
    }

    // Create the cellphone checking method
    public static boolean checkCellphoneNumber(String number) {

        // Number must start with +27
        // followed by exactly 9 digits
        if (number.matches("^\\+27[0-9]{9}$")) {
            return true;
        } else {
            return false;
        }
    }

    // Create the registration method
    public static void registerUser() {

        // Ask for username
        System.out.print("Enter your username: ");
        username = input.nextLine();

        // Ask for password
        System.out.print("Enter your password: ");
        password = input.nextLine();

        // Ask for cellphone number
        System.out.print("Enter your cellphone number (+27): ");
        cellphone = input.nextLine();

        // Check username
        boolean usernameCorrect = checkUserName(username);

        // Check password
        boolean passwordCorrect = checkPasswordComplexity(password);

        // Check cellphone number
        boolean phoneCorrect = checkCellphoneNumber(cellphone);

        // Check if all registration details are correct
        if (usernameCorrect && passwordCorrect && phoneCorrect) {

            // Save the valid username
            registeredUsername = username;

            // Save the valid password
            registeredPassword = password;

            // Save the valid cellphone number
            registeredCellphone = cellphone;

            // Display success message
            System.out.println("User registered successfully.");

        } else {

            // Display failure message
            System.out.println("Registration failed.");

            // Tell the user what went wrong
            if (!usernameCorrect) {
                System.out.println(
                    "Username must be exactly 5 characters long and contain an underscore (_)."
                );
            }

            if (!passwordCorrect) {
                System.out.println(
                    "Password must be at least 8 characters and contain an uppercase letter, "
                    + "lowercase letter, number, and special character."
                );
            }

            if (!phoneCorrect) {
                System.out.println(
                    "Cellphone number must start with +27 followed by exactly 9 digits."
                );
            }
        }
    }

    // Create the login method
    public static boolean loginUser(String username, String password) {

        // Compare entered details with registered details
        if (username.equals(registeredUsername)
                && password.equals(registeredPassword)) {

            return true;

        } else {
            return false;
        }
    }

    // Create the login status method
    public static String returnLoginStatus(boolean loginSuccessful) {

        // Check if login was successful
        if (loginSuccessful) {

            // Welcome the user using their registered username
            return "Welcome " + registeredUsername
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }

    // Main method where the program starts
    public static void main(String[] args) {

        // Call registration method
        registerUser();

        // Only attempt login if registration was successful
        if (registeredUsername != null && registeredPassword != null) {

            // Call login method
            boolean loginSuccessful = loginUser(username, password);

            // Call login status method
            System.out.println(returnLoginStatus(loginSuccessful));
        }
    }
}
