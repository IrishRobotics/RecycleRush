package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.CloseClaw;
import org.usfirst.frc.team2606.robot.commands.OpenClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a leftJoystickstick button which is any button on a
	// leftJoystickstick.
	// You create one by telling it which leftJoystickstick it's on and which
	// button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	private Joystick leftJoystick = RobotMap.LEFT_JOYSTICK;
	private Joystick rightJoystick = RobotMap.RIGHT_JOYSTICK;

	public OI() {
		JoystickButton d_up = new JoystickButton(leftJoystick, 3);
		JoystickButton d_right = new JoystickButton(leftJoystick, 5);
		JoystickButton d_down = new JoystickButton(leftJoystick, 2);
		JoystickButton d_left = new JoystickButton(leftJoystick, 4);
		d_right.whenPressed(new CloseClaw());
		d_left.whenPressed(new OpenClaw());
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
