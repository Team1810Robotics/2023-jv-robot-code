package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Claw;
import frc.robot.commands.Extender;
import frc.robot.commands.GearShift;
import frc.robot.subsystems.GearShiftSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

public class ScoreOffline extends SequentialCommandGroup {
    public ScoreOffline(ExtenderSubsystem extenderSubsystem, ClawSubsystem clawSubsystem, DriveSubsystem driveSubsystem, GearShiftSubsystem gearShiftSubsystem) {
                    // drop cube
        addCommands(new Extender(extenderSubsystem),
                    new Claw(clawSubsystem),
                    new WaitCommand(0.5),

                    // drive back
                    new Drive(-0.75, -0.75, driveSubsystem, 5),

                    // reset claw
                    new Claw(clawSubsystem),
                    new Extender(extenderSubsystem));
    }
}
