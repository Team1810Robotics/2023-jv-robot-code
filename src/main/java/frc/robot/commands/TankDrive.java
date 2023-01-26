package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

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
        driveSubsystem.drive(leftInput.getAsDouble(), rightInput.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.stop();
    }
}