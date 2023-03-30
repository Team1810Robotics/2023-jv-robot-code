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

public class ScoreOverDockOffline extends SequentialCommandGroup {
    public ScoreOverDockOffline(ExtenderSubsystem extenderSubsystem, ClawSubsystem clawSubsystem, DriveSubsystem driveSubsystem, GearShiftSubsystem gearShiftSubsystem) {
                    // drop cube
        addCommands(//new Extender(extenderSubsystem),
                    //new Claw(clawSubsystem),
                    new WaitCommand(0.5),

                    // drive back
                    new Balance(-0.7, -0.7, 2.0, 0.01, driveSubsystem)
                    //new WaitCommand(3.0)

                    // reset claw
                    //new Claw(clawSubsystem),
                    //new Extender(extenderSubsystem)
                    );
    }
}