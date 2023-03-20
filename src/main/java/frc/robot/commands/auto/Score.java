package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

public class Score extends SequentialCommandGroup {
    public Score(ExtenderSubsystem extenderSubsystem, ClawSubsystem clawSubsystem, DriveSubsystem driveSubsystem) {
                    // drop cube
        addCommands(/* new Extender(extenderSubsystem),
                    new Claw(clawSubsystem),
                    new WaitCommand(0.5), */

                    // drive back
                    new Drive(-0.25, -0.25, driveSubsystem, 5),
                    new Drive(0, 0, driveSubsystem, 0.5)/* ,
                    // reset claw
                    new Claw(clawSubsystem),
                    new Extender(extenderSubsystem) */);
    }
}
