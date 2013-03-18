/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import team3929.commands.FeederCommand;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Robotics
 */
public class Feeder extends Subsystem {

    public Victor pusher;
    public DigitalInput limSwitchBack;
   

    public Feeder() {
        pusher = new Victor(4);
    limSwitchBack = new DigitalInput(7);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new FeederCommand());
    }

    public void pushForward() {
        pusher.set(-0.5);

    }

    public void bringBack() {
        pusher.set(0.5);
    }

    public void stop() {
        pusher.set(0.0);
    }
    
     public boolean isBackLimPressed(){
         return !limSwitchBack.get();
     }

    
}