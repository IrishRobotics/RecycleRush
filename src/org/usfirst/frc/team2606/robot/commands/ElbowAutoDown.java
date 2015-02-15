package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElbowAutoDown extends Command {
double PotentiometerOutput=0.0;
	AnalogInput potentiometer = RobotMap.ELBOW_ANALOG_POTENTIOMETER;
    public ElbowAutoDown(int level) {
    	requires(Robot.elbow);
    	switch(level){
    	case 1:
    		//level 1
    		PotentiometerOutput =.5;
    		break;
    	case 2:
    		//Level 2
    		PotentiometerOutput =.7;
    		break;
    	case 3:
    		//Level 3
    		PotentiometerOutput =.85;
    		break;
    	case 4:
    		//Level 4
    		PotentiometerOutput =1.2;
    		break;
    	}
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elbow.down();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (potentiometer.pidGet() <= PotentiometerOutput);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
