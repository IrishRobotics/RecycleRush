package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.subsystems.Claw;
import org.usfirst.frc.team2606.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2606.robot.subsystems.Swivel;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Claw claw;
	public static OI oi;
	private Encoder encoder = RobotMap.SWIVEL_ENCODER;
	private Gyro gyro = RobotMap.GYRO;

	// Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		drivetrain = new DriveTrain();
		swivel = new Swivel();
		claw = new Claw();
		oi = new OI();
		// instantiate the command used for the autonomous period
		// autonomousCommand = new ExampleCommand();
		encoder.reset();
		gyro.reset();
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
		encoder.reset();
		gyro.reset();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder Value", RobotMap.SWIVEL_ENCODER.get());
		SmartDashboard.putNumber("Gyro angle ", gyro.getAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}