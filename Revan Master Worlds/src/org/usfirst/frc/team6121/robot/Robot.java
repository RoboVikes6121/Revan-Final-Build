/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot;

import org.usfirst.frc.team6121.robot.commands.AutonLLL;
import org.usfirst.frc.team6121.robot.commands.AutonLRL;
import org.usfirst.frc.team6121.robot.commands.AutonRLR;
import org.usfirst.frc.team6121.robot.commands.AutonRRR;
import org.usfirst.frc.team6121.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.AutonLeftMotorSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.AutonLightsSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.AutonRightMotorSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.ClimbingSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.LeftMotorSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.LightsSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.LoaderSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.PowerCubeDeliverSubsystem;
import org.usfirst.frc.team6121.robot.subsystems.RightMotorSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static ClimbingSubsystem climbingSubsystem;
	public static ClimberSubsystem Climber;
	public static PneumaticSubsystem pneumaticSubsystem;
	public static DriveSubsystem driveSubsystem;
	public static PowerCubeDeliverSubsystem cubeSubsystem;
	public static LoaderSubsystem loader;
	public static ArmSubsystem arm;
	public static LeftMotorSubsystem Teleop;
	public static RightMotorSubsystem Teleop2;
	public static AutonLeftMotorSubsystem Auto;
	public static AutonRightMotorSubsystem Auto2;
	public static LightsSubsystem lights;
	public static AutonLightsSubsystem AutonLights;
	public static OI oi;

	Command autonomousCommand;
	
	public static DigitalInput limitSwitch1;
	public static DigitalInput limitSwitch2;
	
	public static AnalogInput UltraSonicSensor;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		RobotMap.init();

		climbingSubsystem = new ClimbingSubsystem();
		Climber = new ClimberSubsystem();
		pneumaticSubsystem = new PneumaticSubsystem();
		driveSubsystem = new DriveSubsystem();
		cubeSubsystem = new PowerCubeDeliverSubsystem();
		loader = new LoaderSubsystem();
		arm = new ArmSubsystem();
		Teleop = new LeftMotorSubsystem();
		Teleop2 = new RightMotorSubsystem();
		Auto = new AutonLeftMotorSubsystem();
		Auto2 = new AutonRightMotorSubsystem();
		lights = new LightsSubsystem();
		AutonLights = new AutonLightsSubsystem();
		oi = new OI();
		
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
		
		limitSwitch1 = new DigitalInput(0);
		limitSwitch2 = new DigitalInput(1);
		
		UltraSonicSensor = new AnalogInput(0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Angle", RobotMap.gyro.getAngle());
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		RobotMap.gyro.reset();
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.equals("LRL")); 
		{  //Drive to left switch, go around to opponents side//
			autonomousCommand = new AutonLRL();
		
		} if(gameData.equals("RLR"))
		{  
			autonomousCommand = new AutonRLR();
		} if(gameData.equals("LLL"))
		{  
			autonomousCommand = new AutonLLL();
		} if(gameData.equals("RRR"))
		{  
			autonomousCommand = new AutonRRR();
		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

//	@Override
	public void teleopInit() {
		
	
		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	
	


	/**
	 * This function is called periodically during operator control
	 */
//	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Angle", RobotMap.gyro.getAngle());
		
    	
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	}
}
