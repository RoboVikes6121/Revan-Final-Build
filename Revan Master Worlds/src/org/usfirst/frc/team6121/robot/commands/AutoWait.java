package org.usfirst.frc.team6121.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoWait extends Command {
	double timeout;
	
	public AutoWait(double timeout) {
		this.timeout = timeout;
	}

	protected void initialize() {
		setTimeout(timeout);
	}


	protected void execute() {

	}


	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}


	protected void interrupted() {
		this.end();
	}
	
}
