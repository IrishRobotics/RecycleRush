package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	private PIDController pid;
	private static final double driveKP = 1.0, gyroKP = 1 / 10.0;

	public DriveStraight(double distance) {
		requires(Robot.drivetrain);
		Robot.drivetrain.setGyroDesiredHeading();
		pid = new PIDController(driveKP, 0, 0, new PIDSource() {
			public double pidGet() {
				return Robot.drivetrain.getDistanceInFeet();
			}
		}, new PIDOutput() {
			public void pidWrite(double d) {
				double gyroError = gyroKP * Robot.drivetrain.GyroAngleError();
				if (d >= .5) {
					d = .50;
				} else if (d <= -.5) {
					d = -.50;
				} else if (-.15 < d && d < .15) {
					d = 2 * d;
				}
				if (gyroError > 0) {
					Robot.drivetrain.drive(d - gyroError,d);
				} else if (gyroError < 0) {
					Robot.drivetrain.drive(d,d + gyroError);
				} else {
					Robot.drivetrain.drive(d, d);
				}
			}
		});
		pid.setAbsoluteTolerance(0.01);
		pid.setSetpoint(distance);
	}

	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.drivetrain.reset();
		// Called just before this Command runs the first time
		pid.reset();
		pid.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return pid.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		// Stop PID and the wheels
		pid.disable();
		Robot.drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
