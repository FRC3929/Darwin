/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.CommandBase;

/**
 *
 * @author Robotics
 */
public class FeederCommand extends CommandBase {
    
    public FeederCommand() {
        requires(feeder);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {

        if (oi.checkAttackButton(2)) {
            feeder.bringBack();
        } else if (!oi.checkAttackButton(2) && !oi.checkAttackButton(3)) {
            feeder.stop();
        } else if (oi.checkAttackButton(3)) {
            feeder.pushForward();
        }
        if(CommandBase.oi.checkAttackButton(4)){
            Flick f = new Flick();
            f.start();
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
