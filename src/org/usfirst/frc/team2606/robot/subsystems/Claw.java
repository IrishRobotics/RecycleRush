package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Solenoid openClaw = RobotMap.OPEN_CLAW_SOLENOID;
	Solenoid closeClaw = RobotMap.CLOSE_CLAW_SOLENOID;

	public Claw() {
		super();
	}

	public void initDefaultCommand() {
	}

	public void open() {
		openClaw.set(true);
		closeClaw.set(false);
	}

	public void close() {
		openClaw.set(false);
		closeClaw.set(true);
	}
}