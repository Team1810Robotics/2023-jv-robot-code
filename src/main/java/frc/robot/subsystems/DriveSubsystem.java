package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.commands.auto.Drive;

import static frc.robot.Constants.*;

public class DriveSubsystem extends SubsystemBase {

    private PWMSparkMax frontLeftMotor;
    private PWMSparkMax backLeftMotor;

    private PWMSparkMax frontRightMotor;
    private PWMSparkMax backRightMotor;

    private MotorControllerGroup rightDrive;
    private MotorControllerGroup leftDrive;

    public static DigitalInput balanceSwitch;

    public DriveSubsystem() {
        frontLeftMotor = new PWMSparkMax(DriveConstants.FRONT_LEFT_MOTOR_ID);
        frontRightMotor = new PWMSparkMax(DriveConstants.FRONT_RIGHT_MOTOR_ID);

        backLeftMotor = new PWMSparkMax(DriveConstants.BACK_LEFT_MOTOR_ID);
        backRightMotor = new PWMSparkMax(DriveConstants.BACK_RIGHT_MOTOR_ID);

        leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        leftDrive.setInverted(DriveConstants.LEFT_INVERTED);

        rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
        rightDrive.setInverted(DriveConstants.RIGHT_INVERTED);

        balanceSwitch = new DigitalInput(DriveConstants.BALANCE_SWITCH);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftSpeed = MathUtil.applyDeadband(leftSpeed, 0.02);
        rightSpeed = MathUtil.applyDeadband(rightSpeed, 0.02);

        var speeds = DifferentialDrive.tankDriveIK(leftSpeed, rightSpeed, true);

        leftDrive.set(speeds.left);
        rightDrive.set(speeds.right);
    }

    public void stop() {
        leftDrive.set(0);
        rightDrive.set(0);
    }
}
