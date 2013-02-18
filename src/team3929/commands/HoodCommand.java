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
public class HoodCommand extends CommandBase {

    public HoodCommand() {
        requires(hood);
    }

    protected void initialize() {
    }

    protected void execute() {
        SmartDashboard.putNumber("Pot Accum:",hood.getPotValue());
        if (!hood.isTopLimPressed()) {
            if (oi.checkGamepadButton(5)) {
                hood.moveDown();
            }
            else if (!oi.checkGamepadButton(5)) {
                hood.stop();
            }  
        } else if (!hood.isBotLimPressed()) {
            if (oi.checkGamepadButton(6)) {
                hood.moveUp();
            }
            else if (!oi.checkGamepadButton(5) && !oi.checkGamepadButton(6)) {
                hood.stop();
            }  
        } else if (hood.isBotLimPressed() && hood.isTopLimPressed()) {
            if (oi.checkGamepadButton(6)) {
                hood.moveUp();
            } else if (!oi.checkGamepadButton(6) &&!oi.checkGamepadButton(5)) {
                hood.stop();
            }  
            else if (oi.checkGamepadButton(5)) {
                hood.moveDown();
            }
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
