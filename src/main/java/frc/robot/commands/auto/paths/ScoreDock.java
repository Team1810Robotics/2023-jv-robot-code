package frc.robot.commands.auto.paths;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;

public class ScoreDock extends CommandBase {

    private DriveSubsystem drive;
    private ClawSubsystem claw;
    private ExtenderSubsystem extender;

    private Autonomous dock;

    public ScoreDock(DriveSubsystem driveSubsystem, ClawSubsystem clawSubsystem, ExtenderSubsystem extenderSubsystem) {
        this.drive = driveSubsystem;
        this.claw = clawSubsystem;
        this.extender = extenderSubsystem;

        this.dock = new Autonomous();

        addRequirements(driveSubsystem, clawSubsystem, extenderSubsystem);
    }

    @Override
    public void execute() {
        var speed = dock.autoDockRoutine();
        drive.drive(-speed, -speed);
    }
}