package piano;

import processing.core.PApplet;

public class Banner{
    protected Play play;

    /**
     * Constructor for the Banner class
     */
    public Banner(){
        this.play = new Play();
    }

    /**
     * Draw the banner and all the buttons on it
     * 
     * @param app       the app where to draw 
     * @param cursor    the cursor to be drawed
     * @param grid      the grid to be drawed
     * @param music     the piano to be drawed
     */
    public void draw(PApplet app, Cursor cursor, Grid grid, Music music){ // draw all buttons on banner
        app.image(app.loadImage("src/main/resources/banner.png"), 0, 0);
        for(int i = 5; i <= 410; i += 45){
            if(i == 230){
                continue;
            }
            app.image(app.loadImage("src/main/resources/buttonBack.png"), i, 5);
        }
        app.image(app.loadImage("src/main/resources/stop.png"), 50, 5);
        app.image(app.loadImage("src/main/additional resources/reset.png"), 95, 5);
        app.image(app.loadImage("src/main/additional resources/save.png"), 140, 5);
        app.image(app.loadImage("src/main/additional resources/load.png"), 185, 5);
        play.draw(app);
        if(play.getPlaystart() == true){
            cursor.move();
            music.music(grid, cursor);
        }
    }

    /**
     * while user click a button on banner, do the effect of the button.
     * 
     * Play button: Change between playback and edit mode.   
     * Stop button: Reset the cursor to the beginning of the track. If it is in playback mode(playing), change it to edit medo(pause).    
     * Reset button: De-activate all blocks on the piano roll and cursor returns to the start of the track. If it was playing(playmode), stop playback.    
     * Save button: Save current state of piano roll and current instrument. If it was playing(playmode), stop playback.   
     * Load button: Load a previously saved track. If it was playing(playmode), stop playback.   
     * Prev button("-"): Changes to previous instrument.   
     * Next button("-"): Changes to next instrument.   
     *  
     * @param x           the current horizontal coordinate of the mouse
     * @param cursor      the cursor to move
     * @param grid        the grid to change
     * @param music       the music to make sound
     * @param save_load   save/load current actived blocks and instrument
     */
    public void move(int x, Cursor cursor,Grid grid, Music music, Save_Load save_load){
        cursor.buttonchange(x); // bck
        grid.buttonchange(x); // reset blocks
        save_load.buttonchange(x);
        play.buttonchange(x); // play/pause
        music.buttonchange(x);
        music.changeMusic(x);
    }
}