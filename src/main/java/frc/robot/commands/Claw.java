package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;


public class Claw extends CommandBase {

    private ClawSubsystem clawSubsystem;

    private static boolean previous;

    //private static double startTime;

    public Claw(ClawSubsystem clawSubsystem){

        this.clawSubsystem = clawSubsystem;

        previous = ClawSubsystem.clawLS.get();

        //startTime = Timer.getFPGATimestamp();

    }

    

    @Override
    public void execute(){
            clawSubsystem.grab();
    }
    /**This is Edge Detection, previous starts equal to whatever the LS reads, 
     * then changes to whatever current is after the cycle (current is updated 
     * to be whatever the LS reads). This essentially means that the program
     * will not stop until it reaches the cycle where previous is false, meaning
     * the LS is not triggered, and current is true, meaning it was just triggered.*/
    @Override
    public boolean isFinished() {
        boolean finished;
        boolean current = ClawSubsystem.clawLS.get();
        if (!previous && current){
            finished = true;
        } else {
            finished = false;
        }
        /* if ((Timer.getFPGATimestamp() - startTime >= 2.0)) {
            finished = true;
        } */
        previous = current;
        return finished;
    }

    @Override
    public void end(boolean interrupted){
        clawSubsystem.stop();
    }

}
