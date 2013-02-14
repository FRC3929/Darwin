/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3929.commands.FrisbeeIntake;

/**
 *
 * @author Robotics
 */
public class Intake extends Subsystem {

   Relay conveyor = new Relay(3);

    protected void initDefaultCommand() {
        setDefaultCommand(new FrisbeeIntake());
    }

    public void bringIn() {
        conveyor.set(Value.kOn);
        conveyor.set(Value.kForward);
    }

    public void pushOut() {
        conveyor.set(Value.kOn);
        conveyor.set(Value.kReverse);
    }

    public void turnOff() {
        conveyor.set(Value.kOff);
    }
}
