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
    public DigitalInput limSwitch1;
    public DigitalInput limSwitch2;

    public Feeder() {
        pusher = new Victor(4);
//    limSwitch1 = new DigitalInput(7);
//    limSwitch2 = new DigitalInput(8);
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
    
//     public boolean isBackLimPressed(){
//         return !limSwitch2.get();
//     }
//     public boolean isFrontLimPressed(){
//         return !limSwitch1.get();
//     }
    
}