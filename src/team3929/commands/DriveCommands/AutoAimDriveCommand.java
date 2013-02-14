/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.commands.DriveCommands;

//import edu.wpi.first.smartdashboard.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.CommandBase;
import team3929.templates.RobotMap;
import team3929.tools.PIDTool;

/**
 *
 * @author Robotics
 */
public class AutoAimDriveCommand extends CommandBase {

    PIDTool pidAim;

    public AutoAimDriveCommand() {
    }

    protected void initialize() {


        chassis.resetGyro();

        double kP = -5.0E-3;
        double kI = 0.0;
        double kD = 0.0;
        pidAim = new PIDTool(kP, kI, kD, 160);
    }

    protected void execute() {
        double imageX = SmartDashboard.getNumber("imageX");
        double imageY = SmartDashboard.getNumber("imageY");
        System.out.println("imageX:"+imageX);
        System.out.println("imageY:"+imageY);
        double angle = chassis.getGyro();
        double gyroControl;

        if (imageX > 0) {
            gyroControl = pidAim.computeControl(imageX);
        } else {
            gyroControl = 0.0;
        }

        chassis.setMotorCD(0.0, gyroControl);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
