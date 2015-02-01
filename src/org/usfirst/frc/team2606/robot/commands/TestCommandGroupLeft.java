package org.usfirst.frc.team2606.robot.commands;

import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestCommandGroupLeft extends CommandGroup {
    
    public  TestCommandGroupLeft() {
     //   addSequential(new CloseClaw());
       addSequential(new SetSwivelSetpoint(124));
    }
}
