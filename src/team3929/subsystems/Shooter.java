/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
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
        CANJaguar motor1;
        CANJaguar motor2;
        CANJaguar motor3;
    public Shooter() {
        try{
        motor1 = new CANJaguar(RobotMap.CANPortFront);
        motor2 = new CANJaguar(RobotMap.CANPortCenter);
        motor3 = new CANJaguar(RobotMap.CANPortRear);
        }
        catch(CANTimeoutException e){
            SmartDashboard.putString("CANException", "Shooter motors aren't connected");
        }
        
    }
    public void spinMotors(double m1val,double m2val, double m3val){
        try {
            motor1.setX(m1val);
            motor2.setX(m2val);
            motor3.setX(m3val);
        } catch (CANTimeoutException ex) {
            SmartDashboard.putString("CANException", "Shooter motors dropped out");
        }
    }
    public void configureCAN(){
        try {
            motor1.changeControlMode(CANJaguar.ControlMode.kVoltage);
            
        } catch (CANTimeoutException ex) {
            SmartDashboard.putString("CANException", "Shooter motors dropped out on configure");
        }
    }
    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }
    
}
