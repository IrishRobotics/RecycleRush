package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.ClawClose;
import org.usfirst.frc.team2606.robot.commands.ClawOpen;
import org.usfirst.frc.team2606.robot.subsystems.Camera;
import org.usfirst.frc.team2606.robot.subsystems.Claw;
import org.usfirst.frc.team2606.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2606.robot.subsystems.Elbow;
import org.usfirst.frc.team2606.robot.subsystems.Swivel;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.Thread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriveTrain drivetrain;
	public static Swivel swivel;
	public static Elbow elbow;
	public static Claw claw;
	public static OI oi;
	public static Camera camera;
	
	// used for drawing on the camera image.
	int session;
	Image frame;

	/** Updates camera in the background 
	 *
	 */
	private class CameraDrawing extends Thread {
		private boolean mRun = true;

		CameraDrawing() {
			frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
			// the camera name (ex "cam0") can be found through the roborio web interface
			session = NIVision.IMAQdxOpenCamera("cam0",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(session);
			NIVision.IMAQdxStartAcquisition(session);
		}

		public void run() {
			/**
			* grab an image, draw the circle, and provide it for the camera server
			* which will in turn send it to the dashboard.
			*/
			NIVision.Rect rect = new NIVision.Rect(150, 150, 100, 460);
			NIVision.Rect rect2 = new NIVision.Rect(120, 150, 140, 300);

			while(mRun) {
				NIVision.IMAQdxGrab(session, frame, 1);
				NIVision.imaqDrawShapeOnImage(frame, frame, rect,
				    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 0.0f);

				CameraServer.getInstance().setImage(frame);
				NIVision.imaqDrawShapeOnImage(frame, frame, rect2,
				    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 0.0f);
				CameraServer.getInstance().setImage(frame);
				/** robot code here! **/
				Timer.delay(0.005);		// wait for a motor update time
			}
			// stop acquiring an image once the loop is broken
			NIVision.IMAQdxStopAcquisition(session);
		}

		public void stopDrawing() {
			mRun = false;
		}
	}

	CameraThread cameraDrawer;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		drivetrain = new DriveTrain();
		swivel = new Swivel();
		elbow = new Elbow();
		claw = new Claw();
		oi = new OI();
		camera = new Camera();
		

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		reset();

		// start the camera thread.
		cameraDrawer = new CameraThread();
		cameraDrawer.run();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		cameraDrawer.stopDrawing();	
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard
				.putNumber("Encoder Value", RobotMap.SWIVEL_ENCODER.get());
		log();
	}
	
	public void log(){
		drivetrain.log();
		swivel.log();
		camera.log();
	}
	public void reset(){
		drivetrain.reset();
		swivel.reset();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
