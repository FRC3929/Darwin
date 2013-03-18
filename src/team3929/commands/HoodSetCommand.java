/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Robotics
 */
public class HoodSetCommand extends CommandBase {

    double desiredPotValue;
    double currPotValue;
    int dir;

    public HoodSetCommand(double desiredPotValue) {
        requires(hood);
        this.desiredPotValue = desiredPotValue;
        currPotValue = hood.getPotValue();
        //This is because there is an offset of about .2 due to overshoot from timing
        if(currPotValue > this.desiredPotValue){
            this.desiredPotValue += .2;
        }
        else if(currPotValue < this.desiredPotValue){
            this.desiredPotValue -= .2;
        }
    }

    protected void initialize() {
        SmartDashboard.putString("hood done?", "no");
        currPotValue = hood.getPotValue();
        if (currPotValue > desiredPotValue) {
            hood.moveUp();
            dir = 1;
        } else if (currPotValue < desiredPotValue) {
            hood.moveDown();
            dir = -1;
        }

    }

    protected void execute() {
        if (dir == -1) {
            hood.moveDown();
        } else if (dir == 1) {
            hood.moveUp();
        }
    }

//    protected boolean isFinished() {
//        currPotValue = hood.getPotValue();
//        if (  (dir * (currPotValue - desiredPotValue) <= 0.0)  ||
//              (hood.isBotLimPressed()) || (hood.isTopLimPressed()) )
//        {
//            hood.stop();
//            SmartDashboard.putString("hood done?", "yes");
//            dir = 0;
//            return true;
//        } else {
//            SmartDashboard.putString("hood done?","no");
//            return false;
//        }
//
//    
    
    
    protected boolean isFinished() {
        currPotValue = hood.getPotValue();
        if (dir == 1) {
            if ((currPotValue < desiredPotValue) || hood.isTopLimPressed()) {
                hood.stop();
                return true;
            } else {
                return false;
            }
        } else if (dir == -1) {
            if ((currPotValue > desiredPotValue) || hood.isBotLimPressed()) {
                hood.stop();
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    protected void end() {
    }

    protected void interrupted() {
    }
}