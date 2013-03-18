/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import team3929.commands.DriveCommands.RotationCommand;

/**
 *
 * @author Robotics
 */
public class AutoShoot extends CommandGroup{

    
    public AutoShoot(){
        //addSequential(new RotationCommand());
        //addSequential(new HoodSetCommand(4.3));
        addSequential(new DelayCommand(1.5));
        addSequential(new Flick());
        addSequential(new DelayCommand(1.5));
        addSequential(new Flick());
        addSequential(new DelayCommand(1.5));
        addSequential(new Flick());
    }
    
    
}
