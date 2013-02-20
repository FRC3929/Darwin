 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.DriveCommands.TankDriveLogitech;
import team3929.templates.RobotMap;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class Chassis extends Subsystem {

    private RobotDrive drive;
    private Gyro gyro;
    private Encoder rightEncoder;
    private Encoder leftEncoder;

    public Chassis() {

        drive = new RobotDrive(1, 2);
        rightEncoder = new Encoder(2, 1, false);
        leftEncoder = new Encoder(3, 4, false);
        rightEncoder.setDistancePerPulse(RobotMap.encoderDPP);
        leftEncoder.setDistancePerPulse(RobotMap.encoderDPP);
        rightEncoder.setReverseDirection(true);
        leftEncoder.setReverseDirection(false);
        gyro = new Gyro(1, 1);
        gyro.setSensitivity(0.007);

    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveLogitech()); // set default command
    }

    public void resetEncoders() {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    public void startEncoders() {
        rightEncoder.start();
        leftEncoder.start();
    }

    public double getGyro() {
        return gyro.getAngle();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public void checkEncoders() {
        SmartDashboard.putNumber("RightEncoder:", rightEncoder.getDistance());
        SmartDashboard.putNumber("LeftEncoder:", leftEncoder.getDistance());
        SmartDashboard.putNumber("RightEncoderRate:", rightEncoder.getRate());
        SmartDashboard.putNumber("LeftEncoderRate:", leftEncoder.getRate());
    }

    public double getLeftEncoderRate() {
        return leftEncoder.getRate();
    }

    public double getRightEncoderRate() {
        return rightEncoder.getRate();
    }

    public double getLeftEncoderDistance() {
        return leftEncoder.getDistance();
    }

    public double getRightEncoderDistance() {
        return rightEncoder.getDistance();
    }

    public void stopEncoders() {
        rightEncoder.stop();
        leftEncoder.stop();
    }

    public void drive(double speed, double curve) {
        drive.drive(speed, curve);
    }

    public void setMotorOutputs(double leftOutput, double rightOutput) {
        drive.setLeftRightMotorOutputs(leftOutput, rightOutput);
    }

    public void setMotorCD(double common, double differential) {
        drive.setLeftRightMotorOutputs(common - differential, common + differential);
    }

    public void goBackwards() {
        drive.tankDrive(-0.8, -0.8);
    }

    public void turnLeft() { // sets the motor speeds to start a left turn
        drive.tankDrive(0.0, 0.45);
    }

    public void driveWithJoystick(double stickLeft, double stickRight) {
        drive.tankDrive(stickLeft, stickRight);

    }

    public void arcadeDrive(double JoyLeftY, double JoyLeftX) {
        drive.arcadeDrive(JoyLeftY, JoyLeftX);
    }

    public void stop() {
        drive.tankDrive(0, 0);
    }
}
