package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSubsystem;

public class Balance extends CommandBase {
    public double leftSpeed;
    public double rightSpeed;

    public double balanceDelay;

    public double forceQuitTime;
    public double startTime;

    public boolean previous;

    public DriveSubsystem driveSubsystem;

    public Balance(double leftSpeed, double rightSpeed, double forceQuitTime, double balanceDelay, DriveSubsystem driveSubsystem) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.forceQuitTime = forceQuitTime;
        this.balanceDelay = balanceDelay;
        this.driveSubsystem = driveSubsystem;

        previous = DriveSubsystem.balanceSwitch.get();

        this.startTime = Timer.getFPGATimestamp();
        
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(leftSpeed, rightSpeed);
    }

    public boolean isFinished(){
        boolean finished;
        boolean current = DriveSubsystem.balanceSwitch.get();
        if (!previous && current){
            Timer.delay(.35);
            finished = true;
        } else {
            finished = false;
        }
        previous = current;
        return finished;
    }

    private void WaitCommand(double d) {
    }
}
