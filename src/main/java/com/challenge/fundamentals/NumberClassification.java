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
public class NumberClassification {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input number: ");
        int number = scanner.nextInt();

        String sign;
        String evenOdd;
        String digitType;

        if (number < 0) {
            sign = "negative";
        } else if (number > 0) {
            sign = "positive";

        } else {
            sign = "zero";
        }

        evenOdd = (number % 2 == 0) ? "even" : "odd";

        digitType = (number >= -9 && number <= 9) ? "single-digit" : "multi-digit";

        System.out.printf("%d is %s, %s, and %s", number, sign, evenOdd, digitType);

        scanner.close();
    }
}
