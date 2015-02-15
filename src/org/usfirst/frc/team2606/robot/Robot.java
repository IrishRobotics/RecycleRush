package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.ClawClose;
import org.usfirst.frc.team2606.robot.commands.ClawOpen;
import org.usfirst.frc.team2606.robot.subsystems.Claw;
import org.usfirst.frc.team2606.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2606.robot.subsystems.Elbow;
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
	public static Elbow elbow;
	public static Claw claw;
	public static OI oi;


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
		SmartDashboard
				.putNumber("Encoder Value", RobotMap.SWIVEL_ENCODER.get());
		log();
		
	}
	public void log(){
		drivetrain.log();
		swivel.log();
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
