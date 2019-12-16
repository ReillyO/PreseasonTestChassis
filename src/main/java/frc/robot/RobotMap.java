/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/*
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //Motors
  public static final int RIGHT_MOTOR_TALON = 1;
  public static final int LEFT_MOTOR_TALON = 2;

  //Encoders
  public static final int[] leftEncoderPorts = {0, 1};
  public static final int[] rightEncoderPorts = {2, 3};

  //Procedure constants
  public static double MAX_SPEED = 0.75;
  public static double DEFAULT_SPEED = 0.5;
  public static int DISTANCE_TO_DRIVE = 2;
  public static double CURRENT_SPEED = 0.0;
  
  //Controller constants
  public static final int PLAYSTATION_PORT = 0;
  public static final double JOYSTICK_DEADBAND = 0.05;
}
