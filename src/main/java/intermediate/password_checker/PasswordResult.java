/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intermediate.password_checker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author falih
 */
public class PasswordResult {

    private int score;
    private ArrayList<String> feedback;
    private String strength;

    public PasswordResult(int score, ArrayList<String> feedback) {
        this.score = score;
        this.feedback = feedback;
        this.strength = calculateStrength(score);
    }

    private String calculateStrength(int score) {
        if (score <= 2) {
            return "WEAK";
        } else if (score == 3) {
            return "MEDIUM";
        } else if (score == 4) {
            return "STRONG";
        } else {
            return "VERY_STRONG";
        }
    }

    public String getStrength() {
        return strength;
    }

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public int getScore() {
        return score;
    }
}
