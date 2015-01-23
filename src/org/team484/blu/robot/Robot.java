
package org.team484.blu.robot;

import java.awt.Graphics;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.ColorMode;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Range;
import com.ni.vision.NIVision.ShapeMode;

import java.awt.ImageCapabilities;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;

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
    //USBCamera camera = new USBCamera("cam0");
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
    
    // Camera Server
    public static CameraServer server;
    //the camera name (ex "cam0") can be found through the roborio web interface
    //public static USBCamera camera = new USBCamera("cam0");
    public static Image frame;
    public static Range hue = new Range((int) Math.toRadians(80),(int) Math.toRadians(150));
    public static Range saturation = new Range(0,100);
    public static Range value = new Range(0,100);
    int i = 0;
    int session;
    
    public void robotInit() {
		oi = new OI();
		// The Entirety of the USBCamera ====================
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        //===================================================
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
    	NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
    	NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */

        NIVision.IMAQdxGrab(session, frame, 1);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        //======
        // NIVision.imaqColorThreshold(frame, frame, 50, ColorMode.HSV, hue, saturation, value);
        //======
        server.getInstance().setImage(frame);

        /** robot code here! **/
        Timer.delay(0.005);
        NIVision.IMAQdxStopAcquisition(session);
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
