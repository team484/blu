
package org.team484.blu.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.USBCamera;

import org.team484.blu.robot.commands.ExampleCommand;
import org.team484.blu.robot.subsystems.DriveSub;
import org.team484.blu.robot.subsystems.ExampleSubsystem;


public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveSub driveSub = new DriveSub();
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */  
    //Initialize Camera ==========================
    USBCamera logitechCamera = new USBCamera(RobotMap.logitechCamera);
    //============================================
    
    //Joysticks ==================================
    public static final Joystick driveStickLeft = new Joystick(RobotMap.driveStickLeft);
    public static final Joystick driveStickRight = new Joystick(RobotMap.driveStickRight);
    public static final Joystick shootStick = new Joystick(RobotMap.shootStick);
    //=============================================
    
    //Jaguar speed controllers ====================
    public static final Jaguar frontLeftJaguar = new Jaguar(RobotMap.frontLeftMotor);
    public static final Jaguar rearLeftJaguar = new Jaguar(RobotMap.rearLeftMotor);
    public static final Jaguar frontRightJaguar = new Jaguar(RobotMap.frontRightMotor);
    public static final Jaguar rearRightJaguar = new Jaguar(RobotMap.rearRightMotor);
    //=============================================
    
    //In case an arm is added
    
    //public static final Jaguar armJaguarOne = new Jaguar(RobotMap.armMotorOne);
    //public static final Jaguar armJaguarTwo = new Jaguar(RobotMap.armMotorTwo);
    //=============================================
    
    //Drive system ================================
    public static final RobotDrive drive = new RobotDrive(frontLeftJaguar, rearLeftJaguar, frontRightJaguar, rearRightJaguar);
    //=============================================
    
    //Analog inputs ===============================
    public static final AnalogInput leftIR = new AnalogInput(RobotMap.analogIRLeft);
    public static final AnalogInput rightIR = new AnalogInput(RobotMap.analogIRRight);
    //=============================================
    
    public void robotInit() {
		oi = new OI();
		openCamera();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
