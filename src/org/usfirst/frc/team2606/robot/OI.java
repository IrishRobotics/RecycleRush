<<<<<<< HEAD
package org.usfirst.frc.team2606.robot;

import org.usfirst.frc.team2606.robot.commands.AutoStack;
import org.usfirst.frc.team2606.robot.commands.ElbowAutoDown;
import org.usfirst.frc.team2606.robot.commands.ElbowBalance;
import org.usfirst.frc.team2606.robot.commands.ElbowStop;
import org.usfirst.frc.team2606.robot.commands.ClawClose;
import org.usfirst.frc.team2606.robot.commands.ElbowDown;
import org.usfirst.frc.team2606.robot.commands.DriveStraight;
import org.usfirst.frc.team2606.robot.commands.ClawOpen;
import org.usfirst.frc.team2606.robot.commands.ElbowUnstop;
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
	private Joystick leftJoystick = RobotMap.LEFT_JOYSTICK,
			rightJoystick = RobotMap.RIGHT_JOYSTICK;

	public OI() {
		JoystickButton Xbox_a = new JoystickButton(leftJoystick, 1);
		JoystickButton Xbox_b = new JoystickButton(leftJoystick, 2);
		JoystickButton Xbox_x = new JoystickButton(leftJoystick, 3);
		JoystickButton Xbox_y = new JoystickButton(leftJoystick, 4);

		JoystickButton trigger = new JoystickButton(rightJoystick, 1);

		JoystickButton top_up = new JoystickButton(rightJoystick, 3);
		JoystickButton top_down = new JoystickButton(rightJoystick, 2);
		JoystickButton top_left = new JoystickButton(rightJoystick, 4);
		JoystickButton top_right = new JoystickButton(rightJoystick, 5);

		JoystickButton bottom_mid_left = new JoystickButton(rightJoystick, 8);
		JoystickButton bottom_mid_right = new JoystickButton(rightJoystick, 9);

		JoystickButton bottom_left_up = new JoystickButton(rightJoystick, 6);
		JoystickButton bottom_left_down = new JoystickButton(rightJoystick, 7);

		JoystickButton bottom_right_up = new JoystickButton(rightJoystick, 11);
		JoystickButton bottom_right_down = new JoystickButton(rightJoystick, 10);

		Xbox_x.whenPressed(new SwivelRight());
		Xbox_b.whenPressed(new SwivelLeft());

		if (rightJoystick.getX() >= .75) {
			new SwivelLeft();
		} else if (rightJoystick.getX() <= -.75) {
			new SwivelLeft();
		}
		if (rightJoystick.getY() > .125) {
			Robot.drivetrain.drive(rightJoystick.getY() * -.5,
					rightJoystick.getY() * -.5);
		}
		bottom_left_up.whenPressed(new ElbowStop());
		bottom_left_down.whenPressed(new ElbowUnstop());
		
		top_down.whenPressed(new ElbowDown());
		top_up.whenPressed(new ElbowUp());

		top_left.whenPressed(new ClawOpen());
		top_right.whenPressed(new ClawClose());

		// bottom_mid_left.whenPressed(new ElbowStop());
		bottom_mid_right.whenPressed(new ElbowAutoDown(3.15));
		 bottom_right_down.whenPressed(new AutoStack(3.0));
		// bottom_right_up.whenPressed(new AutoStack(3));
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}

=======
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
		
		top_down.whenPressed(new ElbowDown());
		top_up.whenPressed(new ElbowUp());
		
		top_left.whenPressed(new ClawClose());
		top_right.whenPressed(new ClawOpen());
		
		// bottom_mid_left.whenPressed(new ElbowStop());
		bottom_mid_right.whenPressed(new ElbowAutoDown(3.15));
		 bottom_right_down.whenPressed(new AutoStack(3.0));
		// bottom_right_up.whenPressed(new AutoStack(3));
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
}
>>>>>>> 9f8ab02edb1be235a8040e724114718da7d4fcb0
