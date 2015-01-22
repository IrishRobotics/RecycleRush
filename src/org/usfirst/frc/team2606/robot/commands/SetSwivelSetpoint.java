package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetSwivelSetpoint extends Command {
public int setPoint;
    public SetSwivelSetpoint(int setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setPoint = setPoint;
    	requires(Robot.swivel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 Robot.swivel.enable();
    	 Robot.swivel.setSetpoint(setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.swivel.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.swivel.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
