package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ClawSubsystem extends SubsystemBase {
    public static Spark claw;
    public static DigitalInput clawLS;
    
    public ClawSubsystem() {
        claw = new Spark(ArmConstants.CLAW_RELAY);
        clawLS = new DigitalInput(ArmConstants.CLAW_LS);
    }
    public void grab() {
        claw.set(1.0);
    }

    public void reverse() {
        claw.set(-1.0);
    }

    public void stop() {
        claw.set(0);
    }
}
