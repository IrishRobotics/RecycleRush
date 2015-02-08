package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.ClawBothOff;
import org.usfirst.frc.team2606.robot.commands.ClawBothOn;
import org.usfirst.frc.team2606.robot.commands.CloseClaw;
import org.usfirst.frc.team2606.robot.commands.DownElbow;
import org.usfirst.frc.team2606.robot.commands.DriveStraight;
import org.usfirst.frc.team2606.robot.commands.OpenClaw;
import org.usfirst.frc.team2606.robot.commands.TestCommandGroupLeft;
import org.usfirst.frc.team2606.robot.commands.TestCommandGroupRight;
import org.usfirst.frc.team2606.robot.commands.UpElbow;
import org.usfirst.frc.team2606.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftJoystick = RobotMap.LEFT_JOYSTICK;
	private Joystick rightJoystick = RobotMap.RIGHT_JOYSTICK;

	public OI() {
		JoystickButton X_a = new JoystickButton(leftJoystick, 1);
		JoystickButton d_up = new JoystickButton(rightJoystick, 3);
		JoystickButton d_down = new JoystickButton(rightJoystick, 2);
		JoystickButton d_left = new JoystickButton(rightJoystick, 4);
		JoystickButton d_right = new JoystickButton(rightJoystick, 5);
		JoystickButton bottom_left = new JoystickButton(rightJoystick, 8);
		JoystickButton bottom_right = new JoystickButton(rightJoystick, 9);
		X_a.whenPressed(new DriveStraight(8.0));
		d_down.whenPressed(new DownElbow());
		d_up.whenPressed(new UpElbow());
		d_left.whenPressed(new CloseClaw());
		d_right.whenPressed(new OpenClaw());
		bottom_left.whenPressed(new ClawBothOn());
		bottom_right.whenPressed(new ClawBothOff());
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
