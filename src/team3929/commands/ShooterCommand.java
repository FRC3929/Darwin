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
    double targetVoltage;
    public ShooterCommand() {
        requires(shooter);
    }

    protected void initialize() {
       
    }

    protected void execute() {
        
//        double targetMotorVoltage = -oi.getGamepadLeftY() * 15.0; // maximum voltage when at limit of stick
//        if(Math.abs(targetMotorVoltage) < 3.0) {
//            targetMotorVoltage = 0;
//        }
//        shooter.spinMotors(targetMotorVoltage, targetMotorVoltage, targetMotorVoltage);
//        if (count % 100 == 0) {
//            shooter.showStats();
//        }
//        count++;
        targetVoltage = oi.getAttackY();
        shooter.spinMotors(targetVoltage,targetVoltage,targetVoltage);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
    }
}
