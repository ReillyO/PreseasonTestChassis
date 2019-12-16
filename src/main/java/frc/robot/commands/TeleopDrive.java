/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class TeleopDrive extends Command {
  public TeleopDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Gets the joystick Y-Values, inverts them as befits the Y-axis.
    if(Math.abs(Robot.OI.getPlaystationLeft()) > RobotMap.JOYSTICK_DEADBAND || Math.abs(Robot.OI.getPlaystationRight()) > RobotMap.JOYSTICK_DEADBAND){
      double leftPower = -threshold(Robot.OI.getPlaystationLeft());
      double rightPower = -threshold(Robot.OI.getPlaystationRight());
      Robot.driveSubsystem.teleopDrive(leftPower, rightPower);
    }
    //Testing button functionality; will slowly turn the wheels if the button is
    //being pressed(hopefully)
    if(Robot.OI.getButtonStatus()){
      Robot.driveSubsystem.driveForwardSetSpeed();
    }
    //Robot.OI.refreshSpeed();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  //Method to control power to the motors and account for
  //joystick deadband
  private double threshold(double powerValue){
    if(powerValue > RobotMap.MAX_SPEED)
      powerValue = RobotMap.MAX_SPEED;
    else if(powerValue < -RobotMap.MAX_SPEED)
      powerValue = -RobotMap.MAX_SPEED;
    else if(Math.abs(powerValue) < RobotMap.JOYSTICK_DEADBAND)
      powerValue = 0.0;
    
    return powerValue;
  }

  private double thresholdLines(double powerValue){
    double motorPower = 0;
    if (powerValue < 0.25 && powerValue > -0.25){
        motorPower = 0.1*powerValue;
    }
    else if(powerValue < 0.75 && powerValue > -0.75){
      motorPower = 0.5*powerValue;
    }
    else if(Math.abs(powerValue) < RobotMap.JOYSTICK_DEADBAND){
      motorPower = 0.0;
    }
    else{
      motorPower = powerValue;
    }
    return motorPower;
  }
}
