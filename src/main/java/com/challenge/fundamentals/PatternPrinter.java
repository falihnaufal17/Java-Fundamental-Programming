/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.fundamentals;

/**
 *
 * @author falih
 */
public class PatternPrinter {

    public static void main(String[] args) {
        // TODO: Print these patterns using nested loops:

        // Pattern 1: Right triangle
        // *
        // **
        // ***
        // ****
        // *****
        // Pattern 2: Number pyramid
        //     1
        //    121
        //   12321
        //  1234321
        // 123454321
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j > 1; j--) {
                System.out.print("*");
            }
            System.out.println("*");
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l);
            }
            System.out.println();
        }
    }
}
