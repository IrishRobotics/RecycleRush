package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;
import org.usfirst.frc.team2606.robot.commands.SwivelSetpoint;
import org.usfirst.frc.team2606.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Swivel extends Subsystem {
	private SpeedController swivel = RobotMap.SWIVEL_MOTOR;
	private Encoder encoder = RobotMap.SWIVEL_ENCODER;

	// private static final double kP = 1/100.0,kI=0,kD = 0;
	public Swivel() {
		super();
		// super(kP,kI, kD);
		// setAbsoluteTolerance(0.005);
		
		reset();

	}

	public void initDefaultCommand() {

		setDefaultCommand(new SwivelSetpoint());

	}
public void reset(){
	encoder.reset();
}
	public void log() {
		SmartDashboard
				.putNumber("Encoder Value", RobotMap.SWIVEL_ENCODER.get());
	}

	/**
	 * Use the potentiometer as the PID sensor. This method is automatically
	 * called by the subsystem.
	 */

	protected double returnPIDInput() {
		return encoder.get();
	}

	/**
	 * Use the motor as the PID output. This method is automatically called by
	 * the subsystem.
	 */
	protected void usePIDOutput(double d) {
		if (d >= .5) {
			d = .5;
		} else if (d <= -.5) {
			d = -.5;
		} else if (-.1 < d && d < .1) {
			d = 2 * d;
		}
		swivel.set(d);
	}

	public void move(double speed) {
		swivel.set(speed * .5);
	}
}
