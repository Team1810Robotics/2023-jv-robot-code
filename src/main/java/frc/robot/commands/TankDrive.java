package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

import frc.robot.Constants.*;

public class TankDrive extends CommandBase {
    
    private DoubleSupplier leftInput;
    private DoubleSupplier rightInput;
    private DriveSubsystem driveSubsystem;

    
    public TankDrive(DoubleSupplier leftInput, DoubleSupplier rightInput, DriveSubsystem driveSubsystem) {
        this.leftInput = leftInput;
        this.rightInput = rightInput;
        this.driveSubsystem = driveSubsystem;

        addRequirements(driveSubsystem);
    }
    @Override
    public void execute(){
        driveSubsystem.drive
        (
        deadband(leftInput.getAsDouble()), 
        trim(deadband(rightInput.getAsDouble()))
        );
    }

    //Ignores values from the controller that are less than the deadband.
    public double deadband(double value) {
        if (Math.abs(value) >= DriveConstants.DEADBAND) {
            return (value - DriveConstants.DEADBAND) / (1 - DriveConstants.DEADBAND);
        }

        return 0;
    }

    public double trim(double value) {
        if (value > 0) {
            value += DriveConstants.POSITIVE_TRIM;
        } else if (value < 0) {
            value += DriveConstants.NEGATIVE_TRIM;
        }
        return value;
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.stop();
    }
}