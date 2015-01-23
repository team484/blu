
package org.team484.blu.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.team484.blu.robot.Robot;

/**
 *Written by: Diego Fierros
 *
 *Last Updated: 1/22/2015
 */
public class LiftUp extends Command {

    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.liftSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftSub.liftUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
