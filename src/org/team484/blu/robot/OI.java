
package org.team484.blu.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   
	//Initialize two joysticks
	Joystick driveStickLeft = new Joystick(RobotMap.driveStickLeft);
	Joystick driveStickRight = new Joystick(RobotMap.driveStickRight);
    Joystick shootStick = new Joystick(RobotMap.shootStick);
    
    //Accessors for left joystick position
    //================================================
    public double getDriveXLeft() {
        return driveStickLeft.getX();
    }
    public double getDriveZLeft() {
        return driveStickLeft.getZ();
    }
    public double getDriveYLeft() {
        return driveStickLeft.getY();
    }
    public boolean getDriveTriggerLeft() {
        return driveStickLeft.getTrigger();
    }
    //================================================
    
    //Accessors for right joystick position
    //================================================
    public double getDriveXRight() {
        return driveStickRight.getX();
    }
    public double getDriveZRight() {
        return driveStickRight.getZ();
    }
    public double getDriveYRight() {
        return driveStickRight.getY();
    }
    public boolean getDriveTriggerRight() {
        return driveStickRight.getTrigger();
    }
    //================================================
    
    //Button definitions
    
    //Button lowerArm = new JoystickButton(shootStick, RobotMap.lowerArm);
    //Button raiseArm = new JoystickButton(shootStick, RobotMap.raiseArm);
}

