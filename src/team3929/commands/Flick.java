/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Robotics
 */
public class Flick extends CommandGroup{
    public Flick(){
        addSequential(new PullBackFlicker());
        addSequential(new PushForwardFlicker(0.4));
        addSequential(new PullBackFlicker());
        
        
    }

}