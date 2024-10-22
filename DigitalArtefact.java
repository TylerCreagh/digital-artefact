import java.util.Scanner;

public class DigitalArtefact {

// Methods
    public static void option1(String firstName, String lastName) {
        System.out.println("Great job " + firstName + ", you have selected the first option");
        System.out.println("Your full name is: " + firstName + " " + lastName);
    }
    public static void option2(String firstName, String companyName) {
        System.out.println("Great job " + firstName + ", you have selected the second option");
        System.out.println("You work at " + companyName + " Congratulations! ");
    }  
    public static void option3(String firstName, int yearsAtCompany) {
        System.out.println("Great job " + firstName + ", you have selected the third option");
        System.out.println("Most people work for 35 years, so you have " + (35 - yearsAtCompany) + " more years to go!");
    }
    public static void option4(String firstName) {
        System.out.println("Great job " + firstName + ", you have selected the fourth option");
        System.out.println("You are amazing, keep going!");

// Main Method
    }
    public static void main(String[] args) {
        String carryOn = "yes";
        Scanner input = new Scanner(System.in);
        System.out.println("what is your first name");
        String firstName = input.nextLine();
        System.out.println("Hello " + firstName + "!\n" + "What is your last name?");
        String lastName = input.nextLine();
        System.out.println("And what company do your work for?");
        String companyName = input.nextLine();
        System.out.println("And how many years have you been there for?");
        int yearsAtCompany = input.nextInt();
        System.out.println("Ok, all information gathered. \nWelcome to " + " " +firstName + " " + lastName + " Congratulations on working at " + companyName + " for " + yearsAtCompany + " years!" + "\nNow, let's begin...");
        System.out.println("In this programme you have 4 choices: ");
        System.out.println("Option 1: See your full name ");
        System.out.println("Option 2: Remember where you work ");
        System.out.println("Option 3; See how many years you have left until retirement ");
        System.out.println("Option 4: Hear some personalised words of encouragement ");

        while(!carryOn.toLowerCase().equals("no")) {

// Decision between 4 options.
            System.out.println("Plesase select (1-4)");
            int choice = input.nextInt();
            switch (choice) {
                case 1: 
                option1(firstName, lastName);
                break;
                case 2: 
                option2(firstName, companyName);
                break;
                case 3:
                option3(firstName, yearsAtCompany);
                break;
                case 4:
                option4(firstName);
                break;
                default:
                System.out.println("Error, incorrect option!");
                break;
            }
// Checking if the user wants to continue
        System.out.println("Would you like to continue? (yes/no)");
        input.nextLine();
        carryOn = input.nextLine();
        }
// Exit statement and scanner close
    input.close();
    System.out.println("The program will now exit, Goodbye! ");
    }
}