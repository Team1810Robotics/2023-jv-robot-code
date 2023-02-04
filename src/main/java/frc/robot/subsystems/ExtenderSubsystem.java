package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class ExtenderSubsystem extends SubsystemBase{

    public static Relay extender;
    public static DigitalInput extenderLS;

    public ExtenderSubsystem() {
        extender = new Relay(ArmConstants.EXTENDER_RELAY);
        extenderLS = new DigitalInput(ArmConstants.EXTENDER_LS);
    }

    public void extend() {
        if (!extenderLS.get()){
            extender.set(Relay.Value.kForward); //TODO: Check to make sure this is ok and won't break.
        } else {
            extender.stopMotor();
        }
    }
}
