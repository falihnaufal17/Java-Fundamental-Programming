/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intermediate.password_checker;

import java.util.Scanner;

/**
 *
 * @author falih
 */
public class PasswordChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Enhanced Password Strength Checker");
        System.out.println("=====================================");

        while (true) {
            System.out.print("Enter password to check: ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("quit")) {
                break;
            }

            PasswordResult passwordResult = EnhancedPasswordChecker.checkPassword(password);

            System.out.println("\n" + "=".repeat(50));
            System.out.println("PASSWORD ANALYSIS RESULTS");
            System.out.println("=".repeat(50));
            System.out.println("Strength: " + passwordResult.getStrength() + " (Score: " + passwordResult.getScore() + "/5)");
            System.out.println("\nDetailed Feedback:");
            System.out.println("-".repeat(30));

            for (String feedback : passwordResult.getFeedback()) {
                System.out.println(feedback);
            }
            System.out.println("\n" + "=".repeat(50));
        }

        System.out.println("Thank you for using Enhanced Password Checker!");
        scanner.close();

    }
}
