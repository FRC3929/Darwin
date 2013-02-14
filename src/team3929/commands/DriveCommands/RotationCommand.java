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

    public RotationCommand(double gyroSetpoint) {
        this.gyroSetpoint = gyroSetpoint;

    }

    public RotationCommand() {
        imageMidX = SmartDashboard.getNumber("imageX");
        if (imageMidX < 0) {
            gyroSetpoint = 0.0;
        } else {
            gyroSetpoint = Math.toDegrees(MathUtils.atan2(imageMidX - 160, f));
        }
    }

    protected void initialize() {
        Timer.delay(RobotMap.commandDelay);
        chassis.startEncoders();
        chassis.resetGyro();
        chassis.resetEncoders();
        double kP = 1.0E-2;
        double kI = 6.0E-4;
        double kD = 0.0;
        pidGyro = new PIDTool(kP, kI, kD, currSetpoint);
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

        if (currSetpoint < gyroSetpoint) {
            currSetpoint += setpointIncrement;
        }
        if (currSetpoint > gyroSetpoint) {
            currSetpoint -= setpointIncrement;
        }
        pidGyro.setSetpoint(currSetpoint);

        // Update SmartDashboard
        chassis.checkEncoders();
        SmartDashboard.putNumber("Gyro Angle", angle);

    }

    protected boolean isFinished() {
//        double angle = chassis.getGyro();
//        double rate = (angle - lastAngle);
//        lastAngle = angle;
        if ((Math.abs(gyroSetpoint - chassis.getGyro()) <= RobotMap.gyroSetpointTol)) {
            terminationCounter++;
        } else {
            terminationCounter = 0;
        }
        return (terminationCounter > 10);
        // && (Math.abs(rate) < 0.05)

    }

    protected void end() {
        Timer.delay(RobotMap.commandDelay);
    }

    protected void interrupted() {
    }
}
