package org.usfirst.frc.team6121.robot.subsystems;

import org.usfirst.frc.team6121.robot.RobotMap;
import org.usfirst.frc.team6121.robot.commands.Lights;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class PneumaticSubsystem extends Subsystem {

   // Put methods for controlling this subsystem
   // here. Call these from Commands.
	
	static Solenoid transmissionSolenoid = RobotMap.transmissionSolenoid;
	static DoubleSolenoid ArmsSolenoid = RobotMap.ArmsSolenoid;
	static DoubleSolenoid GrabberSolenoid = RobotMap.GrabberSolenoid;
	
	public static boolean running;

   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   	
   }
   
   public static void ArmsUpExpand() {
   	ArmsSolenoid.set(DoubleSolenoid.Value.kForward);
   	
   }
   
   public static void ArmsDownExpand() {
   	ArmsSolenoid.set(DoubleSolenoid.Value.kReverse);
   	
   }
   
   public static void ArmsSolenoidExpandOff() {
   	ArmsSolenoid.set(DoubleSolenoid.Value.kOff);
   	
   }
   
   public static void GrabberExpand() {
    GrabberSolenoid.set(DoubleSolenoid.Value.kForward);
	   	
   }
	   
   public static void GrabberRetract() {
	GrabberSolenoid.set(DoubleSolenoid.Value.kReverse);
	   	
   }
	   
   public static void GrabberSolenoidExpandOff() {
	GrabberSolenoid.set(DoubleSolenoid.Value.kOff);
	   	
   }
   
   public static void transmissionSolenoidExpand() {
   	transmissionSolenoid.set(true);
   	
   }
   
   public static void transmissionSolenoidOff() {
   	transmissionSolenoid.set(false);
   	
   }
   
  
	   	
   }
   


