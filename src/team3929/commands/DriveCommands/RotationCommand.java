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
import com.sun.squawk.util.MathUtils;

/**
 *
 * @author Robotics
 */
public class RotationCommand extends CommandBase {

    PIDTool pidGyro;
    double gyroSetpoint;
    double currSetpoint = 0.0;
    double setpointIncrement = 0.72;
    double lastAngle = -1000.0;
    double speedLimit = 0.5;
    private int terminationCounter = 0;
    double imageMidX;
    final double f = 368;
    boolean visionServo = false;

    public RotationCommand(double gyroSetpoint) {
        this.gyroSetpoint = gyroSetpoint;
        visionServo = false;
    }

    public RotationCommand() {
        visionServo = true;
    }

    protected void initialize() {
        Timer.delay(RobotMap.commandDelay);
        chassis.startEncoders();
        chassis.resetGyro();
        chassis.resetEncoders();

        if (visionServo) {
            imageMidX = SmartDashboard.getNumber("targetX");
            if (imageMidX < 0) {
                gyroSetpoint = 0.0;
            } else {
                gyroSetpoint = 1.0*(Math.toDegrees(MathUtils.atan2(imageMidX - 160, f)));
            }
        }
        currSetpoint = 0.0;

        double kP = 1.0E-2;
        double kI = 5.0E-4;
        double kD = 0.0;
        pidGyro = new PIDTool(kP, kI, kD, currSetpoint);
        SmartDashboard.putNumber("Gyro Setpoint:",gyroSetpoint);
    }

    protected void execute() {
        double angle = chassis.getGyro();

        double gyroControl = pidGyro.computeControl(angle);
        
        if (gyroControl > speedLimit) {
            gyroControl = speedLimit;
        } else if (gyroControl < -speedLimit) {
            gyroControl = -speedLimit;
        }

        chassis.setMotorCD(0.0, gyroControl);

        // Update the setpoint in a ramp until you hit the final value
        if (currSetpoint < gyroSetpoint) {
            currSetpoint += setpointIncrement;
            if (currSetpoint > gyroSetpoint) {
                currSetpoint = gyroSetpoint;
            }
        }
        if (currSetpoint > gyroSetpoint) {
            currSetpoint -= setpointIncrement;
            if (currSetpoint < gyroSetpoint) {
                currSetpoint = gyroSetpoint;
            }
        }


        pidGyro.setSetpoint(currSetpoint);

        // Update SmartDashboard
        chassis.checkEncoders();
        SmartDashboard.putNumber("Gyro Angle", angle);

    }

    protected boolean isFinished() {
        if ((Math.abs(gyroSetpoint - chassis.getGyro()) <= RobotMap.gyroSetpointTol)) {
            terminationCounter++;
        } else {
            terminationCounter = 0;
        }
        return (terminationCounter > 10);
    }

    protected void end() {
        Timer.delay(RobotMap.commandDelay);
    }

    protected void interrupted() {
    }
}
