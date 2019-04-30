package org.usfirst.frc.team6121.robot.subsystems;

import org.usfirst.frc.team6121.robot.RobotMap;
import org.usfirst.frc.team6121.robot.commands.Lights;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightsSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    	//**RED**//
    	//setDefaultCommand(new Lights(-0.17));
    	
    	//**BLUE**//
    	setDefaultCommand(new Lights(-0.15));
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double r) {
   		RobotMap.Lights.set(r);
  
   }
}

