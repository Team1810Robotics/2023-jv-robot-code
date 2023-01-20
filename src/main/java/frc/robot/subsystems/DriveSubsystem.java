package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class DriveSubsystem extends SubsystemBase {
    private PWMSparkMax leftMotor;
    private PWMSparkMax rightMotor;

    private DifferentialDrive differentialDrive;

    public DriveSubsystem() {
        leftMotor = new PWMSparkMax(DriveConstants.LEFT_MOTOR_ID);

        rightMotor = new PWMSparkMax(DriveConstants.RIGHT_MOTOR_ID);
        
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed, true);
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }
}
