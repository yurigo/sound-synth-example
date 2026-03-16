public class Main {
    public static void main(String[] args) {

        //SoundSynth synth = new SoundSynth();
        SoundSynth sineSynth = new SoundSynthSine();
        
        // TODO:
        // SoundSynth squareSynth = new SoundSynthSquare();
        // SoundSynth triangleSynth = new SoundSynthTriange();
        // SoundSynth sawtoothSynth = new SoundSynthSawtooth();

        try{
            sineSynth.makeSound(440, 1000);
            sineSynth.makeSound(440, 200);
            sineSynth.makeSound(700, 500);
            sineSynth.makeSound(440, 1000);

            // TODO
            // synth.makeSound(WaveType.SQUARE, 440, 1000);
            // synth.makeSound(WaveType.SQUARE, 440, 200);
            // synth.makeSound(WaveType.SQUARE, 700, 500);
            // synth.makeSound(WaveType.SQUARE, 440, 1000);

            // synth.makeSound(WaveType.TRIANGLE, 440, 1000);
            // synth.makeSound(WaveType.TRIANGLE, 440, 200);
            // synth.makeSound(WaveType.TRIANGLE, 700, 500);
            // synth.makeSound(WaveType.TRIANGLE, 440, 1000);

            // synth.makeSound(WaveType.SAWTOOTH, 440, 1000);
            // synth.makeSound(WaveType.SAWTOOTH, 440, 200);
            // synth.makeSound(WaveType.SAWTOOTH, 700, 500);
            // synth.makeSound(WaveType.SAWTOOTH, 440, 1000);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}