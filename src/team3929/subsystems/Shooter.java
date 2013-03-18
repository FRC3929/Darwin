/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;


import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team3929.commands.ShooterCommand;
import team3929.templates.RobotMap;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class Shooter extends Subsystem {
//    Jaguar motor1;
//    Jaguar motor2;
//    Jaguar motor3;

//    CANJaguar motor1;
//    CANJaguar motor2;
//    CANJaguar motor3;
//    boolean canStatus = false;
//    private static final CANJaguar.ControlMode controlMode = CANJaguar.ControlMode.kVoltage;
//    private static final CANJaguar.NeutralMode neutralMode = CANJaguar.NeutralMode.kCoast;
//    private static final double kP = 10.0;
//    private static final double kI = 0.0;
//    private static final double kD = 0.0;
//    private static final int ENCODER_PULSES_PER_REV = 0;
    Jaguar motor1;
    Jaguar motor2;
    Jaguar motor3;

    public Shooter() {
        
        
            motor1 = new Jaguar(10);
            motor2 = new Jaguar(9);
            motor3 = new Jaguar(8);
        

    }

    public void spinMotors(double m1val, double m2val, double m3val) {
        
            motor1.set(-m1val);
            motor2.set(-m2val);
            motor3.set(-m3val);
            

        
    }

//    public void configureCAN() {
//        try {
//            motor1.configEncoderCodesPerRev(ENCODER_PULSES_PER_REV);
//            motor2.configEncoderCodesPerRev(ENCODER_PULSES_PER_REV);
//            motor3.configEncoderCodesPerRev(ENCODER_PULSES_PER_REV);
//            motor1.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
//            motor2.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
//            motor3.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
//
//            motor1.changeControlMode(controlMode);
//            motor2.changeControlMode(controlMode);
//            motor3.changeControlMode(controlMode);
//            motor1.configNeutralMode(neutralMode);
//            motor2.configNeutralMode(neutralMode);
//            motor3.configNeutralMode(neutralMode);
//            motor1.setPID(kP, kI, kD);
//            motor2.setPID(kP, kI, kD);
//            motor3.setPID(kP, kI, kD);
//            SmartDashboard.putString("CANException", "CAN Configured");
//            canStatus = true;
//
//        } catch (CANTimeoutException ex) {
//            canStatus = false;
//            SmartDashboard.putString("CANException", "Shooter motors dropped out on configure");
//        }
//    }

//    public boolean didCANReset() {
//        try {
//            return (motor1.getPowerCycled() || motor2.getPowerCycled() || motor3.getPowerCycled() || !canStatus);
//        } catch (CANTimeoutException ex) {
//            SmartDashboard.putString("CANException", "Shooter motors dropped out on check for powercycle");
//            return true;
//        }
//    }
//
//    public void startCAN() {
//        try {
//            motor1.enableControl();
//            motor2.enableControl();
//            motor3.enableControl();
//        } catch (CANTimeoutException ex) {
//            canStatus = false;
//            SmartDashboard.putString("CANException", "Shooter motors dropped out on start");
//        }
//    }
//
//    public void stopCAN() {
//        this.configureCAN();
//        try {
//            motor1.disableControl();
//            motor2.disableControl();
//            motor3.disableControl();
//        } catch (CANTimeoutException ex) {
//            SmartDashboard.putString("CANException", "Shooter motors dropped out on stop");
//        }
//    }
//
//    public void showStats() {
//        try {
//            SmartDashboard.putNumber("Motor1Voltage", motor1.getOutputVoltage());
//            SmartDashboard.putNumber("Motor2Voltage", motor2.getOutputVoltage());
//            SmartDashboard.putNumber("Motor3Voltage", motor3.getOutputVoltage());
//            SmartDashboard.putNumber("Motor1Current", motor1.getOutputCurrent());
//            SmartDashboard.putNumber("Motor2Current", motor2.getOutputCurrent());
//            SmartDashboard.putNumber("Motor3Current", motor3.getOutputCurrent());
//            SmartDashboard.putNumber("Motor1Speed", motor1.getSpeed());
//            SmartDashboard.putNumber("Motor2Speed", motor1.getSpeed());
//            SmartDashboard.putNumber("Motor3Speed", motor1.getSpeed());
//
//
//        } catch (CANTimeoutException ex) {
//            SmartDashboard.putString("CANException", "Shooter motors dropped out when reading values");
//        }
//    }

    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }
}
