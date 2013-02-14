/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands.DriveCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.CommandBase;
import team3929.templates.RobotMap;
import team3929.tools.PIDTool;

/**
 *
 * @author Robotics
 */
public class MagVelCommand extends CommandBase {

//    private double kPtheta = 0.07;
//    private double kPvel = 0.01;
//    private double v0 = 30.0;
    
    // Filter constants for velocity filter
    private final double alpha_vel = 0.2;
    private final double velocity_innovation_limit = 10000.0;
    double targetDistance;
    double targetVelocity;
    private double velEstimate = 0.0;
    
   PIDTool pidVel;
   PIDTool pidGyro;
    public MagVelCommand(double targetDistance,double targetVelocity) {
        
        requires(chassis);
        this.targetDistance = targetDistance;
        this.targetVelocity = targetVelocity;
    }
    
    // Function that returns a filtered estimate for the velocity
    public void UpdateFilteredVelocity() {
        // Read current velocity estimate
        double leftEncoderRate = chassis.getLeftEncoderRate();
        double rightEncoderRate = chassis.getRightEncoderRate();
        double avgVelocity = ((0.5) * ((leftEncoderRate) + (rightEncoderRate)));

        if (Math.abs(avgVelocity - velEstimate) <= velocity_innovation_limit) {
            velEstimate = (alpha_vel * avgVelocity) + ((1 - alpha_vel) * velEstimate);
        }
    }

    protected void initialize() {
        Timer.delay(RobotMap.commandDelay);
        chassis.resetEncoders();
        chassis.startEncoders();
        chassis.resetGyro();
        
        double kPvel = -1.0E-2;
        double kIvel = -1.0E-4;
        double kDvel = 0.0;
        double kPgyro = 1.0E-2;
        double kIgyro = 0.0;
        double kDgyro = 0.0;
        
        
        pidVel = new PIDTool(kPvel,kIvel,kDvel,targetVelocity);
        pidGyro = new PIDTool(kPgyro,kIgyro,kDgyro,0.0);
        // SmartDashboard.putNumber("kPtheta", kPtheta);
        // SmartDashboard.putNumber("kPvel", kPvel);

    }

    protected void execute() {
       
 
        // kPtheta = SmartDashboard.getNumber("kPtheta");
        // kPvel = SmartDashboard.getNumber("kPvel");
        
        UpdateFilteredVelocity();
        SmartDashboard.putNumber("VelEstimate:", velEstimate);
        
        double angle = chassis.getGyro();
        double velControl = pidVel.computeControl(velEstimate);
        double gyroControl = pidGyro.computeControl(angle);
        chassis.setMotorCD(velControl, gyroControl);
        // chassis.drive(0.3, -kPtheta * angle);

        // Update SmartDashboard
        chassis.checkEncoders();
        SmartDashboard.putNumber("Gyro Angle", angle);
    }

    protected boolean isFinished() {
        if(targetDistance < 0 ){
            return (chassis.getLeftEncoderDistance()<=targetDistance);
        }
        else if (targetDistance > 0){
            return (chassis.getLeftEncoderDistance()>=targetDistance);
        }
        else{
            return true;
        }
        
    }

    protected void end() {
        chassis.stopEncoders();
        Timer.delay(RobotMap.commandDelay);
    }

    protected void interrupted() {
    }
}
