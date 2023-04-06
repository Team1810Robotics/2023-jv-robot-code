package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtenderSubsystem;

public class Extender extends CommandBase {

    private ExtenderSubsystem extenderSubsystem;

    private static boolean previous;

    public Extender(ExtenderSubsystem extenderSubsystem){

        this.extenderSubsystem = extenderSubsystem;

        previous = extenderSubsystem.getLS();

    }

    @Override
    public void execute(){
        extenderSubsystem.extend();
    }
    /**This is Edge Detection, previous starts equal to whatever the LS reads, 
     * then changes to whatever current is after the cycle (current is updated 
     * to be whatever the LS reads). This essentially means that the program
     * will not stop until it reaches the cycle where previous is false, meaning
     * the LS is not triggered, and current is true, meaning it was just triggered.*/
    @Override
    public boolean isFinished(){
        boolean finished;
        boolean current = extenderSubsystem.getLS();
        if (!previous && current){
            finished = true;
        } else {
            finished = false;
        }
        previous = current;
        return finished;
    }

    @Override
    public void end(boolean interrupted){
        extenderSubsystem.stop();
    }

}
