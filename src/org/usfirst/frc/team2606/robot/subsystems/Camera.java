package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;
/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//public static AxisCamera camera;
	CameraServer cameraServer = RobotMap.CAMERA_SERVER;
	 Image frame;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	cameraServer.setQuality(60);
    	cameraServer.startAutomaticCapture("cam0");
    }
    public void operatorControl() {

        /**
         * grab an image from the camera, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
      
            Timer.delay(0.005);		// wait for a motor update time
    }
    
}

