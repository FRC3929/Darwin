/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class ShooterCommand extends CommandBase {

    public ShooterCommand() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.configureCAN();
        shooter.startCAN();
    }

    protected void execute() {
        if (shooter.didCANReset()) {
            shooter.configureCAN();
            // shooter.startCAN(); //FIXME do we need this???
        }
        double targetMotorVoltage = oi.getAttackY() * 10.5; // maximum voltage when at limit of stick
        shooter.spinMotors(targetMotorVoltage, targetMotorVoltage, targetMotorVoltage);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.stopCAN();
    }

    protected void interrupted() {
    }
}
