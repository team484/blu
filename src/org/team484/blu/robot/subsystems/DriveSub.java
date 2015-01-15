package org.team484.blu.robot.subsystems;

import org.team484.blu.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Written by: Kevin Connell
 *
 *Last Updated: 1/14/15
 */
public class DriveSub extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void driveWithJoysticks() {
    	Robot.drive.tankDrive(Robot.driveStickLeft, Robot.driveStickRight);
    }
}

