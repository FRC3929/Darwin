/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Robotics
 */
public class PushForwardFlicker extends CommandBase{
    double t; 
    private boolean finished = false;
    
    public PushForwardFlicker(double t){
        requires(feeder);
        this.t = t;
    }

    protected void initialize() {
    }

    protected void execute() {
        feeder.pushForward();
        Timer.delay(t);
        finished = true;
        SmartDashboard.putBoolean("limValue", feeder.isBackLimPressed());
        feeder.stop();
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
