/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Robotics
 */
public class DelayCommand extends CommandBase {

    boolean done = false;
    double delay;

    public DelayCommand(double delay) {
        this.delay = delay;
    }

    protected void initialize() {
    }

    protected void execute() {
        Timer.delay(delay);
        done = true;
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
