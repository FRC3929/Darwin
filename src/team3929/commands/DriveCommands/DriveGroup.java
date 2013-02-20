/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands.DriveCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Robotics
 */
public class DriveGroup extends CommandGroup{
    public DriveGroup(){
        
        addSequential(new RotationCommand());
          
    }
}
