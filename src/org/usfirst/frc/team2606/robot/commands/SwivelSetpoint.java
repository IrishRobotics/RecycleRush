package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwivelSetpoint extends Command {
	public int setPoint;

	public SwivelSetpoint() {
		requires(Robot.swivel);
	
	}

	public SwivelSetpoint(int setPoint) {
		this.setPoint = setPoint;
		requires(Robot.swivel);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Robot.swivel.enable();
		// Robot.swivel.setSetpoint(setPoint);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//SmartDashboard.putBoolean("swivel is finished", this.isFinished());
		Robot.swivel.move(Robot.oi.getRightJoystick().getX());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; // Robot.swivel.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		// .swivel.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
