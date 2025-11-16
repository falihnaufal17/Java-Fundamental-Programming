/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

import java.util.Scanner;

/**
 *
 * @author falih
 */
public class SimpleATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Starting balance
        boolean running = true;

        System.out.println("Welcome to Simple ATM!");

        while (running) {
            System.out.println("MENU ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter Menu Number: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter number");
            }

            int menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 1 -> {
                    System.out.println("Check Balance");
                    System.out.println("-------------");
                    System.out.println("Your balance is %s".formatted(Double.toString(balance)));
                    System.out.println();
                    System.out.println("1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.println("Enter navigation number:");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 2 -> {
                    boolean runningDeposit = true;

                    System.out.println("Deposit Money");
                    System.out.println("-------------");
                    System.out.println("Your balance is %s".formatted(Double.toString(balance)));

                    while (runningDeposit) {

                        System.out.print("How much for deposit? ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Please enter number");
                            scanner.next();
                            continue;
                        }
                        double deposit = scanner.nextDouble();

                        if (deposit > 0) {
                            balance += deposit;
                            runningDeposit = false;
                        } else {
                            System.out.println("Please enter greater than 0");
                        }

                    }

                    System.out.println("Deposit Successfully! Your balance now is %s".formatted(Double.toString(balance)));
                    System.out.println();
                    System.out.println("1. Back To Menu");
                    System.out.println("0. Exit");
                    System.out.print("Enter navigation number: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter number");
                        scanner.next();
                        continue;
                    }

                    int navigationNumber = scanner.nextInt();

                    if (navigationNumber == 0) {
                        running = false;
                    }
                }
                case 3 -> {
                    boolean runningWithdraw = true;
                    System.out.println("Withdraw Money");
                    System.out.println("-------------");
                    System.out.println("Your balance is %s".formatted(balance));

                    while (runningWithdraw) {
                        System.out.print("How much for withdraw? ");

                        if (!scanner.hasNextDouble()) {
                            System.out.println("Please enter a valid number!");
                            scanner.next();
                            continue;  // ← Add this
                        }

                        double withdraw = scanner.nextDouble();

                        if (withdraw <= 0) {
                            System.out.println("Please enter amount greater than 0");
                        } else if (withdraw > balance) {
                            System.out.println("Your balance is not enough!");
                        } else {
                            balance -= withdraw;
                            runningWithdraw = false;
                            System.out.println("Withdraw Successfully! Your balance now is " + balance);
                        }
                    }
                }
                case 4 ->
                    running = false;
                default -> {
                    System.out.println("Invalid option! Please choose 1-4.");
                }
            }
        }

        System.out.println("Program exit successfully!");
        scanner.close();
    }
}
