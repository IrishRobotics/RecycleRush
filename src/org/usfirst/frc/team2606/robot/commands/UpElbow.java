package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpElbow extends Command {
    public UpElbow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elbow);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elbow.up();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elbow.up();
    	Robot.elbow.up();
    	Robot.elbow.up();
    	Robot.elbow.up();
    	Robot.elbow.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !RobotMap.RIGHT_JOYSTICK.getRawButton(2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elbow.up();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
