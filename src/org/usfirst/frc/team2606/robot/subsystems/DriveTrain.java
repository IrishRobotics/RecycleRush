package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;
import org.usfirst.frc.team2606.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private SpeedController leftMotor = RobotMap.LEFT_MOTOR;
	private SpeedController rightMotor = RobotMap.RIGHT_MOTOR;
	private RobotDrive drive;
	private int direction;
	private Gyro gyro = RobotMap.DRIVE_GYRO;
	private double gyroDesiredHeading;
	private Encoder leftEncoder = RobotMap.LEFT_DRIVE;
	private Encoder rightEncoder = RobotMap.RIGHT_DRIVE;
	private AnalogInput elbowPotentiometer = RobotMap.ELBOW_ANALOG_POTENTIOMETER;
	//private AnalogInput rangefinder = RobotMap.RANGER_FINDER;
	MaxbotixUltrasonic rangefinder;

	public DriveTrain() {
		super();
		drive = new RobotDrive(leftMotor, rightMotor);
		leftEncoder.setDistancePerPulse((0.5 * Math.PI) / 360.0);
		rightEncoder.setDistancePerPulse((0.5 * Math.PI) / 360.0);
		rangefinder = new MaxbotixUltrasonic();
	}

	/**
	 * When no other command is running let the operator drive around using the
	 * PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", -leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
		SmartDashboard.putNumber("Left Speed", -leftEncoder.getRate());
		SmartDashboard.putNumber("Right Speed", rightEncoder.getRate());
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
		SmartDashboard.putNumber("Potentiometer", elbowPotentiometer.pidGet());
		SmartDashboard.putNumber("RangeFinder 5", rangefinder.GetVoltage()/0.009766);
		SmartDashboard.putNumber("RangeFinder 3.3", rangefinder.GetVoltage()/0.006574);
		SmartDashboard.putNumber("RangeFinder Voltage ", rangefinder.GetVoltage());
	}

	/**
	 * Tank style driving for the DriveTrain.
	 * 
	 * @param left
	 *            Speed in range [-1,1]
	 * @param right
	 *            Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}

	/**
	 * @param joy
	 *            The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick leftJoystick) {
		if (leftJoystick.getRawAxis(3) < -.75) {
			drive(leftJoystick.getRawAxis(1), leftJoystick.getRawAxis(5));
			direction = 1;
			SmartDashboard.putNumber("Reverse", leftJoystick.getRawAxis(3));
		} else {
			direction = -1;
			SmartDashboard.putNumber("straight", leftJoystick.getRawAxis(3)
					* direction);
		}
		drive(leftJoystick.getRawAxis(1) * direction,
				leftJoystick.getRawAxis(5) * direction);
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
		gyro.reset();
	}

	public double getDistanceToObstacle() {
		//return rangefinder.GetRangeInInches();
		return rangefinder.GetVoltage();
	}

	public void setGyroDesiredHeading() {
		gyroDesiredHeading = gyro.getAngle();
	}

	public double getGyroRealHeading() {
		return gyro.getAngle();
	}

	public double GyroAngleError() {
		return gyro.getAngle() - gyroDesiredHeading;
	}

	public double getDistanceInFeet() {
		return (-leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
	}

	public double getDistanceInInches() {
		return (-leftEncoder.getDistance() + rightEncoder.getDistance()) * 6.0;
	}
}
