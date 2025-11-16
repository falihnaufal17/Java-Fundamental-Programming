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
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input iterate number: ");
        int iterateNumber = scanner.nextInt();

        System.out.print("How many tables: ");
        int tables = scanner.nextInt();

        if (tables <= 0) {
            System.out.print("Please enter a positive number!");

            return;
        }

        for (int table = 1; table <= tables; table++) {
            System.out.printf("%nTable for %d%n", table);

            for (int i = 1; i <= iterateNumber; i++) {
                System.out.printf("%d x %d = %d%n", table, i, table * i);
            }
        }
    }
}
