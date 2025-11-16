/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.challenge.fundamentals;

/**
 *
 * @author falih
 */
public class Fundamentals {

    public static void main(String[] args) {
        String name = "Falih Naufal";
        int age = 24;
        String favoriteProgrammingLanguage = "Javascript";
        boolean isLikeCoffee = false;
        String message = """
                         Hello My name is %s, I'm %d years old.
                         My favorite programming language is %s.
                         Do I like coffee? %b
                         """.formatted(name, age, favoriteProgrammingLanguage, isLikeCoffee);

        System.out.println(message);
    }
}
