package frc.robot.commands.paths;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Claw;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.commands.Extender;

public class ScoreDock extends SequentialCommandGroup {
    public ScoreDock(DriveSubsystem driveSubsystem, ClawSubsystem clawSubsystem, ExtenderSubsystem extenderSubsystem){
        Trajectory trajectory1 = driveSubsystem.loadTrajectoryFromFile("ScoreDock");

        addCommands(
            new InstantCommand(() -> {
                driveSubsystem.resetOdometry();
            }),
            new InstantCommand(() -> {
                extenderSubsystem.extend(); //TODO: Unless fixed, this will extend and retract on repeat.
            }),
            new InstantCommand(() -> {
                clawSubsystem.grab(); //Same with this
            })
        );
    }
}
