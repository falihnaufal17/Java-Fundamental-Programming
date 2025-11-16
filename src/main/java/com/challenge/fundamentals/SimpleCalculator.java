/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

/**
 *
 * @author falih
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        int a = 15;
        int b = 4;

        System.out.printf("Numbers: %d and %d%n", a, b);
        System.out.printf("Addition: %d%n", a + b);
        System.out.printf("Substraction: %d%n", a - b);
        System.out.printf("Multiplication: %d%n", a * b);
        System.out.printf("Division: %d%n", a / b);
        System.out.printf("Modulus: %d%n", a % b);

        // Decimal division version
        System.out.printf("Decimal division: %.2f%n", (double) a / b);
    }
}
