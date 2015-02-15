package org.usfirst.frc.team2606.robot;

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
		JoystickButton d_up = new JoystickButton(rightJoystick, 3);
		JoystickButton d_down = new JoystickButton(rightJoystick, 2);
		JoystickButton d_left = new JoystickButton(rightJoystick, 4);
		JoystickButton d_right = new JoystickButton(rightJoystick, 5);
		JoystickButton X_b = new JoystickButton(leftJoystick, 2);
		JoystickButton X_x = new JoystickButton(leftJoystick, 3);
		JoystickButton bottom_left = new JoystickButton(rightJoystick, 8);
		JoystickButton bottom_right = new JoystickButton(rightJoystick, 9);
		JoystickButton balance_voltage = new JoystickButton(rightJoystick,7);
		//X_a.whenPressed(new DriveStraight(16.0));
		X_x.whenPressed(new SwivelRight());
		X_b.whenPressed(new SwivelLeft());
		if(rightJoystick.getX()>=.75){
			new SwivelLeft();
		}else if(rightJoystick.getX()<=-.75){
			new SwivelLeft();
		}
			
		
		d_down.whenPressed(new ElbowDown());
		d_up.whenPressed(new ElbowUp());
		
		d_left.whenPressed(new ClawClose());
		d_right.whenPressed(new ClawOpen());
		bottom_left.whenPressed(new ElbowUp());
		//bottom_right.whenPressed(new DownElbow());
		bottom_right.whenPressed(new ElbowStop());
		//balance_voltage.whenPressed(new BalanceElbow());
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
