// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Claw;
import frc.robot.commands.Extender;
import frc.robot.commands.GearShift;
import frc.robot.commands.TankDrive;
import frc.robot.commands.auto.ScoreOffline;
import frc.robot.commands.auto.Score;
//import frc.robot.commands.auto.ScoreBalance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.GearShiftSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private DriveSubsystem driveSubsystem = new DriveSubsystem();
  private ExtenderSubsystem extenderSubsystem = new ExtenderSubsystem();
  private ClawSubsystem clawSubsystem = new ClawSubsystem();
  private GearShiftSubsystem gearShiftSubsystem = new GearShiftSubsystem();

  private final XboxController manipulatorController = new XboxController(OperatorConstants.MANIPULATOR_CONTROLLER_PORT);

  public static Joystick leftJoystick = new Joystick(OperatorConstants.LEFT_JOYSTICK_PORT);
  public static Joystick rightJoystick = new Joystick(OperatorConstants.RIGHT_JOYSTICK_PORT);

  private final JoystickButton manipulatorXbox_LB = new JoystickButton(manipulatorController, 5);
  private final JoystickButton manipulatorXbox_RB = new JoystickButton(manipulatorController, 6);
  public static final JoystickButton rightJoystick_11 = new JoystickButton(rightJoystick, 11);

  private SendableChooser<Command> autoChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new TankDrive(
        () -> -leftJoystick.getY(),
        () -> -rightJoystick.getY(),
        driveSubsystem)
    );

    autoChooser.setDefaultOption("No Auto", new InstantCommand());  
    autoChooser.addOption("ScoreOffline", new ScoreOffline(extenderSubsystem, clawSubsystem, driveSubsystem, gearShiftSubsystem));
    autoChooser.addOption("Score", new Score(extenderSubsystem, clawSubsystem, driveSubsystem, gearShiftSubsystem));
    Shuffleboard.getTab("Auto").add("Auto Chooser", autoChooser);

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    manipulatorXbox_LB.onTrue(new Extender(extenderSubsystem));
    manipulatorXbox_RB.onTrue(new Claw(clawSubsystem).withTimeout(2.0));
    rightJoystick_11.whileTrue(new GearShift(gearShiftSubsystem, "down"))
                    .whileFalse(new GearShift(gearShiftSubsystem, "up"));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
   return autoChooser.getSelected();
  }
}
