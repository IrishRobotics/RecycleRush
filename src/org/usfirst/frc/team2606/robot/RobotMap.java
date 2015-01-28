package org.usfirst.frc.team2606.robot;

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
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static SpeedController LEFT_MOTOR = new Jaguar(0);
	public static SpeedController RIGHT_MOTOR=new Jaguar(1);
	public static SpeedController SWIVEL_MOTOR = new Talon(2);
	
	public static Joystick LEFT_JOYSTICK = new Joystick(0);
	public static Joystick RIGHT_JOYSTICK = new Joystick(1);
	
	public static Solenoid OPEN_CLAW_SOLENOID = new Solenoid(0);
	public static Solenoid CLOSE_CLAW_SOLENOID = new Solenoid(1);
	public static Solenoid ELBOW_UP_SOLENOID = new Solenoid(2);
	public static Solenoid ELBOW_DOWN_SOLENOID = new Solenoid(3);
	
	public static Gyro GYRO = new Gyro(0);
	
	public static Encoder SWIVEL_ENCODER = new Encoder(0,1,false,CounterBase.EncodingType.k4X);
	
}
