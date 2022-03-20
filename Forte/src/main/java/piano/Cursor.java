package piano;

import processing.core.PApplet;
import processing.core.PImage;

public class Cursor implements ButtonChange{
    /**
     *  the current horizontal coordinate of pointer
     */
    private int pointer_x;   
    /**
     *  the current horizontal coordinate of redline
     */
    private int redline_x;

    /**
     * Constructor for the Cursor class
     */
    public Cursor(){
        this.pointer_x = 49;
        this.redline_x = 60;
    }

    /**
     * Draw cusor on app frame (pointer sprite and a redline)
     * 
     * @param app   the app where to draw
     */
    public void draw(PApplet app){
        app.image(app.loadImage("src/main/resources/pointer.png"), pointer_x, 60);

        PImage redline = app.createImage(1, 260, 255);
        redline.loadPixels();
        for(int i=0;i<redline.height;i++){
            redline.pixels[i] = app.color(255,0,0);
        }
        redline.updatePixels();
        app.image(redline, redline_x, 75);
    }

    /**
     * The cursor begins stationary on the left side of the piano roll
     * While it is in playback mode(playing), the cursor moves at a constant speed to right.
     * 
     * Once the cursor reaches the end of the piano roll,
     * the cursor resets to the beginning of the piano roll and continues moving until either the pause or the stop button is pressed.
     * 
     * When playback is paused, the cursor stops in its place
     */
    public void move(){
        if(pointer_x < 540){
            pointer_x += 1;
            redline_x += 1;
        }
        else{
            pointer_x = 49;
            redline_x = 60;
        }
    }

    /**
     * reset the cursor(pointer and redline) to the beginning of the track
     * @param x       the current horizontal coordinate of the mouse
     * @return        return if cursor is back to original place
     */
    public boolean buttonchange(int x){
        if((x > 50 && x < 90)||(x > 95 && x < 135)||(x > 140 && x < 180)||(x > 185 && x < 225)){
            pointer_x = 49;
            redline_x = 60;
            return true;
        }
        return false;
    }

    /**
     * return the x coordinate of redline
     * 
     * @return     x coordinate of redline
     */
    public int get_redline(){
        return redline_x;
    }

    /**
     * return the x coordinate of pointer
     * 
     * @return    x coordinate of pointer
     */
    public int get_pointer(){
        return pointer_x;
    }
}