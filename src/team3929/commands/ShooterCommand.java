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
public ShooterCommand(){
    requires(shooter);
}
    protected void initialize() {
        
    }

    protected void execute() {
        shooter.spinMotors(oi.shooterControl.getY(), oi.shooterControl.getY(), oi.shooterControl.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
