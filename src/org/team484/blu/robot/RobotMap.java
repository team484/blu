package org.team484.blu.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
	// If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//Define motor ports =================================
	public static int frontLeftMotor = 0;
	public static int rearLeftMotor = 1;
	public static int frontRightMotor = 2;
	public static int rearRightMotor = 3;
	public static int liftMotor = 4;
	//====================================================
	
	//Define analog ports ====================================
	public static int analogIRLeft = 0;
	public static int analogIRRight = 1;
	//========================================s===========
	
	//Define joystick ports =============================
	public static int shootStick = 0;
	public static int driveStickLeft = 0;
	public static int driveStickRight = 0;
	//===================================================
	
	
	//Button Mapping ================================
	//public static final int lowerArm = 7; //Raise arm?
    //public static final int raiseArm = 6; //Lower arm?
    //=============================================
	
}
