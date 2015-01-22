package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.Robot;
import org.usfirst.frc.team2606.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Swivel extends PIDSubsystem {
	 private SpeedController swivel=RobotMap.SWIVEL_MOTOR;
	    private Encoder encoder;

	    private static final double kP_real = 1/100.0;
	    
    // Initialize your subsystem here
    public Swivel() {
    	super(kP_real,0, 0);
        setAbsoluteTolerance(0.005);
        
        // Conversion value of potentiometer varies between the real world and simulation
        
            encoder=RobotMap.SWIVEL_ENCODER;
           
    }

    public void initDefaultCommand() {}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
   
    /**
     * Use the potentiometer as the PID sensor. This method is automatically
     * called by the subsystem.
     */
    protected double returnPIDInput() {
        return encoder.get();
    }


    /**
     * Use the motor as the PID output. This method is automatically called by
     * the subsystem.
     */
    protected void usePIDOutput(double d) {
        if(d>=1){
            d=1;
        }else if(d<=-1){
            d=-1;
        }else if(-.1<d&&d<.1){
            d=2*d;
        }
       	swivel.set(d);
    }
}
