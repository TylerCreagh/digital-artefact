package org.application;
import java.util.Scanner;

public class Hoop extends Objective {
    private double timeOfFlight;
    private double maxHeight;
    private float hoopDiameter;
    // private Scanner input = new Scanner(System.in);
    public Hoop() {
        iniHoopDiam();
    }
    private void iniHoopDiam() {
        System.out.println("What is the diameter of the hoop? ");
        hoopDiameter = input.nextFloat();
    }
    @Override
    protected void calculate(float vObjDistance, float hObjDistance, float angle, float velocity, float projectileDiameter) {
        if (canFit(projectileDiameter)) {
            double initialVelocityV = (velocity * Math.sin(angle * Math.PI/180));
            double initialVelocityH = (velocity * Math.cos(angle * Math.PI/180));
            timeOfFlight = (2 * initialVelocityV) / 9.81;
            maxHeight = -(0.5 * -g * ((timeOfFlight/2) * (timeOfFlight/2)));
            // double hTimeAtDisplacement = (hObjDistance / initialVelocityH);

            // System.out.println(hTimeAtDisplacement);

            double vTimeAtDisplacement1 = -((initialVelocityV/-g) - (Math.sqrt(2*-g*vObjDistance + (initialVelocityV *initialVelocityV))) / -g);
            double vTimeAtDisplacement2 = -((initialVelocityV/-g) + (Math.sqrt(2*-g*vObjDistance + (initialVelocityV *initialVelocityV))) / -g);
            // Use for debugging 
            // System.out.println(vTimeAtDisplacement1);
            // System.out.println(vTimeAtDisplacement2);

            double hDisplacementAtVtimeAtDisplacement1 = initialVelocityH * vTimeAtDisplacement1;
            double hDisplacementAtVtimeAtDisplacement2 = initialVelocityH * vTimeAtDisplacement2;
            // Use for debugging 
            // System.out.println(hDisplacementAtVtimeAtDisplacement1);
            // System.out.println(hDisplacementAtVtimeAtDisplacement2);

            float leftHandOfHoop = (hObjDistance - (hoopDiameter/2));
            float rightHandOfHoop = (hObjDistance + (hoopDiameter/2));

            if (hDisplacementAtVtimeAtDisplacement1 < (rightHandOfHoop - projectileDiameter/2) && hDisplacementAtVtimeAtDisplacement1 > (leftHandOfHoop + (projectileDiameter/2)) || hDisplacementAtVtimeAtDisplacement2 < (rightHandOfHoop - projectileDiameter/2) && hDisplacementAtVtimeAtDisplacement2 > (leftHandOfHoop + (projectileDiameter/2))) {
                System.out.println("The projectile went through!");
                
            } else {
                System.out.println("The projectile did not go through the hoop!");
            }
        } 
        else {
            System.out.println("The projectile will not fit.");
        }
        System.out.println("Would you like to know the stats of the attempt?");
        input.nextLine();
        statsChoice(maxHeight, timeOfFlight);
        }
    private boolean canFit(Float projectileDiameter) {
        if (projectileDiameter > hoopDiameter || projectileDiameter == hoopDiameter) {
            return false;
        } else {
            return true;
        }
    }
}
