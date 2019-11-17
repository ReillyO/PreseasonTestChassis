/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

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
    double leftPower = -Robot.OI.getPlaystationLeft();
    double rightPower = -Robot.OI.getPlaystationRight();

    //Dead band on the controller; makes sure tiny accidental controller movements
    //don't move the motors.
    if(Math.abs(rightPower) < RobotMap.JOYSTICK_DEADBAND) rightPower = 0.0;
    if(Math.abs(leftPower) < RobotMap.JOYSTICK_DEADBAND) leftPower = 0.0;
    
    //Basic thresholding on the power inputs for the motors.
    if(leftPower > RobotMap.MAX_SPEED) leftPower = RobotMap.MAX_SPEED;
    if(leftPower < -RobotMap.MAX_SPEED) leftPower = -RobotMap.MAX_SPEED;

    if(rightPower > RobotMap.MAX_SPEED) rightPower = RobotMap.MAX_SPEED;
    if(rightPower < -RobotMap.MAX_SPEED) rightPower = -RobotMap.MAX_SPEED;

    Robot.driveSubsystem.teleopDrive(leftPower, rightPower);
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
}
