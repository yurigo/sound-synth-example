import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class SoundSynthSine extends SoundSynth {

    @Override
    public void makeSound(int numberOfTimesFullFuncPerSec, int durationMs) throws LineUnavailableException {
        System.out.println(String.format("Starting to make sound %s %d at %d ms", "sine", numberOfTimesFullFuncPerSec, durationMs));
        byte[] buf = new byte[2];
        int frequency = 44100; //44100 sample points per 1 second
        AudioFormat af = new AudioFormat((float) frequency, 16, 1, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open();
        sdl.start();
        for (int i = 0; i < durationMs * (float) frequency / 1000; i++) {
            float numberOfSamplesToRepresentFullFunc = (float) frequency / numberOfTimesFullFuncPerSec;
            double phase = (i % numberOfSamplesToRepresentFullFunc) / numberOfSamplesToRepresentFullFunc;

            //////////////////////////////////////////
            double value = 0.0;
            value = Math.sin(2 * Math.PI * phase);
            //////////////////////////////////////////

            short a = (short) (value * 32767);
            buf[0] = (byte) (a & 0xFF);
            buf[1] = (byte) (a >> 8);
            sdl.write(buf, 0, 2);
        }

        sdl.drain();
        sdl.stop();
    }
}
