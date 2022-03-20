package piano;

import processing.core.PApplet;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public abstract class Piano implements ButtonChange{
    protected Synthesizer synthesizer;
    protected MidiChannel channel;
    private int[] instrument = {0,13,106,66}; 
    private int index = 0;
    private String[] picture = {"src/main/additional resources/P.png", "src/main/additional resources/M.png", "src/main/additional resources/B.png","src/main/additional resources/S.png"};

    /**
     * Constructor for the Piano class
     */
    public Piano(){
        try{
            this.synthesizer = MidiSystem.getSynthesizer();
            this.synthesizer.open();
            this.channel = synthesizer.getChannels()[1];
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * draw the change instrument buttoms
     * 
     * @param app       the app where to draw
     */
    public void draw(PApplet app){
        app.image(app.loadImage("src/main/additional resources/prev.png"), 275, 5);
        app.image(app.loadImage("src/main/additional resources/next.png"), 365, 5);
        app.image(app.loadImage("src/main/additional resources/long.png"), 410, 5);
        app.image(app.loadImage(picture[index]), 320, 5);
    }

    /**
     * make a sound
     * @param grid       the grid to check when make sound
     * @param cursor     the cursor to check when make sound
     * @return           the explanation of this change
     */
    public abstract String music(Grid grid, Cursor cursor);

    /**
     * change instruments [P, M, B, S]
     * 
     * @param x      the current horizontal coordinate of the mouse
     * @return       return whether the instrument is changed
     */
    public boolean buttonchange(int x){
        boolean str = false;
        if(x > 365 && x < 405){
            index +=1 ;
            if(index > 3){
                index = 0;
            }
            str = true;
        }
        else if(x > 275 && x < 325){
            index -= 1;
            if(index < 0){
                index = 3;
            }
            str = true;
        }
        channel.programChange(instrument[index]);
        return str;
    }

    /**
     * return the index of current instrument
     * 
     * @return   index of current instrument
     */
    public int getIndex(){
        return index;
    }

    /**
     * change current instrument to a specified instrument
     * 
     * @param i    index of specified instrument
     */
    public void changeIndex(int i){
        index = i;
        channel.programChange(instrument[index]);
    }
}