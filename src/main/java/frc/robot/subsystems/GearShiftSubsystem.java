package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

import static frc.robot.Constants.*;

public class GearShiftSubsystem extends SubsystemBase{
    private Servo shiftServo;

    public GearShiftSubsystem() {
        shiftServo = new Servo(DriveConstants.SHIFT_SERVO);
    }

    public double shiftUp() {
        shiftServo.setAngle(180);
        return shiftServo.getAngle();
        
    }
    
    public double shiftDown() {
        shiftServo.setAngle(0);
        return shiftServo.getAngle();
    }    

}
