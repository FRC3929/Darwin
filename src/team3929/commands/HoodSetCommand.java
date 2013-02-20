/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

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
    }

    protected void initialize() {
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
    }

    protected boolean isFinished() {
        currPotValue = hood.getPotValue();
        if (dir * (currPotValue - desiredPotValue) >= 0.0) {
            hood.stop();
            return true;

        } else if (hood.isBotLimPressed() || hood.isTopLimPressed()) {
            hood.stop();
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}