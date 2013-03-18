/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands.DriveCommands;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import team3929.templates.RobotMap;
// import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.CommandBase;

/**
 *
 * @author Carter
 */
public class TankDriveLogitech extends CommandBase {

    double JoyLeftY; //Declare Joysticks
    double JoyRightY;
    double MJoyLeftY;
    double MJoyRightY;
    double factor;
    // int reverser = 1; //This variable will allow for a button to control direction of motors

    public TankDriveLogitech(double factor) {
        this.factor = factor;
        requires(chassis); // reserve the chassis subsystem
    }
    private double joystickMapper(double x){
        if(x>=0){
            return x*x;
        }
        else{
            return -(x*x);
        }
    }
    protected void initialize() { // called once each time the command starts running
        chassis.startEncoders();
        //chassis.DriveSpeedController.disable();
        //chassis.gyro.setSensitivity(0.007);
        chassis.resetEncoders();
        chassis.resetGyro();
    }

    protected void execute() { // called repeatedly while the command is running
        chassis.checkEncoders();
        double valLeft = oi.getGamepadLeftY();
        double valRight = oi.getGamepadRightY();
        
        SmartDashboard.putNumber("Gyro Angle", chassis.getGyro());
        if(oi.checkGamepadButton(4)){
            JoyLeftY  = valLeft * factor;
            JoyRightY = valRight * -factor;
        }
        else{
            
        JoyLeftY  = -valLeft;
        JoyRightY = -valRight;
        }
        
        //chassis.setMotorCD(joystickMapper(JoyLeftY), joystickMapper(JoyRightY));
        chassis.tankDrive(JoyLeftY, JoyRightY);
        
                
    }

    protected boolean isFinished() { // called repeatedly and determines if the
        return false; // command is finished executing
    }
    
    // Called once after isFinished returns true
    protected void end() { // called after the command ends for clean up
        chassis.stopEncoders();
    }

    protected void interrupted() { // called if the command is preempted or canceled
    }
}
