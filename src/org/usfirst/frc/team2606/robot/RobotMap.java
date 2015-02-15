package org.usfirst.frc.team2606.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController LEFT_MOTOR = new Jaguar(0);
	public static SpeedController RIGHT_MOTOR = new Jaguar(1);
	public static SpeedController SWIVEL_MOTOR = new Talon(2);

	public static Joystick LEFT_JOYSTICK = new Joystick(0);
	public static Joystick RIGHT_JOYSTICK = new Joystick(1);

	// two solenoids allow us to "stop" the elbow as necessary
	public static Solenoid ELBOW_UP_SOLENOID = new Solenoid(0);
	public static Solenoid ELBOW_DOWN_SOLENOID = new Solenoid(7);
	public static Solenoid CLAW_SOLENOID = new Solenoid(2);
	
	public static Gyro DRIVE_GYRO = new Gyro(1);

	public static AnalogInput ELBOW__ANALOG_POTENTIOMETER = new AnalogInput(3);

	public static Encoder SWIVEL_ENCODER = new Encoder(0, 1, false,CounterBase.EncodingType.k4X);
	public static Encoder LEFT_DRIVE = new Encoder(2,3,false,CounterBase.EncodingType.k4X);
	public static Encoder RIGHT_DRIVE = new Encoder(4,5,false,CounterBase.EncodingType.k4X);
	
	public static AnalogInput RANGER_FINDER = new AnalogInput(1);
}
