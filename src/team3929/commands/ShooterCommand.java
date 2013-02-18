/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class ShooterCommand extends CommandBase {

    int count = 0;

    public ShooterCommand() {
        requires(shooter);
    }

    protected void initialize() {
        shooter.stopCAN();
        shooter.configureCAN();
        shooter.startCAN();
    }

    protected void execute() {
        if (shooter.didCANReset()) {
            shooter.stopCAN();
            shooter.configureCAN();
            shooter.startCAN();
        }

        double targetMotorVoltage = oi.getGamepadLeftY() * 15.0; // maximum voltage when at limit of stick
        if(Math.abs(targetMotorVoltage) < 3.0) {
            targetMotorVoltage = 0;
        }
        shooter.spinMotors(targetMotorVoltage, targetMotorVoltage, targetMotorVoltage);
        if (count % 100 == 0) {
            shooter.showStats();
        }
        count++;
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
