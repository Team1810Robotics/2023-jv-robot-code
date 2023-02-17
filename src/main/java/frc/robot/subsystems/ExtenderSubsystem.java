package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.Encoder;

import static frc.robot.Constants.*;

public class ExtenderSubsystem extends SubsystemBase{

    public static Relay extender;
    private final Encoder encoder = new Encoder(ArmConstants.EXTENDER_ENCODER_PORTS[0],ArmConstants.EXTENDER_ENCODER_PORTS[1]);



    public ExtenderSubsystem() {
        extender = new Relay(ArmConstants.EXTENDER_RELAY);
    }

    public void extend() {
        if (encoder.getStopped()){
            extender.set(Relay.Value.kForward);
            new WaitCommand(2);
            extender.stopMotor();
        } else { //This is temporary
            extender.stopMotor();
        }
    }
}
