package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elbow extends Subsystem {
    
	Solenoid downElbow = RobotMap.ELBOW_DOWN_SOLENOID;
	Solenoid upElbow = RobotMap.ELBOW_UP_SOLENOID;

	public Elbow() {
		super();
	}

	public void initDefaultCommand() {
	}

	public void up() {
		upElbow.set(true);
		downElbow.set(false);
	}

	public void down() {
		upElbow.set(false);
		downElbow.set(true);
	}
}

