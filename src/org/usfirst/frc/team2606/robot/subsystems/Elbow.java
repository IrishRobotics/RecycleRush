package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elbow extends Subsystem {

	Solenoid mElbowUp = RobotMap.ELBOW_UP_SOLENOID;
	Solenoid mElbowDown = RobotMap.ELBOW_DOWN_SOLENOID;
	AnalogInput elbowPoterntiometer = RobotMap.ELBOW_ANALOG_POTENTIOMETER;

	public Elbow() {
		super();
	}

	public void initDefaultCommand() {
	}

	private void setSolenoid(boolean up, boolean down) {
		mElbowUp.set(up);
		mElbowDown.set(down);
	}

	public void up() {
		setSolenoid(true, false);
	}

	public void down() {
		setSolenoid(false, true);
	}

	public void stop() {
		// turn on the JAM.
		setSolenoid(false, false);
	}

	public void balance() {
		if (elbowPoterntiometer.pidGet() < 4) {
			down();
		} else if (elbowPoterntiometer.pidGet() > 4) {
			up();
		}

	}
}
