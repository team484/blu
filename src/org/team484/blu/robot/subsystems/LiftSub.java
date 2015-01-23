
package org.team484.blu.robot.subsystems;

import org.team484.blu.robot.RobotMap;
import org.team484.blu.robot.commands.LiftOff;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Written by: Diego Fierros
 *
 *Last Updated: 1/22/2015
 */
public class LiftSub extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon lift = new Talon(RobotMap.liftMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftOff());
    }
    
    //Motor off, the lift will most likely fall
    public void liftOff() {
    	lift.set(0);
    }
    //Motor on at full speed up
    public void liftUp()  {
    	lift.set(1.0);
    }
    //Motor on at full speed down (Do we need this? Or will it fall on its own?)
    public void liftDown()  {
    	lift.set(-1.0);
    }
    //Attempts to hold lift in place. TODO: Implement sensor later for more reliable "hold"
    public void liftHold()  {
    	lift.set(0.1);
    }
}

