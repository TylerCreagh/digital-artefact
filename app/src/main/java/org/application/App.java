package org.application;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<String> targetType = new ArrayList<String>();
    public static ArrayList<String> hitOrMiss = new ArrayList<String>();
    public static ArrayList<Double> verticalDistance = new ArrayList<Double>();
    public static  Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isValid = true;
            System.out.println("        _____");
            System.out.println("    ,-:` \\;',`'-,");
            System.out.println(" .'-;_,;  ':-;_,'.");
            System.out.println("/;   '/    ,  _`.-\\");
            System.out.println("| '`. (`     /` ` \\|      Welcome to a physics hit the target game,");   
            System.out.println("|:.  `\\`-.   \\_  /  |     The aim of the game is for a ball to hit a target");
            System.out.println("|     (   `,  .`\\ ;|      Would you like to play?");
            System.out.println(" \\     | .'    `-'/");
            System.out.println("  `; -',:'  .-  '``");
            System.out.println("     ``;-.`_,'_'/");
            System.out.println("          '`");
        do {
        String answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "YEAH":
            case "YES":
            case "Y":
            case "YE":
            isValid = true;
            getTargetType(input);
            //
            break;
            case "NO":
            case "NAH":
            case "N":
            isValid = true;
            System.out.println("Okay, this program will now end, \nGoodbye!");
            //
            break;
            default:
            System.out.println("Error on input, please try again: ");
            isValid = false;
            }
        } while(!isValid);
        input.close();
    }
    private static void getTargetType(Scanner input) {
        boolean isValid = true;
        do {
        System.out.println("What type of objective would you like to have? (Hoop/Target/Button)");
        String classType = input.nextLine().toUpperCase();
        if (classType.equals("HOOP")) {
            Hoop hoop = new Hoop();
            hoop.getValues();
            addToHitOrMiss(hoop.getOutcome());
            addToTargetType(hoop.getTargetType());
            statsOptions();
            isValid = true;
        } else if (classType.equals("TARGET")) {
            Target target = new Target();
            target.getValues();
            addToHitOrMiss(target.getOutcome());
            addToTargetType(target.getTargetType());
            statsOptions();
            isValid = true;
        } else if (classType.equals("BUTTON")) {
            Button button = new Button();
            button.getValues();

            isValid = true;
        } else {
            System.out.println("Error on input, please try again: ");
            isValid = false;
        }
        System.out.println("Would you like to go again? ");
        String choice = input.nextLine().toUpperCase();
        switch (choice) {
            case "YEAH":
            case "YES":
            case "Y":
                isValid = false;
                break;
            case "NO":
            case "N":
            case "NAH":
                System.out.println("Okay! The program will now exit, \nThanks for playing, Goodbye!");
                isValid = true;
                break;
            default:
            System.out.println("Error on input, please try again!");
            isValid = false;
                break;
        }
        } 
        while(!isValid);
    } 
    private static void statsOptions() {
        boolean isValid;
        System.out.println("Would you like to see your previous attempts (upto 5)?");
        do {
        String choice = input.nextLine().toUpperCase();
        switch (choice) {
            case "YEAH":
            case "YES":
            case "Y":
            isValid = true;
            displayPreviousStats();
            break;
            case "NO":
            case "N":
            case "NAH":
            isValid = true;
            break;
            default:
            System.out.println("Error on input, please try again!");
            isValid = false;
            }
        } while(!isValid);
    }
    protected static void addToHitOrMiss(String type) {
        if (hitOrMiss.size() < 5) { 
            hitOrMiss.add(type);
        } else {
            hitOrMiss.remove(0);
            hitOrMiss.add(type);
        }
    }
    protected static void addToTargetType(String type) {
        if (targetType.size() < 5) {
            targetType.add(type);
        } else {
            targetType.remove(0);
            targetType.add(type);
        }
    }
    protected static void displayPreviousStats() {
        System.out.println("");
        for (String objective : targetType) {
            System.out.print(objective + " ");
        }
        System.out.println("");
        for (String status : hitOrMiss) {
            System.out.print(status + " ");
        }
        System.out.println("");
    }
    // Getters and Setters
    // -------------------------------------------------------------------------------
    public ArrayList<String> getTargetType() {
        return targetType;
    }
    public void setTargetType(ArrayList<String> targetType) {
        this.targetType = targetType;
    }
    public ArrayList<String> getHitOrMiss() {
        return hitOrMiss;
    }
    public void setHitOrMiss(ArrayList<String> hitOrMiss) {
        this.hitOrMiss = hitOrMiss;
    }
}