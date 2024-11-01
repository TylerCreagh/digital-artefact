package org.application;
import java.util.Scanner;

public abstract class Objective {
    public final double g = 9.81;
    Scanner input = new Scanner(System.in);

    public void getValues() {
        Scanner input = new Scanner(System.in);
        System.out.println("How high is the target? (in metres)");
        float vObjDistance = input.nextFloat();
        System.out.println("How far is the target? (in metres)");
        float hObjDistance = input.nextFloat();
        System.out.println("What is the initial angle that the ball is travelling at relative to the ground? (in degrees)");
        float angle = input.nextFloat();
        System.out.println("What is the initial velocity of the ball (in metres/second)");
        float velocity = input.nextFloat();
        System.out.println("What is the diameter of the projectile (in metres)");
        float projectileDiameter = input.nextFloat();
        calculate(vObjDistance, hObjDistance, angle, velocity, projectileDiameter);


    }
    protected void statsChoice(double maxHeight, double timeOfFlight) {
        String answer = input.nextLine().toUpperCase();
         switch (answer) {
            case "YES":
            case "YEAH":
            case "Y":
            case "YE":
            returnStats(maxHeight, timeOfFlight);
                break;
            default:
                break;
        }
    }
    protected void returnStats(double maxHeight, double timeOfFlight) {
        System.out.println("The projectile reached a maximum height of " + maxHeight + " metres!");
        System.out.println("The projectile travelled for " + timeOfFlight + " seconds! ");
    }
    protected abstract void calculate(float vObjDistance, float hObjDistance, float angle, float velocity, float projectileDiameter); 
}
