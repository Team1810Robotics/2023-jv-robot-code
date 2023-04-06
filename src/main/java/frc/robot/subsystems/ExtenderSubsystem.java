package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;

import static frc.robot.Constants.*;

public class ExtenderSubsystem extends SubsystemBase{

    public static Relay extender;
    private static DigitalInput extenderLS;

    public ExtenderSubsystem() {
        extender = new Relay(ArmConstants.EXTENDER_RELAY);
        extenderLS = new DigitalInput(ArmConstants.EXTENDER_LS);

        Shuffleboard.getTab("Extender").addBoolean("ExtenderLS", this::getLS);
    }

    public void extend() {
        extender.set(Relay.Value.kForward);
    }

    public void stop(){
        extender.stopMotor();
    }

    public boolean getLS() {
        return extenderLS.get();
    }
}