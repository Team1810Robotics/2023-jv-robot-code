package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
//import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class DriveSubsystem extends SubsystemBase {

    @SuppressWarnings("unused")
    private static final PigeonIMU pigeon = new PigeonIMU(DriveConstants.PIGEON);

    private final DifferentialDriveOdometry odometer;

    private PWMSparkMax frontLeftMotor;
    private PWMSparkMax backLeftMotor;

    private PWMSparkMax frontRightMotor;
    private PWMSparkMax backRightMotor;

    private MotorControllerGroup rightDrive;

    private MotorControllerGroup leftDrive;

    private DifferentialDrive differentialDrive;

    public DriveSubsystem() {
        frontLeftMotor = new PWMSparkMax(DriveConstants.FRONT_LEFT_MOTOR_ID);
        //.setInverted(DriveConstants.LEFT_INVERTED);

        backLeftMotor = new PWMSparkMax(DriveConstants.BACK_LEFT_MOTOR_ID);
        //backLeftMotor.setInverted(DriveConstants.LEFT_INVERTED);

        frontRightMotor = new PWMSparkMax(DriveConstants.FRONT_RIGHT_MOTOR_ID);
        //frontRightMotor.setInverted(DriveConstants.RIGHT_INVERTED);

        backRightMotor = new PWMSparkMax(DriveConstants.BACK_RIGHT_MOTOR_ID);
        //backRightMotor.setInverted(DriveConstants.RIGHT_INVERTED);

        leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        leftDrive.setInverted(DriveConstants.LEFT_INVERTED);

        rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
        rightDrive.setInverted(DriveConstants.RIGHT_INVERTED);

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);

        odometer = new DifferentialDriveOdometry(new Rotation2d(), 0, 0);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed, true);
    }

    public void stop() {
        leftDrive.set(0);
        rightDrive.set(0);
    }

    @Override
    public void periodic() {
        //double leftAvg = 

        //odometer.update(pigeon.getYaw(),);
    }
}
