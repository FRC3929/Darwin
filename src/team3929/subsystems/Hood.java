/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import team3929.commands.HoodCommand;

/**
 *
 * @author Robotics
 */
public class Hood extends Subsystem{
public Victor hoodVictor;
public DigitalInput topLim;
public DigitalInput botLim;
public AnalogChannel pot;
  public Hood(){
      hoodVictor = new Victor(3);
      topLim = new DigitalInput(5);
      botLim = new DigitalInput(6);
      pot = new AnalogChannel(2);
  }

    protected void initDefaultCommand() {
        setDefaultCommand(new HoodCommand());
    }
    public double getPotValue(){
        return pot.getVoltage();
        
    }
    public boolean isTopLimPressed(){
        return topLim.get();
    }
    public boolean isBotLimPressed(){
        return botLim.get();
    }
    public void moveUp(){
        hoodVictor.set(0.7);
        
    }
    public void moveDown(){
        hoodVictor.set(-0.7);
    }

    public void stop() {
        hoodVictor.set(0.0);
    }
    
}
