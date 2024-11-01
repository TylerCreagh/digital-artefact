package org.application;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean isValid = true;
        Scanner input = new Scanner(System.in);
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
            Hoop goal = new Hoop();
            goal.getValues();
            isValid = true;
        } else if (classType.equals("TARGET")) {
            Target goal = new Target();
            goal.getValues();
            isValid = true;
        } else if (classType.equals("BUTTON")) {
            Button goal = new Button();
            goal.getValues();
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
}