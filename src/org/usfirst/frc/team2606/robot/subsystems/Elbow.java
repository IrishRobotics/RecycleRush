package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elbow extends Subsystem {
    
	Solenoid Elbow = RobotMap.ELBOW_SOLENOID;

	public Elbow() {
		super();
	}

	public void initDefaultCommand() {
	}

	public void up() {
		Elbow.set(true);
	}

	public void down() {
		Elbow.set(false);
	}
}

