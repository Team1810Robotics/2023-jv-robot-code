package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

import frc.robot.commands.Claw;
import frc.robot.commands.TankDrive;
import frc.robot.commands.Extender;

public class Autonomous extends SequentialCommandGroup {
    private DriveSubsystem driveSubsystem;
    private ClawSubsystem clawSubsystem;
    private ExtenderSubsystem extenderSubsystem;
    
    public Autonomous(DriveSubsystem driveSubsystem, ClawSubsystem clawSubsystem, ExtenderSubsystem extenderSubsystem) {
        this.driveSubsystem = driveSubsystem;
        this.clawSubsystem = clawSubsystem;
        this.extenderSubsystem = extenderSubsystem;

        addCommands(
            new Extender(extenderSubsystem),
            new WaitCommand(1.5),
            new Claw(clawSubsystem),
            new WaitCommand(2.0),
            new TankDrive(() -> -0.75,() -> -0.75, driveSubsystem),
            new WaitCommand(2.0),
            new Claw(clawSubsystem),
            new WaitCommand(2.0),
            new Extender(extenderSubsystem),
            new WaitCommand(1.5)
            );
    }
}