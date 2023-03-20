package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class Drive extends CommandBase {

    private DriveSubsystem driveSubsystem;

    private double leftSpeed;
    private double rightSpeed;
    private double runTimeSec;
    private double startTime;

    public Drive(double leftSpeed, double rightSpeed, DriveSubsystem driveSubsystem, double runTimeSec) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.runTimeSec = runTimeSec;
        this.driveSubsystem = driveSubsystem;

        this.startTime = Timer.getFPGATimestamp();

        addRequirements(driveSubsystem);
    }


    @Override
    public void execute() {
        driveSubsystem.sDrive(rightSpeed, leftSpeed);
    }

    @Override
    public boolean isFinished(){
        return (Timer.getFPGATimestamp() - startTime) >= runTimeSec;
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.stop();
    }
}