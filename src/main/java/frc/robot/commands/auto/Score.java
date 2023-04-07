package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Claw;
import frc.robot.commands.Extender;
//import frc.robot.commands.GearShift;
import frc.robot.subsystems.GearShiftSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

public class Score extends SequentialCommandGroup {
    public Score(ExtenderSubsystem extenderSubsystem, ClawSubsystem clawSubsystem, DriveSubsystem driveSubsystem, GearShiftSubsystem gearShiftSubsystem) {
                    // drop cube
        addCommands(new Extender(extenderSubsystem),
                    new Claw(clawSubsystem),
                    new WaitCommand(0.5),

                    // drive back
                    // driveSubsystem.balance()
                    //new Balance(-0.6, -0.6, 4.0, 2.0, driveSubsystem),
                    //new WaitCommand(3.0)

                    // reset claw
                    new Extender(extenderSubsystem)
                    //new Claw(clawSubsystem)

                    );
    }
}