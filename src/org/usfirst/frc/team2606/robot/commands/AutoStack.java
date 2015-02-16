package org.usfirst.frc.team2606.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStack extends CommandGroup {

	public AutoStack(double level) {
		addSequential(new ElbowAutoDown(level));
		addSequential(new ClawOpen());
		addSequential(new ElbowUp());
		// addSequential(new DriveStraight(-4));

	}
}
