package org.usfirst.frc.team6121.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
*
*/
public class RightSideAuton extends CommandGroup {

   public RightSideAuton() {
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
	   
	 //Drive, Turn, Time//
	   //Drive Forward = Positive
	   //Drive Backwards = Negetive
	   //Turn Right = Positive
	   //Turn Left = Negetive
	   
	   addSequential(new Drive(.7, .5, 1));
	   addSequential(new Drive(.7, -.6, 1.2));
	   addSequential(new Drive(.55, 0, 1));
	   addParallel(new AutonLeftMotor(1, 3));
	   addSequential(new AutonRightMotor(-1, 3));
	   addSequential(new Lights(-.99));
	   
	   
	   //addSequential(new Drive(-.6, 0, 1));
	   // addSequential(new SolenoidArmsUp());
	   //addSequential(new Drive(0, -.5, 1));
	   //addParallel(new Drive(.6, 0, 1));
	   //addParallel(new AutonLeftMotor(1, 1));
	   //addSequential(new AutonRightMotor(-1, 1));
	   //addSequential(new Drive(-.6, 0, 1));
	   //addSequential(new Drive(0, .5, 1));
	   //addSequential(new Drive(.5, 0, 1));
	   //addParallel(new AutonLeftMotor(1, 1));
	   //addSequential(new AutonRightMotor(-1, 1));
	   
	   
	   //addSequential(new Lights(-0.99));
	   
	   
	  // addSequential(new Drive(.8, -.9, 1.4));
	   //addSequential(new Drive(-.8, -.9, 1.4));
	   
	   //addParallel(new AutonLeftMotor(-1, 1));
	   //addSequential(new AutonRightMotor(1, 1));
	   
	   //addSequential(new DriveStraight(0, 1, 1));
	   
	   //addSequential(new SolenoidArmsDown());
	   
	   //addSequential(new Drive(-.8, 0, .7));
	   
	   //addParallel(new DriveStraight(0, -1, .8));
	   //addParallel(new AutonLeftMotor(1, 1.4));
	   //addSequential(new AutonRightMotor(-1, 1.4));
	   
	   //addSequential(new SolenoidArmsUp());
	   
	   //addSequential(new DriveStraight(0, 1, .9));
	   
	   //addSequential(new Drive(.9, 0, .8));
	  
	   //addSequential(new DriveStraight(0, -1, .9));
	   
	   //addParallel(new AutonLeftMotor(-1, 1));
	   //addSequential(new AutonRightMotor(1, 1));
	   
	   //addSequential(new Lights(-0.99));
	   
	   
   	
	 //  addSequential(new Drive(.5, 0, .8));
	  // addSequential(new Drive(0, .6, .9));
	  // addSequential(new Drive(.5, 0, 2.2));
	  // addSequential(new Drive(0, -.65, .7));
	//   addSequential(new Drive(.6, 0, 2));
	   //addSequential(new PlaceCubeSwitch(-.6, 4));
	   //addSequential(new PlaceCubeSwitch(.6, 1));
   	
   }


	
}

