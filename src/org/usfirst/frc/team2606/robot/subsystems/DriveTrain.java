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

	// private Encoder leftEncoder , rightEncoder;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DriveTrain() {
		super();
		drive = new RobotDrive(leftMotor, rightMotor);
		// leftEncoder = new Encoder(1, 2);
		// rightEncoder = new Encoder(3, 4);

		// Encoders may measure differently in the real world and in
		// simulation. In this example the robot moves 0.042 barleycorns
		// per tick in the real world, but the simulated encoders
		// simulate 360 tick encoders. This if statement allows for the
		// real robot to handle this difference in devices.
		// if (Robot.isReal()) {
		// left_encoder.setDistancePerPulse(0.042);
		// right_encoder.setDistancePerPulse(0.042);
		// } else {
		// // Circumference in ft = 4in/12(in/ft)*PI
		// left_encoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		// right_encoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		// }

		// Let's show everything on the LiveWindow
		// LiveWindow.addActuator("Drive Train", "Front_Left Motor",
		// (Talon) front_left_motor);
		// LiveWindow.addActuator("Drive Train", "Back Left Motor",
		// (Talon) back_left_motor);
		// LiveWindow.addActuator("Drive Train", "Front Right Motor",
		// (Talon) front_right_motor);
		// LiveWindow.addActuator("Drive Train", "Back Right Motor",
		// (Talon) back_right_motor);
		// LiveWindow.addSensor("Drive Train", "Left Encoder", left_encoder);
		// LiveWindow.addSensor("Drive Train", "Right Encoder", right_encoder);
		// LiveWindow.addSensor("Drive Train", "Rangefinder", rangefinder);
		// LiveWindow.addSensor("Drive Train", "Gyro", gyro);
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
	public void drive(Joystick leftJoystick, Joystick rightJoystick) {
		drive(-leftJoystick.getY(), -rightJoystick.getY());
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		// left_encoder.reset();
		// right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	// public double getDistance() {
	// return (left_encoder.getDistance() + right_encoder.getDistance()) / 2;
	// }

}
