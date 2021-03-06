package org.usfirst.frc.team6121.robot.commands;

import org.usfirst.frc.team6121.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class PlaceCubeSwitch extends Command {
	private double speed;
	private double time;

   public PlaceCubeSwitch(double s, double t) {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.climbingSubsystem);
   	speed = s;
   	time = t;
   }

   // Called just before this Command runs the first time
   protected void initialize() {
	   setTimeout(time);
   }

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
   	Robot.cubeSubsystem.setSpeedDown(speed);
   	Robot.cubeSubsystem.setSpeedUp(speed);
   }

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
       return isTimedOut();
   }

   // Called once after isFinished returns true
   protected void end() {
   	Robot.cubeSubsystem.setSpeedDown(0);
   	Robot.cubeSubsystem.setSpeedUp(0);
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   	end();
   }
}
