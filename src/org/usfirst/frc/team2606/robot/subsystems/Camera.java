package org.usfirst.frc.team2606.robot.subsystems;

import org.usfirst.frc.team2606.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//public static AxisCamera camera;
	CameraServer cameraServer = RobotMap.CAMERA_SERVER;
	 Image frame;
	 int session;
    public void initDefaultCommand() {
    	//cameraServer.startAutomaticCapture("cam0");
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	/*
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 2);
    	cameraServer.setQuality(50);
    	 session = NIVision.IMAQdxOpenCamera("cam0",
                 NIVision.IMAQdxCameraControlMode.CameraControlModeController);
         NIVision.IMAQdxConfigureGrab(session);
         */
    	//cameraServer.getInstance().setImage(frame);
    	
    }
    public void operatorControl() {
        /**
         * grab an image from the camera, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
    	//CameraServer.getInstance().setImage(frame);
    	/*
    	NIVision.Rect rect = new NIVision.Rect(5, 5, 5, 5);
    	 NIVision.IMAQdxGrab(session, frame, 2);
         NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                 DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
         NIVision.IMAQdxStopAcquisition(session);
         CameraServer.getInstance().setImage(frame);
         */
            Timer.delay(0.005);		// wait for a motor update time
            //NIVision.IMAQdxStopAcquisition(session);
    }
	public void log() {
		// TODO Auto-generated method stub
		//operatorControl();
		//
	}
    
}

