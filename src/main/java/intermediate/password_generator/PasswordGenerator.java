/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intermediate.password_generator;

import intermediate.password_checker.EnhancedPasswordChecker;
import intermediate.password_checker.PasswordResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.xml.stream.events.Characters;

/**
 *
 * @author falih
 */
public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()";

    private Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        System.out.println("🎲 SMART PASSWORD GENERATOR");
        System.out.println("============================");

        while (true) {
            System.out.println("\nChoose generation mode:");
            System.out.println("1. Strong Random Password");
            System.out.println("2. Memorable Password (words)");
            System.out.println("3. Generate Multiple Passwords");
            System.out.println("4. Exit");
            System.out.print("Select option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 ->
                    generateStrongPassword(scanner, generator);
                case 2 ->
                    generateMemorablePassword(scanner, generator);
                case 3 ->
                    generateMultiplePasswords(scanner, generator);
                case 4 -> {
                    System.out.println("Thank you for using Password Generator!");
                    return;
                }
                default ->
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }

    public String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSpecialChars) {
        // validate inputs
        if (length < 8) {
            throw new IllegalArgumentException("Password lenght must be at least 8 characters");
        }

        StringBuilder charPool = new StringBuilder();
        StringBuilder password = new StringBuilder();

        if (includeLower) {
            charPool.append(LOWERCASE);
        }
        if (includeUpper) {
            charPool.append(UPPERCASE);
        }
        if (includeNumber) {
            charPool.append(NUMBER);
        }
        if (includeSpecialChars) {
            charPool.append(SPECIAL_CHARS);
        }

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        if (includeLower) {
            password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        }
        if (includeUpper) {
            password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        }
        if (includeNumber) {
            password.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
        }
        if (includeSpecialChars) {
            password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        }

        while (password.length() < length) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }

        return shuffleString(password.toString());
    }

    private String shuffleString(String password) {
        List<Character> characters = new ArrayList<>();
        for (Character c : password.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            result.append(c);
        }
        return result.toString();
    }

    public List<String> generateMultiplePasswords(int count, int length, boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSpecials) {
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            passwords.add(generatePassword(length, includeUpper, includeLower, includeNumber, includeSpecials));
        }

        return passwords;
    }

    public String generateMemorablePassword(int wordCount, String separator, boolean includeNumbers) {
        String[] commonWords = {
            "apple", "brave", "cloud", "dragon", "eagle", "flame", "globe", "heart", "island", "jewel", "knight", "light", "mountain", "night", "ocean", "planet", "queen", "river", "star", "tiger", "unity", "vortex", "water", "xenon", "year", "zenith"
        };

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            if (i > 0) {
                password.append(separator);
            }
            password.append(commonWords[random.nextInt(commonWords.length)]);
        }

        if (includeNumbers) {
            password.append(separator).append(random.nextInt(90) + 10);
        }

        return password.toString();
    }

    public void validateGeneratedPassword(String password) {
        PasswordResult result = EnhancedPasswordChecker.checkPassword(password);
        System.out.println("Generated Password: " + password);
        System.out.println("Strength: " + result.getStrength());
        System.out.println("Score: " + result.getScore() + "/5");
    }

    private static void generateStrongPassword(Scanner scanner, PasswordGenerator generator) {
        System.out.println("\n🔐 STRONG PASSWORD GENERATION");
        System.out.println("-----------------------------");

        System.out.print("Password length (8-64): ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean upper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean lower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean numbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean special = scanner.next().equalsIgnoreCase("y");

        try {
            String password = generator.generatePassword(length, upper, lower, numbers, special);
            System.out.println("\n✅ GENERATED PASSWORD: " + password);
            generator.validateGeneratedPassword(password);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void generateMemorablePassword(Scanner scanner, PasswordGenerator generator) {
        System.out.println("\n🧠 MEMORABLE PASSWORD GENERATION");
        System.out.println("--------------------------------");

        System.out.print("Number of words (3-6): ");
        int wordCount = scanner.nextInt();

        System.out.print("Separator (e.g., '-', '_', '.'): ");
        String separator = scanner.next();

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        String password = generator.generateMemorablePassword(wordCount, separator, includeNumbers);
        System.out.println("\n✅ MEMORABLE PASSWORD: " + password);
        generator.validateGeneratedPassword(password);
    }

    private static void generateMultiplePasswords(Scanner scanner, PasswordGenerator generator) {
        System.out.println("\n📊 MULTIPLE PASSWORD GENERATION");
        System.out.println("--------------------------------");

        System.out.print("How many passwords to generate? (1-10): ");
        int count = scanner.nextInt();

        System.out.print("Password length (8-64): ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean upper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean lower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean numbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean special = scanner.next().equalsIgnoreCase("y");

        try {
            List<String> passwords = generator.generateMultiplePasswords(count, length, upper, lower, numbers, special);

            System.out.println("\n✅ GENERATED PASSWORDS:");
            System.out.println("=======================");
            for (int i = 0; i < passwords.size(); i++) {
                System.out.println((i + 1) + ". " + passwords.get(i));
            }

            // Validate the first password as example
            if (!passwords.isEmpty()) {
                System.out.println("\n📊 Strength analysis of first password:");
                generator.validateGeneratedPassword(passwords.get(0));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
