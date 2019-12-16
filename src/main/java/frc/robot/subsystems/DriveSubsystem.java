/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Encoder.IndexingType.*;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.LEFT_MOTOR_TALON);
  WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_MOTOR_TALON);

  DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  //EXPERIMENTAL CODE: Unsure of inversion and whether Encoder.EncodingType.k4X necessary
  Encoder leftEncoder = new Encoder(RobotMap.leftEncoderPorts[0], RobotMap.leftEncoderPorts[1], false);
  Encoder rightEncoder = new Encoder(RobotMap.rightEncoderPorts[0], RobotMap.rightEncoderPorts[1], true);

  public DriveSubsystem(){

  }
  
  public void teleopDrive(double leftPower, double rightPower) {
    drive.tankDrive(leftPower, rightPower);
  }

  public void driveForwardSetSpeed(){
    drive.tankDrive(RobotMap.DEFAULT_SPEED, RobotMap.DEFAULT_SPEED);
  }

  // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  public void initDefaultCommand(){
    setDefaultCommand(new TeleopDrive());
  }

  //private void increment(){currentMotorSpeed += 0.05;}
  //private void decrement(){currentMotorSpeed -= 0.05;}
}
