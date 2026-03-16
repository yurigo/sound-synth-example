import javax.sound.sampled.LineUnavailableException;

public abstract class SoundSynth {

    public abstract void makeSound(
                                   int numberOfTimesFullFuncPerSec,
                                   int durationMs)
            throws LineUnavailableException;

}