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
public class FizzBuzz {

    public static void main(String[] args) {
        // TODO: Print numbers from 1 to 100 with FizzBuzz rules

        // Example output:
        // 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16...
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
            return;
        }

        int number = scanner.nextInt();

        System.out.println("Extended FizzBuzz Rules:");
        System.out.println("• Fizz: divisible by 3");
        System.out.println("• Buzz: divisible by 5 OR 7");
        System.out.println("• FizzBuzz: divisible by 3 AND 5");
        System.out.println("• FizzBazz: divisible by 3 AND 7");
        System.out.println();

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0 && i % 7 == 0) {
                System.out.println("FizzBazz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0 || i % 7 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i + "");
            }
        }
    }
}
