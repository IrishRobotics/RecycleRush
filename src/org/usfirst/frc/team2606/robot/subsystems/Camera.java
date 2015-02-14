package org.usfirst.frc.team2606.robot.subsystems;

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
	public static AxisCamera camera;
	 Image frame;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    }
    public void operatorControl() {

        /**
         * grab an image from the camera, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
            camera.getImage(frame);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
    }
    
}

