package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.ElbowAutoDown;
import org.usfirst.frc.team2606.robot.commands.ElbowBalance;
import org.usfirst.frc.team2606.robot.commands.ElbowStop;
import org.usfirst.frc.team2606.robot.commands.ClawClose;
import org.usfirst.frc.team2606.robot.commands.ElbowDown;
import org.usfirst.frc.team2606.robot.commands.DriveStraight;
import org.usfirst.frc.team2606.robot.commands.ClawOpen;
import org.usfirst.frc.team2606.robot.commands.SwivelLeft;
import org.usfirst.frc.team2606.robot.commands.SwivelRight;
import org.usfirst.frc.team2606.robot.commands.ElbowUp;
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
		JoystickButton X_b = new JoystickButton(leftJoystick, 2);
		JoystickButton X_x = new JoystickButton(leftJoystick, 3);

		JoystickButton trigger = new JoystickButton(rightJoystick, 1);
		
		JoystickButton top_up = new JoystickButton(rightJoystick, 3);
		JoystickButton top_down = new JoystickButton(rightJoystick, 2);
		JoystickButton top_left = new JoystickButton(rightJoystick, 4);
		JoystickButton top_right = new JoystickButton(rightJoystick, 5);
		
		JoystickButton bottom_mid_left = new JoystickButton(rightJoystick, 8);
		JoystickButton bottom_mid_right = new JoystickButton(rightJoystick, 9);
		
		JoystickButton bottom_left_up = new JoystickButton(rightJoystick,6);
		JoystickButton bottom_left_down = new JoystickButton(rightJoystick,7);
		
		JoystickButton bottom_right_up = new JoystickButton(rightJoystick,11);
		JoystickButton bottom_right_down = new JoystickButton(rightJoystick,10);
		
		X_x.whenPressed(new SwivelRight());
		X_b.whenPressed(new SwivelLeft());
		
		if(rightJoystick.getX()>=.75){
			new SwivelLeft();
		}else if(rightJoystick.getX()<=-.75){
			new SwivelLeft();
		}
		if(rightJoystick.getY() < 0){
			Robot.drivetrain.drive(rightJoystick.getY()*.5, rightJoystick.getY() * .5);
		}
		
		top_down.whenPressed(new ElbowDown());
		top_up.whenPressed(new ElbowUp());
		
		top_left.whenPressed(new ClawClose());
		top_right.whenPressed(new ClawOpen());
		
		bottom_mid_left.whenPressed(new ElbowStop());
		bottom_mid_right.whenPressed(new ElbowAutoDown(1));
		bottom_right_down.whenPressed(new ElbowAutoDown(2));
		bottom_right_up.whenPressed(new ElbowAutoDown(3));
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
