package org.usfirst.frc.team6121.robot.commands;

import org.usfirst.frc.team6121.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climber extends Command {
	
	public double speed;

    public Climber(double r) {
    	requires(Robot.Climber);
       	speed = r;
       	
       	//time = t;
           // Use requires() here to declare subsystem dependencies
           // eg. requires(chassis);
       	
       }

       // Called just before this Command runs the first time
       protected void initialize() {
       	//setTimeout(time);
       }

       // Called repeatedly when this Command is scheduled to run
       protected void execute() {
       	Robot.Climber.setSpeed(speed);
    	
       	
       }

       // Make this return true when this Command no longer needs to run execute()
       protected boolean isFinished() {
       	return isTimedOut();
       }

       // Called once after isFinished returns true
       protected void end() {
       	Robot.Climber.setSpeed(0);
       }

       // Called when another command which requires one or more of the same
       // subsystems is scheduled to run
       protected void interrupted() {
       	end();
       }
    }
