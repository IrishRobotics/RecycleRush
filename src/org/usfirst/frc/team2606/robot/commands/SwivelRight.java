package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwivelRight extends CommandGroup {
    
    public  SwivelRight() {
       addSequential(new SwivelSetpoint(-10));
    }
}
