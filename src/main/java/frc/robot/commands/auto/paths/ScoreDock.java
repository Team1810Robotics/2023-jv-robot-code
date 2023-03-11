/* package frc.robot.commands.auto.paths;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Claw;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.commands.Extender;
import com.pathplanner.lib.*;

public class ScoreDock extends SequentialCommandGroup {
    public ScoreDock(DriveSubsystem driveSubsystem, ClawSubsystem clawSubsystem, ExtenderSubsystem extenderSubsystem){
        PathPlannerTrajectory ScoreDock = PathPlanner.loadPath("ScoreDock", new PathConstraints(4, 3));

        addCommands(
            new InstantCommand(() -> {
                driveSubsystem.resetOdometry();
            }),
            new Extender(extenderSubsystem),
            new Claw(clawSubsystem)
        );
    }
}
 */