package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;

public class GearShift extends CommandBase {

    private DriveSubsystem driveSubsystem;
    private boolean shiftState;
    private double shiftAngle;


    public GearShift(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {

        if(RobotContainer.rightJoystick.getRawButton(1)) {
            shiftAngle = driveSubsystem.shiftUp();
            shiftState = true;
        }
        else if(RobotContainer.leftJoystick.getRawButton(1)) { 
            shiftAngle = driveSubsystem.shiftDown();
            shiftState = false;
        }
    }

    @Override
    public boolean isFinished() {
        return ((shiftState && shiftAngle >= 150) || (!shiftState && shiftAngle <= 30));
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.stop();
    }
}