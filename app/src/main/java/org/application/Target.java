package org.application;

public class Target extends Objective {
    private double timeOfFlight;
    private double maxHeight;
    @Override
    protected void calculate(float vObjDistance, float hObjDistance, float angle, float velocity, float projectileDiameter) {
        double initialVelocityV = (velocity * Math.sin(angle * Math.PI/180));
        double initialVelocityH = (velocity * Math.cos(angle * Math.PI/180));
        double timeOfFlight = (2 * initialVelocityV) / 9.81;
        double maxHeight = -(0.5 * -g * ((timeOfFlight/2) * (timeOfFlight/2)));
        double hTimeAtDisplacement = (hObjDistance / initialVelocityH);
        
        double vTimeAtDisplacement1 = -((initialVelocityV/-g) - (Math.sqrt(2*-g*vObjDistance + (initialVelocityV *initialVelocityV))) / -g);
        double vTimeAtDisplacement2 = -((initialVelocityV/-g) + (Math.sqrt(2*-g*vObjDistance + (initialVelocityV *initialVelocityV))) / -g);

        if ((hTimeAtDisplacement <= vTimeAtDisplacement1 + 0.25 && hTimeAtDisplacement >= vTimeAtDisplacement1) || (hTimeAtDisplacement >= vTimeAtDisplacement1 - 0.25 && hTimeAtDisplacement <= vTimeAtDisplacement1) || (hTimeAtDisplacement <= vTimeAtDisplacement2 + 0.25 && hTimeAtDisplacement >= vTimeAtDisplacement2) || (hTimeAtDisplacement >= vTimeAtDisplacement2 - 0.25 && hTimeAtDisplacement <= vTimeAtDisplacement2)) {
            System.out.println("Hit");
            setOutcome(true);
        } else { 
            System.out.println("Missed");
            setOutcome(false);
        }
    }
    @Override
    public String getTargetType() {
        return "Target";
    }
    @Override
    public String getOutcome() {
        return outcome;
    }
    public void setOutcome(boolean isSuccesful) {
        if (isSuccesful) {
            outcome = "Hit";
        } else {
            outcome = "Miss";
        }
    }
}
    // @Override
    // protected boolean isValidForObjective() {
        
    // }

