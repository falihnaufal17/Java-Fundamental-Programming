/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

/**
 *
 * @author falih
 */
public class QuickMaths {

    public static void main(String[] args) {
        // TODO: Calculate and print:
        // 1. Sum of first 50 natural numbers
        // 2. Factorial of 8 (8!)
        // 3. First 15 Fibonacci numbers
        // 4. All prime numbers between 1-100

        // Try to complete all 4 tasks in 15 minutes!
        int naturalNumbers = 50;
        int sumTotal = 0;
        for (int i = 1; i <= 50; i++) {
            sumTotal += i;
        }

        System.out.println("1. SUM 50 Natural Numbers: " + sumTotal);
        System.out.println();

        int factorialNumber = 8;
        long factorial = 1;

        for (int i = 1; i <= factorialNumber; i++) {
            factorial *= i;
        }

        System.out.println("2. Factorial of 8 (8!): " + factorial);

        System.out.print("3. Fibonacci");
        int a = 0, b = 1;
        System.out.println(a + " " + b + " ");
        for (int i = 2; i <= 15; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }

        System.out.println("\n4. Prime Numebrs (1-100)");
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

    }
}
