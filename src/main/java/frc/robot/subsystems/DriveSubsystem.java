package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Servo;
//import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

import java.io.IOException;
import java.nio.file.Paths;

public class DriveSubsystem extends SubsystemBase {


    private static final PigeonIMU pigeon = new PigeonIMU(DriveConstants.PIGEON);

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

    private Servo servo1;
    private Servo servo2;


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

        odometer = new DifferentialDriveOdometry(new Rotation2d(), 0, 0);

        servo1 = new Servo(DriveConstants.SERVO_1);
        servo2 = new Servo(DriveConstants.SERVO_2);

    }

    public void drive(double leftSpeed, double rightSpeed) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed, true);
    }

    public Trajectory loadTrajectoryFromFile(String filename) {
        try {
            return loadTrajectory(filename);
        } catch (IOException e) {
            DriverStation.reportError("Failed to load auto trajectory: " + filename, false);
            return new Trajectory();
        }
    }

    public Trajectory loadTrajectory(String trajectoryName) throws IOException {
        return TrajectoryUtil.fromPathweaverJson(Filesystem.getDeployDirectory().toPath().resolve(Paths.get("paths", trajectoryName + ".wpilib.json")));
    }

    public Pose2d getPose() {
        return odometer.getPoseMeters();
    }
    
    public void resetOdometry() {
        odometer.update(new Rotation2d(), 0, 0);
    }

    public void stop() {
        leftDrive.set(0);
        rightDrive.set(0);
    }

    public void shiftUp() {
        servo1.setAngle(90);
        servo2.setAngle(90);
    }

    public void shiftDown() {
        servo1.setAngle(0);
        servo2.setAngle(0);
    }

    @Override
    public void periodic() {
        odometer.update(Rotation2d.fromDegrees(pigeon.getYaw()), leftEncoder.getDistance(), rightEncoder.getDistance());
    }
}
