package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Arm extends SubsystemBase{

    public static Relay extender;
    public static DigitalInput extenderLS;

    public Arm() {
        extender = new Relay(ArmConstants.EXTENDER_RELAY);
        extenderLS = new DigitalInput(ArmConstants.EXTENDER_LS);
    }
}
