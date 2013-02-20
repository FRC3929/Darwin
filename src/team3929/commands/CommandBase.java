package team3929.commands;

import team3929.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.subsystems.Feeder;
import team3929.subsystems.Hood;
import team3929.subsystems.Intake;
import team3929.subsystems.Shooter;
//import team3929.subsystems.ArmControl;
import team3929.templates.OI;
//import team3929.subsystems.ExampleSubsystem;
//import team3929.subsystems.BallIntake;
//import team3929.subsystems.Shooter;
import team3929.templates.RobotMap;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Chassis chassis = new Chassis();
    public static Shooter shooter = new Shooter();
    public static Intake intake = new Intake();
    public static Hood hood = new Hood();
    public static Feeder feeder = new Feeder();
//    public static ArmControl armControl = new ArmControl();
//    public static Shooter shooter = new Shooter();
//    public static BallIntake ballIntake = new BallIntake();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(chassis);
        // SmartDashboard.putData(ballIntake);
        // SmartDashboard.putData(shooter);
        // SmartDashboard.putData(armControl);

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
