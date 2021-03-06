/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------
 author@ 3929ProgrammingTeam
 */
package team3929.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.AutoShoot;
import team3929.commands.CommandBase;
import team3929.commands.DriveCommands.MagVelCommand;
import team3929.commands.DriveCommands.DriveGroup;
import team3929.commands.DriveCommands.TankDriveLogitech;
import team3929.commands.FeederCommand;
import team3929.commands.Flick;
import team3929.commands.FullShooter;
import team3929.commands.HoodCommand;
import team3929.commands.HoodSetCommand;
import team3929.commands.ShooterCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Darwin extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
        CommandBase.init();
       
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit() {
        FullShooter fs = new FullShooter();
        fs.start();
        AutoShoot as = new AutoShoot();
        as.start();
    }

    public void autonomousPeriodic() {
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        TankDriveLogitech tank = new TankDriveLogitech(.3);
        tank.start();
        ShooterCommand sc = new ShooterCommand();
        sc.start();
        FeederCommand fc = new FeederCommand();
        fc.start();
        HoodCommand hc = new HoodCommand();
        hc.start();
     // probably don't need this
     //   ShooterCommand shooter = new ShooterCommand();
     //   shooter.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        Scheduler.getInstance().run();
    }
}
