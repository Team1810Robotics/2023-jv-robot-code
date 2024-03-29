package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearShiftSubsystem;

public class GearShift extends CommandBase {

    private GearShiftSubsystem gearShiftSubsystem;
    private String shiftDirection;

    public GearShift(GearShiftSubsystem gearShiftSubsystem, String shiftDirection) {
        this.gearShiftSubsystem = gearShiftSubsystem;
        this.shiftDirection = shiftDirection;

        addRequirements(gearShiftSubsystem);
    }

    @Override
    public void execute() {

        System.out.println(shiftDirection);

        if (shiftDirection.equals("up")) {
            gearShiftSubsystem.shiftDown();
        } else if (shiftDirection.equals("down")) {
            gearShiftSubsystem.shiftUp();
        }
    }

    @Override
    public boolean isFinished() {
        return false;// ((shiftState && shiftAngle >= 150) || (!shiftState && shiftAngle <= 30));
    }

/*     @Override
    public void end(boolean interrupted){

    } */
}