/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author falih
 */
public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; //1 - 100
        int attempts = 0;
        int maxAttempts = 7;
        boolean hasWon = false;

        System.out.println("I'm thingking of a number between 1 and 100!");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");
        System.out.println("");

        while (attempts < maxAttempts) {
            System.out.println("Attempt: " + (attempts + 1) + "/" + maxAttempts);
            System.out.print("Guess number: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();

            if (number < 1 || number > 100) {
                System.out.println("Please enter a number between 1-100!");
                continue;
            }

            if (secretNumber == number) {
                hasWon = true;
                break;
            } else if (number > secretNumber) {
                System.out.println("Hints: too high!");
            } else {
                System.out.println("Hints: too low");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts - 1));
            System.out.println(); // Add spacing
            attempts++;
        }

        System.out.println("");
        if (hasWon) {
            System.out.println("Congratulations you win!");
            System.out.println("Attempts: " + (attempts + 1));
        } else {
            System.out.println("The answer is: " + secretNumber);
            System.out.println("You Lost! Game Over!");
        }

        scanner.close();
    }
}
