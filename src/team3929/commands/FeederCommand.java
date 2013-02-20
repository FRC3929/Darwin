/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
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
//        if (!feeder.isBackLimPressed() && !feeder.isFrontLimPressed()) {
        if (oi.checkAttackButton(6)) {
            
            feeder.pushForward();
            Timer.delay(0.4);
            feeder.stop();
            Timer.delay(1.0);
            feeder.bringBack();
            Timer.delay(0.35);
            feeder.stop();
        }
        if (oi.checkAttackButton(2)) {
            feeder.bringBack();
        } else if (!oi.checkAttackButton(2) && !oi.checkAttackButton(3)) {
            feeder.stop();
        } else if (oi.checkAttackButton(3)) {
            feeder.pushForward();
        }
//        } else if (feeder.isBackLimPressed()) {
//            if (oi.checkAttackButton(3)) {
//                feeder.pushForward();
//            } else if (!oi.checkAttackButton(3)) {
//                feeder.stop();
//            }            
////        } else if (feeder.isFrontLimPressed()) {
//            if (oi.checkAttackButton(6)) {
//                
//                feeder.pushForward();
//                Timer.delay(0.4);
//                feeder.stop();
//                Timer.delay(1.0);
//                feeder.bringBack();
//                Timer.delay(0.4);
//                feeder.stop();
//            }
//            
//            if (oi.checkAttackButton(2)) {
//                feeder.bringBack();
//            } else if (!oi.checkAttackButton(2)) {
//                feeder.stop();
//            }
        //}

//        if(feeder.isFrontLimPressed()){
//            if(oi.checkAttackButton(4)){
//            feeder.bringBack();
//            }
//        }
//        if(feeder.isBackLimPressed()){
//            if(oi.checkAttackButton(3)){
//        
//            feeder.pushForward();
//            }
//        }
        //if(!feeder.isBackLimPressed()&&!feeder.isFrontLimPressed()){
//       if(oi.checkAttackButton(3)){
//           feeder.pushForward();
//       }
//       else if(!oi.checkAttackButton(2)&&!oi.checkAttackButton(3)){
//            feeder.stop();
//       }
//       else if(oi.checkAttackButton(2)){
//           feeder.bringBack();
//       }
        // }
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
