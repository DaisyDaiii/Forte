package piano;

import processing.core.PApplet;

public class Play implements ButtonChange{
    /**
     * @playstart   true: playback mode  false: edit mode
     */
    private boolean playstart;

    /**
     * Constructor for the Play class
     */
    public Play(){
        this.playstart = false;
    }

    /**
     * Draw the graph of play buttton on app frame
     * while in edit mode, the button has the play sprite rendered
     * While in playback mode, the button has the pause sprite rendered
     * 
     * @param app   the app where to draw
     */
    public void draw(PApplet app){
        if(playstart == false){
            app.image(app.loadImage("src/main/resources/play.png"), 5, 5);
        }else{
            app.image(app.loadImage("src/main/resources/pause.png"), 5, 5);
        }
    }

    /**
     * change mode of the program, between playback and edit mode
     * Playback mode: playstart == true. The cursor moves, all sound on, and the button’s sprite changes to pause.
     * Edit mode: playstart == false. The cursor stops in its place, all sound stops, and the button’s sprite changes to play.
     * @param x      the current horizontal coordinate of the mouse
     * @return       return whether the mode is changed
     */
    public boolean buttonchange(int x){
        if(x > 5 && x < 45){
            playstart = !playstart;
            return true;
        }
        if((x > 50 && x < 90)||(x > 95 && x < 135)||(x > 140 && x < 180)||(x > 185 && x < 225)){
            playstart = false;
            return true;
        }
        return false;
    }

    /**
     * return the status of play mode
     * 
     * @return   status of play mode
     */
    public boolean getPlaystart(){
        return playstart;
    }
}