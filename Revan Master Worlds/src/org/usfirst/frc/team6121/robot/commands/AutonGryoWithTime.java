package org.usfirst.frc.team6121.robot.commands;

import org.usfirst.frc.team6121.robot.Robot;
import org.usfirst.frc.team6121.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonGryoWithTime extends Command {

	double speed, turn, Pgain, Dgain, MaxCorrectionRatio, targetAngle, timeout;
	double num = 0;
	public AutonGryoWithTime(double speed, double timeout, double angle) {
		requires(Robot.driveSubsystem);
		Pgain = 0.04; /* percent throttle per degree of error */
		Dgain = 0.0004; /* percent throttle per angular velocity dps */
		MaxCorrectionRatio = 0.20; /* cap corrective turning throttle to 30 percent of forward throttle */
		this.speed = speed;
	    this.timeout = timeout;
	    this.targetAngle = angle;
		
	}
	
    protected void initialize() {
    	setTimeout(timeout);
    	//Robot.gyro.resetPidgey();
    	//RobotMap.chassis_leftFront.setSelectedSensorPosition(0, 0, 0);
    	//RobotMap.chassis_rightFront.setSelectedSensorPosition(0, 0, 0);
    }
    
    protected void execute() {
    	//System.out.println(Robot.gyro.getYaw() + " exec "  +  num);
    	num++;
    	double currentAngle = RobotMap.gyro.getAngle();
    	//double currentAngularRate = Robot.gyro.getAngularRate();
    	double forward = speed; 	
    	
    	turn = (-targetAngle + currentAngle) * Pgain; // - (currentAngularRate) * Dgain;
    	
    	Robot.driveSubsystem.drive(forward, -turn);
    	
    }
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
    protected void end() {
    	//System.out.println(Robot.gyro.getYaw());
    	//RobotMap.drive.arcadeDrive(0,0,true);
    }
    
    protected void interrupted() {
    	this.end();
    }
    

}

