package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElbowAutoDown extends Command {
	double mVoltageDesired = 0.0, mCurrentVoltage = 0.0;
	AnalogInput elbowPotentiometer = RobotMap.ELBOW_ANALOG_POTENTIOMETER;
	double potentiometerDesired=0;

	public ElbowAutoDown(double voltage) {
		requires(Robot.elbow);
		requires(Robot.claw);
		mVoltageDesired = voltage;
		/*
		switch (level) {
		case 1:
			// level 1/floor
			potentiometerDesired = 3.470;
			break;
		case 2:
			// Level 2
			potentiometerDesired = 3.303;
			break;
		case 3:
			// Level 3
			potentiometerDesired = 3.120;
			break;
		case 4:
			// Level 4/top
			potentiometerDesired = 2.611;
			break;
		}
		*/

		SmartDashboard.putNumber("voltage",mVoltageDesired);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elbow.down();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		mCurrentVoltage = elbowPotentiometer.pidGet();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (mCurrentVoltage >= mVoltageDesired);
		
		//return (potentiometer.pidGet() >= mVoltage);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.claw.open();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
