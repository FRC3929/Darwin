/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3929.commands.ShooterCommand;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class Shooter extends Subsystem {
    Jaguar motor1;
    Jaguar motor2;
    Jaguar motor3;
    public Shooter(){
        motor1 = new Jaguar(6);
        motor2 = new Jaguar(7);
        motor3 = new Jaguar(8);
        
    }
    public void spinMotors(double m1val,double m2val, double m3val){
        motor1.set(m1val);
        motor2.set(m2val);
        motor3.set(m3val);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }
    
}
