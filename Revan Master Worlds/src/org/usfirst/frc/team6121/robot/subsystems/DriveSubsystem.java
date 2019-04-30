package org.usfirst.frc.team6121.robot.subsystems;

import org.usfirst.frc.team6121.robot.OI;
import org.usfirst.frc.team6121.robot.RobotMap;
import org.usfirst.frc.team6121.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class DriveSubsystem extends Subsystem {
	
	/** Constant for driving straight **/
	private static final double Kp = 0;
	/** Drive straight constant **/
	
	
	 public void arcadeDrive(Joystick stick) {
		 double angle = RobotMap.gyro.getAngle();
		 double forward = (OI.driverJoystick.getRawAxis(RobotMap.Y_AXIS)) * (OI.driverJoystick.getRawAxis(RobotMap.R_TRIGGER) + .75);
	    	double turn = OI.driverJoystick.getRawAxis(RobotMap.X_AXIS);
	    	RobotMap.driveTrain.arcadeDrive(forward, turn);
	 }
	 
	 public void driveStraight(double m, double c) {
	    	double angle = RobotMap.gyro.getAngle();
		 RobotMap.driveTrain.arcadeDrive(-angle * Kp, c);
	    	Timer.delay(0.01);
	 }
	

   // Put methods for controlling this subsystem
   // here. Call these from Commands.z

   public void initDefaultCommand() {
   	
   	setDefaultCommand(new ArcadeDrive());
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
   
   public void drive(double m, double c) {
   	RobotMap.driveTrain.arcadeDrive(m,  c);
   }
   public void enableBrakeMode() {
	 RobotMap._frontLeftMotor.setNeutralMode(NeutralMode.Brake);
	 RobotMap._frontRightMotor.setNeutralMode(NeutralMode.Brake);
	 RobotMap._leftSlave1.setNeutralMode(NeutralMode.Brake);
	 RobotMap._rightSlave1.setNeutralMode(NeutralMode.Brake);
   }
   public void disableBrakeMode() {
		 RobotMap._frontLeftMotor.setNeutralMode(NeutralMode.Coast);
		 RobotMap._frontRightMotor.setNeutralMode(NeutralMode.Coast);
		 RobotMap._leftSlave1.setNeutralMode(NeutralMode.Coast);
		 RobotMap._rightSlave1.setNeutralMode(NeutralMode.Coast);
	   }
}

