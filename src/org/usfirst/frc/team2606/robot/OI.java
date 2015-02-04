package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.CloseClaw;
import org.usfirst.frc.team2606.robot.commands.DownElbow;
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
		JoystickButton d_up = new JoystickButton(rightJoystick, 3);
		JoystickButton d_down = new JoystickButton(rightJoystick, 2);
		JoystickButton trigger = new JoystickButton(rightJoystick, 1);
		trigger.whenPressed(RobotMap.isClawOpen ? new CloseClaw()
				: new OpenClaw());
		d_down.whenPressed(new DownElbow());
		d_up.whenPressed(new UpElbow());
		// d_left.whenPressed(new CloseClaw());
		// d_right.whenPressed(new OpenClaw());
		// left.whenPressed(new TestCommandGroupLeft());
		// right.whenPressed(new TestCommandGroupRight());
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
