package piano;

import processing.core.PApplet;

public class App extends PApplet{
    protected Cursor cursor;
    protected Music music;
    protected Banner banner;
    protected Grid grid;
    protected Save_Load save_load;

    /**
     * Constructor for the App class
     */
    public App() {
        // Initialise variables here
    }

    /**
     * Defines the dimension of the display window in units of pixels.
     */
    public void settings() {
        // Don't touch
        size(540, 335);
    }

    /**
     * define initial enviroment properties: screen size，cursor, piano, banner, grid
     */
    public void setup() {
        frameRate(60);
        // Load images here
        cursor = new Cursor();
        music = new Music();
        banner = new Banner();
        grid = new Grid();
        save_load = new Save_Load(grid, music);
    }
    /**
     * draw all pictures on app
     */
    public void draw() {
        // Draw your program here
        this.image(this.loadImage("src/main/resources/middleBanner.png"), 0, 0);
        this.image(this.loadImage("src/main/resources/keyboard.png"), 0, 75);
        banner.draw(this, cursor, grid, music);
        grid.draw(this);
        cursor.draw(this);
        music.draw(this);
    }
    /**
     *  effects if clicks on banner/grid
     */
    public void mouseClicked() {
        if(mouseX > 60 && mouseY > 75){
            grid.blockchange(mouseX,mouseY);
        }
        else if(mouseY > 5 && mouseY < 45){
            banner.move(mouseX, cursor, grid, music, save_load);
        }
    }
    /**
     * running this class from the command line.
     * @param args    command line
     */
    public static void main(final String[] args) {
        PApplet.main("piano.App");
    }
}