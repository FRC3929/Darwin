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
public class PullBackFlicker extends CommandBase {

    public PullBackFlicker() {
        requires(feeder);
    }

    protected void initialize() {
    }

    protected void execute() {
        feeder.bringBack();
        SmartDashboard.putBoolean("limValue", feeder.isBackLimPressed());
    }

    protected boolean isFinished() {
        if (feeder.isBackLimPressed()) {
            feeder.stop();
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
