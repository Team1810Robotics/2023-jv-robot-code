package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class Balance extends CommandBase {
    public double leftSpeed;
    public double rightSpeed;

    public double balanceDelay;

    public double forceQuitTime;
    public double startTime;

    public DriveSubsystem driveSubsystem;

    public Balance(double leftSpeed, double rightSpeed, double forceQuitTime, double balanceDelay, DriveSubsystem driveSubsystem) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.forceQuitTime = forceQuitTime;
        this.balanceDelay = balanceDelay;
        this.driveSubsystem = driveSubsystem;

        this.startTime = Timer.getFPGATimestamp();
        
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - startTime >= balanceDelay && DriveSubsystem.balanceSwitch.get()) {
            return true;
        } else if (Timer.getFPGATimestamp() - startTime >= forceQuitTime) {
            return true;
        } else {
            return true;
        }
    }
}
