package intermediate;

import intermediate.PasswordResult;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author falih
 */
public class EnhancedPasswordChecker {

    public static PasswordResult checkPassword(String password) {
        int score = 0;
        ArrayList<String> feedback = new ArrayList<>();

        if (checkLength(password, feedback)) {
            score++;
        }
        if (checkLowerCase(password, feedback)) {
            score++;
        }
        if (checkUpperCase(password, feedback)) {
            score++;
        }
        if (checkNumbers(password, feedback)) {
            score++;
        }
        if (checkSpecialChars(password, feedback)) {
            score++;
        }

        checkCommonPatterns(password, feedback);
        checkSequentialChars(password, feedback);
        checkRepeatedChars(password, feedback);
        calculateEntropy(password, feedback);

        return new PasswordResult(score, feedback);
    }

    // Basic checks methods with detailed feedback
    private static boolean checkLength(String password, List<String> feedback) {
        if (password.length() >= 8) {
            feedback.add("Length: Good (" + password.length() + " characters)");
            return true;
        } else {
            feedback.add("Must be at least 8 characters");
            return false;
        }
    }

    private static boolean checkLowerCase(String password, List<String> feedback) {
        if (password.matches(".*[a-z].*")) {
            feedback.add("Lowercase letters: Present");
            return true;
        } else {
            feedback.add("Lowercase Letters: Missing");
            return false;
        }
    }

    private static boolean checkUpperCase(String password, List<String> feedback) {
        if (password.matches(".*[A-Z].*")) {
            feedback.add("Uppercase letters: Present");
            return true;
        } else {
            feedback.add("Uppercase letters: Missing");
            return false;
        }
    }

    private static boolean checkNumbers(String password, List<String> feedback) {
        if (password.matches(".*[0-9].*")) {
            feedback.add("Numbers: Present");
            return true;
        } else {
            feedback.add("Numbers: Missing");
            return false;
        }
    }

    private static boolean checkSpecialChars(String password, List<String> feedback) {
        if (password.matches(".*[!@#$%^&*()].*")) {
            feedback.add("Special characters: Present");
            return true;
        } else {
            feedback.add("Special characters: Missing (use !@#$%^&*()");
            return false;
        }
    }

    private static void checkCommonPatterns(String password, List<String> feedback) {
        String[] weakPatterns = {
            "123", "password", "qwerty", "admin", "hello", "welcome", "123456", "letmein", "monkey", "abc123"
        };

        String lowerPassword = password.toLowerCase();
        for (String pattern : weakPatterns) {
            if (lowerPassword.contains(pattern)) {
                feedback.add("⚠️  Contains common pattern: '" + pattern + "'");
            }
        }
    }

    private static void checkSequentialChars(String password, List<String> feedback) {
        boolean hasSequential = false;

        for (int i = 0; i < password.length() - 2; i++) {
            char c1 = password.charAt(i);
            char c2 = password.charAt(i + 1);
            char c3 = password.charAt(i + 2);

            if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && Character.isLetterOrDigit(c3)) {
                if (c2 == c1 + 1 && c3 == c2 + 1) {
                    feedback.add("\"⚠️  Contains sequential characters\"");
                    hasSequential = true;
                    break;
                }
            }
        }

        if (hasSequential) {
            feedback.add("Security: Contains sequential characters");
        } else {
            feedback.add("Security: No sequential patterns");
        }
    }

    private static void checkRepeatedChars(String password, List<String> feedback) {
        for (int i = 0; i < password.length(); i++) {
            char c1 = password.charAt(i);
            char c2 = password.charAt(i);
            char c3 = password.charAt(i);

            if (c1 == c2 && c2 == c3) {
                feedback.add("⚠️  Contains repeated characters");
                break;
            }
        }
    }

    private static void calculateEntropy(String password, List<String> feedback) {
        int poolSize = 0;

        if (password.matches(".*[a-z].*")) {
            poolSize += 26;
        }
        if (password.matches(".*[A-Z].*")) {
            poolSize += 26;
        }
        if (password.matches(".*[0-9].*")) {
            poolSize += 10;
        }
        if (password.matches(".*[!@#$%^&*()].*")) {
            poolSize += 10;
        }

        double entrophy = password.length() * Math.log(poolSize) / Math.log(2);
        feedback.add("\"🔢 Password entropy: \" + String.format(\"%.1f bits\", entropy)");

        if (entrophy < 40) {
            feedback.add("\"💡 Consider longer password for better security\"");
        }
    }
}
