package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwivelLeft extends CommandGroup {
    public  SwivelLeft() {
       addSequential(new SwivelSetpoint(10));
    }
}
