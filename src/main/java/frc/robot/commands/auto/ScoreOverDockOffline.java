package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Claw;
import frc.robot.commands.Extender;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

public class ScoreOverDockOffline extends SequentialCommandGroup {
    public ScoreOverDockOffline(ExtenderSubsystem extenderSubsystem, ClawSubsystem clawSubsystem, DriveSubsystem driveSubsystem) {
                    // drop cube
        addCommands(new Extender(extenderSubsystem),
                    new Claw(clawSubsystem),
                    new WaitCommand(0.5),

                    // drive back
                    new Balance(-0.75, -0.75, 4.75, 0.5, driveSubsystem),

                    // reset claw
                    new Claw(clawSubsystem),
                    new Extender(extenderSubsystem));
    }
}
