package piano;

import processing.core.PApplet;
import java.io.*;

public class Save_Load implements ButtonChange{
    private Music music;
    private Grid grid;

    /**
     * Constructor for the Save class
     * @param grid     grid that store all current active blocks
     * @param music    music that make sound
     */
    public Save_Load(Grid grid, Music music){
        this.grid = grid;
        this.music = music;
    }

    /**
     * if click on save button, save current state of piano roll and current instrument
     * if click on load button, load a previously saved track
     * @param x           the current horizontal coordinate of the mouse
     * @return            return if current blocks and instrument is saved or loaded
     */
    public boolean buttonchange(int x){
        if(x > 140 && x < 180){
            this.store();
            return true;
        }
        else if(x > 185 && x < 225){
            this.load();
            return true;
        }
        return false;
    }

    /**
     * save current state of piano roll and current instrument
     * if it was playing(playmode), stop playback
     */
    public void store(){
        File blockFile = new File("blocks.txt");
        File instrument = new File("instrument.txt");
        PrintWriter f = PApplet.createWriter(blockFile);
        PrintWriter i = PApplet.createWriter(instrument);
        Block[][] b = grid.getBlocks();
        for(int x = 0; x<32; x++){
            for(int j=0; j<13; j++){
                if(b[x][j] != null && b[x][j].isActive()){
                    f.println(x+" "+j);
                }
            }
        }
        i.println(music.getIndex());
        f.close();
        i.close();
    }

    /**
     * load a previously saved track if it was playing(playmode), stop playback
     */
    public void load(){
        File f = new File("blocks.txt");
        File i = new File("instrument.txt");
        if(f.exists()){
            grid.buttonchange(100);
            try{
                BufferedReader blocks = PApplet.createReader(f);
                String str;
                while((str = blocks.readLine()) != null){
                    String[] xy = str.split(" ");
                    grid.blockchange(Integer.parseInt(xy[0])*15+60, Integer.parseInt(xy[1])*20+75);
                }
                blocks.close();

                BufferedReader instrument = PApplet.createReader(i);
                String num;
                while((num = instrument.readLine()) != null){
                    music.changeIndex(Integer.parseInt(num));
                }
                instrument.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}