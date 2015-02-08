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
	Solenoid openClaw = RobotMap.CLAW_OPEN_SOLENOID;
	Solenoid closeClaw = RobotMap.CLAW_CLOSE_SOLENOID;

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

	public void bothOn() {
		openClaw.set(true);
		closeClaw.set(true);
	}

	public void bothOff() {
		openClaw.set(false);
		closeClaw.set(false);
	}
}
