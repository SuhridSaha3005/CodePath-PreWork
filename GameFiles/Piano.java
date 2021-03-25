package GameFiles;
import edu.princeton.cs.introcs.Stopwatch;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.awt.*;
import java.util.HashMap;

/* This class helps play our keys with sounds and color changes */
class Piano {
    private final HashMap<Integer, Integer> notes; // Map to find index corresponding to given note
    private final MidiChannel[] channels; // Needed to play our synthesizer
    private final GamePanel panel; // The Game Panel where everything runs/is drawn
    private static final int INSTRUMENT = 0; // 0 corresponds to Piano
    private static final int VOLUME = 100; // Volume is between 0 and 127
    private static final int OCTAVE = 5; // Octaves/Scales in piano

    /* Constructor for our Piano class */
    public Piano(GamePanel panel) {
        this.panel = panel;
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            notes = new HashMap<>();
            notes.put(1, 0); // C Note
            notes.put(2, 2); // D Note
            notes.put(3, 4); // E Note
            notes.put(4, 5); // F Note
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* Plays note corresponding to given key; Uses helper method (see below) */
    /* 1 = Red/C Note, 2 = Yellow/D Note, 3 = Blue/E Note, 4 = Green/F Note */
    public void play(int note) {
        if (note == 1) {
            play(note, Color.PINK, Color.RED);
        } else if (note == 2) {
            play(note, Color.ORANGE, Color.YELLOW);
        } else if (note == 3) {
            play(note, Color.MAGENTA, Color.BLUE);
        } else {
            play(note, Color.CYAN, Color.GREEN);
        }
    }

    /* Helper method for playing note (see above) */
    private void play(int note, Color color, Color originalColor) {
        panel.changeRectColor(note, color);
        panel.update(panel.getGraphics());
        Stopwatch sw = new Stopwatch();
        channels[INSTRUMENT].noteOn(id(note), VOLUME);
        while (sw.elapsedTime() < 1) {} // Plays note for 1 second
        channels[INSTRUMENT].noteOff(id(note));
        panel.changeRectColor(note, originalColor);
        panel.update(panel.getGraphics());
    }

    /* Helper method to play note using channels variable */
    private int id(int note) {
        return notes.get(note) + (12 * (OCTAVE + 1));
    }
}
