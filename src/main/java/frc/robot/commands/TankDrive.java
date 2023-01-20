package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends CommandBase {
    
    private final DoubleSupplier leftInput;
    private final DoubleSupplier rightInput;
    private final DriveSubsystem driveSubsystem;
}
