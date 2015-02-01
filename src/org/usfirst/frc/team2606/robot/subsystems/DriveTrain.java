package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;
import org.usfirst.frc.team2606.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.AnalogInput;
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
	// private Gyro gyro = RobotMap.GYRO;
	// private double gyroDesiredHeading;
	// private Encoder leftEncoder, rightEncoder;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DriveTrain() {
		super();
		drive = new RobotDrive(leftMotor, rightMotor);
		// leftEncoder = new Encoder(1, 2);
		// rightEncoder = new Encoder(3, 4);
		// leftEncoder.setDistancePerPulse((6.0 / 12.0 * Math.PI) / 160.0);
		// rightEncoder.setDistancePerPulse((6.0 / 12.0 * Math.PI) / 160.0);
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
		// SmartDashboard.putNumber("Left Distance",
		// left_encoder.getDistance());
		// SmartDashboard.putNumber("Right Distance",
		// right_encoder.getDistance());
		// SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
		// SmartDashboard.putNumber("Right Speed", right_encoder.getRate());
		// SmartDashboard.putNumber("Gyro", gyro.getAngle());
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
		if(leftJoystick.getRawAxis(3) < -.75){
			//drive(leftJoystick.getRawAxis(1) , leftJoystick.getRawAxis(5));
			direction = 1;
			 SmartDashboard.putNumber("Reverse", leftJoystick.getRawAxis(3));
		}else{
			direction = -1;
			 SmartDashboard.putNumber("straight", leftJoystick.getRawAxis(3) * direction);
		}
			 //drive(leftJoystick.getRawAxis(1) * direction, leftJoystick.getRawAxis(5) * direction);
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		// leftEncoder.reset();
		// rightEncoder.reset();
		// gyro.reset();
	}

	public void setGyroDesiredHeading() {
		// gyroDesiredHeading = gyro.getAngle();
	}

	public double getGyroRealHeading() {
		return 0.0;// gyro.getAngle();
	}

	public double GyroAngleError() {
		return 0.0;// gyro.getAngle()-gyroDesiredHeading;
	}

	public double getDistanceInFeet() {
		return 0.0;// (leftEncoder.getDistance() + rightEncoder.getDistance()) /
					// 2.0;
	}

	public double getDistanceInInches() {
		return 0.0;// (leftEncoder.getDistance() + rightEncoder.getDistance()) *
					// 6.0;
	}

}
