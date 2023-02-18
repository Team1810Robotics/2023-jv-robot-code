package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class DriveSubsystem extends SubsystemBase {

    @SuppressWarnings("unused")
    private static final PigeonIMU pigeon = new PigeonIMU(DriveConstants.PIGEON);
    @SuppressWarnings("unused")
    private final DifferentialDriveOdometry odometer;

    private PWMSparkMax frontLeftMotor;
    private PWMSparkMax backLeftMotor;

    private PWMSparkMax frontRightMotor;
    private PWMSparkMax backRightMotor;

    private MotorControllerGroup rightDrive;
    private MotorControllerGroup leftDrive;

    private DifferentialDrive differentialDrive;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public DriveSubsystem() {
        frontLeftMotor = new PWMSparkMax(DriveConstants.FRONT_LEFT_MOTOR_ID);
        frontRightMotor = new PWMSparkMax(DriveConstants.FRONT_RIGHT_MOTOR_ID);

        backLeftMotor = new PWMSparkMax(DriveConstants.BACK_LEFT_MOTOR_ID);
        backRightMotor = new PWMSparkMax(DriveConstants.BACK_RIGHT_MOTOR_ID);

        leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        leftDrive.setInverted(DriveConstants.LEFT_INVERTED);

        rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
        rightDrive.setInverted(DriveConstants.RIGHT_INVERTED);

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);

        leftEncoder = new Encoder(0, 1);
        rightEncoder = new Encoder(2, 3);

        pigeon.setFusedHeading(0.0);

        odometer = new DifferentialDriveOdometry(pigeon.getYaw(), 0, 0); //TODO:getYaw needs to be changed to a Rotation2D
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
