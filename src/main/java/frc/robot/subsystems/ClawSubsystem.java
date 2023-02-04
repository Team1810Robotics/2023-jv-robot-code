package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ClawSubsystem extends SubsystemBase {
    public static Relay claw;
    public static DigitalInput clawLS;
    
    public ClawSubsystem () {
        claw = new Relay(ArmConstants.CLAW_RELAY);
        clawLS = new DigitalInput(ArmConstants.CLAW_LS);
    }
    public void grab () {
        if(!clawLS.get()) {
            claw.set(Relay.Value.kForward);
        } else {
            claw.stopMotor();
        }
    }
}
