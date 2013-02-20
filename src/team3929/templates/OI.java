/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author PROGRAMING FRC 2013
 */
public class OI {

    Joystick attack1;
    Joystick attack2;
    Madcatz madcatz;

    public OI() {
        
        madcatz = new Madcatz(RobotMap.MadcatzPort);    //Definition
        attack1 = new Joystick(RobotMap.JoystickOnePort);
        attack2 = new Joystick(RobotMap.JoystickTwoPort);

    }

    public boolean checkGamepadButton(int buttonNumber) {//easier to check if a button is pressed
        return getGamepad().getButton(buttonNumber);
    }

    public double getGamepadTriggerValue() {//returns madcatz z axis
        //note that leftTrigger pushes z axi down, as right accomplishes the contrary
        return getGamepad().getTrigger();
    }

    public double getGamepadLeftY() {//get left joy Y
        return getGamepad().getLeftY();
    }

    public double getGamepadRightY() {//get right joystick Y
        return getGamepad().getRightY();
    }

    public double getGamepadLeftX() {
        return getGamepad().getLeftX();
    }

    public double getAttackY() {//return attack3 joystick y axis
        return getAttack().getY();
    }

    public double getAttackX() {//return attack3 joystick x axis 
        return getAttack().getX();
    }

    public boolean checkAttackButton(int button) {//check if a button is pressed
        return getAttack().getRawButton(button);
    }

    public boolean checkAttackRealButton(Joystick.ButtonType button) {//check if a button is pressed
        return getAttack().getButton(button);
    }

    public double getAttackSecondaryY() {//return attack3 joystick y axis
        return getSecondaryAttack().getY();
    }

    public double getAttackSecondaryX() {//return attack3 joystick x axis
        return getSecondaryAttack().getX();
    }

    public boolean checkAttackSecondaryButton(Joystick.ButtonType button) {//check if a button is pressed
        return getAttack().getButton(button);
    }

    public Joystick getAttack() {//returns attack joystick
        return attack1;
    }

    public Joystick getSecondaryAttack() {
        return attack2;
    }

    public Madcatz getGamepad() { //Returns a madcatz
        return madcatz;
    }
}
