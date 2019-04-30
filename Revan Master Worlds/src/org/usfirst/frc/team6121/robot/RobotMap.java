/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int DRIVER_JOYSTICK = 0;
	public static final int OPERATOR_JOYSTICK = 1;
	
	public static final int X_AXIS = 4;
	public static final int Y_AXIS = 1;
	public static final int R_TRIGGER = 3;
	public static final int L_TRIGGER = 2;

	public static final int LIGHT_BUTTON = 2;
	
	public static final int ARMS_UP_BUTTON = 7;
	public static final int ARMS_DOWN_BUTTON = 8;
	
	public static final int LAUNCHER_ARMS_UP = 12;
	public static final int LAUNCHER_ARMS_DOWN = 15;
	
	public static final int INTAKE_IN = 14;
	public static final int INTAKE_OUT = 13;
	
	public static final int GRABBER_OUT = 6;
	public static final int GRABBER_IN = 9;
	
	public static final int CLIMBER_BUTTON = 1;

	public static final int TRANSMISSION_SOLENOID_EXPAND_BUTTON = 5;

	public static final int RAMP_MOTORS = 0;
	public static final int LEFT_MOTOR = 1;
	public static final int RIGHT_MOTOR = 2;
	public static final int LIGHTS = 3;
	public static final int CLIMBER = 4;
	
	public static SpeedController rlMotors;
	public static SpeedController LeftMotor;
	public static SpeedController RightMotor;
	public static SpeedController Climber;
	public static SpeedController Lights;
	
	public static WPI_TalonSRX _frontLeftMotor;
	public static WPI_TalonSRX _frontRightMotor;
	
	public static WPI_TalonSRX _leftSlave1;
	public static WPI_TalonSRX _rightSlave1;
	
	
	public static DifferentialDrive driveTrain;
	
	public static Solenoid transmissionSolenoid;
	public static DoubleSolenoid ArmsSolenoid;
	public static DoubleSolenoid GrabberSolenoid;
	
	public static ADXRS450_Gyro gyro;
	
	
	public static void init() {
		
    	_frontLeftMotor = new WPI_TalonSRX(1); 		
    	_frontRightMotor = new WPI_TalonSRX(3);
    	
    	_leftSlave1 = new WPI_TalonSRX(2);
    	_rightSlave1 = new WPI_TalonSRX(4);
    		
    	driveTrain = new DifferentialDrive(_frontLeftMotor, _frontRightMotor);
    	
    	_leftSlave1.follow(_frontLeftMotor);
    	_rightSlave1.follow(_frontRightMotor);
		
		rlMotors = new Spark(RAMP_MOTORS);
		Lights = new Spark(LIGHTS);
		LeftMotor = new Victor(LEFT_MOTOR);
		RightMotor = new Victor(RIGHT_MOTOR);
		Climber = new Spark(CLIMBER);
		
		transmissionSolenoid = new Solenoid(0);
		ArmsSolenoid = new DoubleSolenoid(1, 5);
		GrabberSolenoid = new DoubleSolenoid(7,6);
		
		gyro = new ADXRS450_Gyro();
		
	
	}
	
}
