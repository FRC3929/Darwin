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
            if (oi.checkAttackButton(5)) {
                hood.moveDown();
            }
            else if (!oi.checkAttackButton(5)) {
                hood.stop();
            }  
        } else if (!hood.isBotLimPressed()) {
            if (oi.checkAttackButton(4)) {
                hood.moveUp();
            }
            else if (!oi.checkAttackButton(5) && !oi.checkAttackButton(4)) {
                hood.stop();
            }  
        } else if (hood.isBotLimPressed() && hood.isTopLimPressed()) {
            if (oi.checkAttackButton(4)) {
                hood.moveUp();
            } else if (!oi.checkAttackButton(4) &&!oi.checkAttackButton(5)) {
                hood.stop();
            }  
            else if (oi.checkAttackButton(5)) {
                hood.moveDown();
            }
        }
        System.out.println("topLimSwitch:" + hood.topLim.get());
                
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
