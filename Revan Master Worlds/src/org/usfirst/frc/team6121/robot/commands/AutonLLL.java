package org.usfirst.frc.team6121.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonLLL extends CommandGroup {

    public AutonLLL() {
    	
    	
       addSequential(new Drive(.7, -.5, 1.1));
 	   addSequential(new Drive(.7, .6, 1));
 	   addSequential(new Drive(.5, 0, 1));
 	   addParallel(new AutonLeftMotor(1, 1));
 	   addSequential(new AutonRightMotor(-1, 1));
    	
    	
 	 addSequential(new AutonGryoWithTime(-.6, 1.3, 0));
 	 addSequential(new AutonGryoWithTime(-.7, .9, -45));
 	 addSequential(new AutonGryoWithTime(0, 0, 0));
 	 	
 	 addSequential(new SolenoidArmsUpAuton(.5));
 	 	
 	 addParallel(new AutonGryoWithTime(.5, 3, 10));	
 	 addParallel(new AutonLeftMotor(-1, 3));
     addSequential(new AutonRightMotor(1, 3));
     
     addParallel(new SolenoidArmsDownAuton(.5));
     addParallel(new AutonLeftMotor(-1, .5));
     addSequential(new AutonRightMotor(1, .5));
 		
 	 addParallel(new AutonGryoWithTime(-.5, .5, 0));
 	addParallel(new AutonLeftMotor(-1, .5));
    addSequential(new AutonRightMotor(1, .5));
 		
 	 addParallel(new AutonGryoWithTime(.7, 1.3, -45));
 	addParallel(new AutonLeftMotor(-1, 1.3));
    addSequential(new AutonRightMotor(1, 1.3));
 	 
    addParallel(new AutonGryoWithTime(.6, 1.2, 10));
    addParallel(new AutonLeftMotor(-1, 1.2));
    addSequential(new AutonRightMotor(1, 1.2));
 		
 	 addParallel(new AutonLeftMotor(1, 1));
 	 addSequential(new AutonRightMotor(-1, 1));
 		
 	 //addSequential(new AutonGryoWithTime(-.6, 1, 0));
 	 //addSequential(new AutonGryoWithTime(.7, 1, 90));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//addSequential(new AutoWait(10));
    	//addSequential(new AutonGryoWithTime(.5, 4, -60));
    	//addSequential(new AutonGryoWithTime(.5, 2, 0));
    	/*addParallel(new AutonLeftMotor(1, 1));
    	addSequential(new AutonRightMotor(-1, 1));
    	addSequential(new AutoWait(.5));
    	addSequential(new AutonGryoWithTime(-.5, 2, 0));
    	addSequential(new AutonGryoWithTime(.7, 2.5, 75));
    	addSequential(new AutonGryoWithTime(.5, 1.5, 0));
    	*/
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*addSequential(new AutoWait(10));
    	addSequential(new AutonGryoWithTime(.5, 4, -45));
      	addSequential(new Drive(.7, 0, 1.3));
    	addSequential(new AutonGryoWithTime(.5, 4, 45));
     	addSequential(new Drive(.6, 0, .2));
     	addParallel(new AutonLeftMotor(1, 1));
  	  	addSequential(new AutonRightMotor(-1, 1));
    	addSequential(new Drive(-.5, 0, 1));
    	
    	addSequential(new AutonGryoWithTime(.5, 4, 75));
    	addSequential(new Drive(.7, 0, 1.5));
      	addSequential(new AutonGryoWithTime(.5, 4, -75));
      	addSequential(new Drive(.5, 0, .5));
    	*/
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
