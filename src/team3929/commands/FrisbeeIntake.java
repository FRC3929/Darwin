/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

/**
 *
 * @author Robotics
 */
public class FrisbeeIntake extends CommandBase {

    public FrisbeeIntake() {
        requires(intake);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (oi.checkAttackButton(3)) {
            intake.pushOut();
        } else if (!oi.checkAttackButton(3) && !oi.checkAttackButton(2)) {
            intake.turnOff();
        } else if (oi.checkAttackButton(2)) {
            intake.bringIn();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
