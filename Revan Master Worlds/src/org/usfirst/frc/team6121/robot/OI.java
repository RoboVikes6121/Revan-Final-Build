/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot;

import org.usfirst.frc.team6121.robot.commands.Arm;
import org.usfirst.frc.team6121.robot.commands.Climber;
import org.usfirst.frc.team6121.robot.commands.GrabberSolenoidExpand;
import org.usfirst.frc.team6121.robot.commands.GrabberSolenoidRetract;
import org.usfirst.frc.team6121.robot.commands.LeftMotor;
import org.usfirst.frc.team6121.robot.commands.Lights;
import org.usfirst.frc.team6121.robot.commands.Loader;
import org.usfirst.frc.team6121.robot.commands.RightMotor;
import org.usfirst.frc.team6121.robot.commands.SolenoidArmsDown;
import org.usfirst.frc.team6121.robot.commands.SolenoidArmsUp;
import org.usfirst.frc.team6121.robot.commands.TransmissionSolenoidExpand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick driverJoystick;
	public static Joystick operatorJoystick;
	
	OI() {
		
		driverJoystick = new Joystick(RobotMap.DRIVER_JOYSTICK);
		operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
		
		Button IntakeArmsUp = new JoystickButton(operatorJoystick, RobotMap.ARMS_DOWN_BUTTON);
		IntakeArmsUp.whenPressed(new SolenoidArmsUp());
		
		Button IntakeArmsDown = new JoystickButton(operatorJoystick, RobotMap.ARMS_UP_BUTTON);
		IntakeArmsDown.whenPressed(new SolenoidArmsDown());
		
		Button Intake_IN = new JoystickButton(operatorJoystick, RobotMap.INTAKE_OUT);
		Intake_IN.whileHeld(new LeftMotor(1));

		Button Intake_IN2 = new JoystickButton(operatorJoystick, RobotMap.INTAKE_OUT);
		Intake_IN.whileHeld(new RightMotor(-1));
		
		Button Intake_OUT = new JoystickButton(operatorJoystick, RobotMap.INTAKE_IN);
		Intake_OUT.whileHeld(new LeftMotor(-1));
		
		Button Intake_OUT2 = new JoystickButton(operatorJoystick, RobotMap.INTAKE_IN);
		Intake_OUT.whileHeld(new RightMotor(1));
		
		Button launcherArmsUpButton = new JoystickButton(operatorJoystick, RobotMap.LAUNCHER_ARMS_DOWN);
		launcherArmsUpButton.whileHeld(new Loader(-.3));
		
		Button launcherArmsDownButton = new JoystickButton(operatorJoystick, RobotMap.LAUNCHER_ARMS_UP);
		launcherArmsDownButton.whileHeld(new Arm(.3));
		
		Button GrabberExpand = new JoystickButton(operatorJoystick, RobotMap.GRABBER_IN);
		GrabberExpand.whenPressed(new GrabberSolenoidExpand());
		
		Button GrabberRetract = new JoystickButton(operatorJoystick, RobotMap.GRABBER_OUT);
		GrabberRetract.whenPressed(new GrabberSolenoidRetract());
		
		Button transmissionSolenoidExpandButton = new JoystickButton(operatorJoystick, RobotMap.TRANSMISSION_SOLENOID_EXPAND_BUTTON);
		transmissionSolenoidExpandButton.whileHeld(new TransmissionSolenoidExpand());
		
		Button ClimberButton = new JoystickButton(operatorJoystick, RobotMap.CLIMBER_BUTTON);
		ClimberButton.whileHeld(new Climber(.5));
		
		Button LightsButton = new JoystickButton(operatorJoystick, RobotMap.INTAKE_IN);
		LightsButton.whileHeld(new Lights(-0.99));
		
		Button LightsButton1 = new JoystickButton(operatorJoystick, RobotMap.INTAKE_OUT);
		LightsButton1.whileHeld(new Lights(-0.99));
		
		Button LightsButton2 = new JoystickButton(operatorJoystick, RobotMap.CLIMBER_BUTTON);
		LightsButton2.whileHeld(new Lights(-0.99));
		
		Button LightsButton4 = new JoystickButton(operatorJoystick, RobotMap.LIGHT_BUTTON);
		LightsButton4.toggleWhenPressed(new Lights(-0.99));
	
	}
	
}
