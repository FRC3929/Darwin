/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

/**
 *
 * @author Robotics
 */
public class FullShooter extends CommandBase {
    public FullShooter(){
        requires(shooter);
    }
    protected void initialize() {
    }

    protected void execute() {
        shooter.spinMotors(-1.0, -1.0, -1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
