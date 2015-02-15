package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElbowStop extends Command {
	public ElbowStop() {
		requires(Robot.elbow);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.elbow.stop();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
