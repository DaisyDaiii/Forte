package piano;

public class Music extends Piano{
    private boolean musicTime;
    /**
     * Constructor for the Music class
     */
    public Music(){
        super();
        this.musicTime = false;
    }
    /**
     * When the cursor reaches an activated block in the piano roll (while in
     * playback mode), the block’s pitch is played on the midi synthesizer
     * 
     * if there are consecutive actived blocks together,
     * if musictime is true, it produces a longer sound
     * @param grid       the grid to check when make sound
     * @param cursor     the cursor to check when make sound
     * @return           the explanation of this change
     */
    public String music(Grid grid, Cursor cursor) {
        String str = "no sound";
        Block[][] block = grid.getBlocks();
        for(int i = 0; i<32; i++){
            for(int j = 0; j<13;j++){
                if(block[i][j]!=null && block[i][j].isActive()){
                    if(musicTime == false){
                        this.voiceOn(i, j, cursor);
                        this.voiceOff(i, j, cursor);
                        str = "one by one";
                    }
                    else{
                        if(i == 0 || block[i-1][j]==null || !block[i-1][j].isActive()){
                            this.voiceOn(i, j, cursor);
                        }
                        if(i ==31 || block[i+1][j]==null || !block[i+1][j].isActive()){
                            this.voiceOff(i, j, cursor);
                        }
                        str = "long sound";
                    }
                }
            }
        }
        return str;
    }
    /**
     * block sound one by one (short sound)
     * @param x          the current horizontal coordinate of the block
     * @param y          the current vertical coordinate of the block
     * @param cursor     the cursor to check when make sound
     */
    public void voiceOn(int x, int y, Cursor cursor){
        if(cursor.get_redline() == x*15+61){
            channel.noteOn(72-y, 50);
        }
    }
    /**
     * consecutive blocks produce a longer sound
     * @param x           the current horizontal coordinate of the block
     * @param y           the current vertical coordinate of the block
     * @param cursor      the cursor to check when make sound
     */
    public void voiceOff(int x, int y, Cursor cursor){
        if(cursor.get_redline() == x*15+61+14){
            channel.noteOff(72-y, 50);
        }
    }
    /**
     * change the sound of consecutive blocks: longer sound/short sound
     * @param x       the current horizontal coordinate of the mouse
     * @return        return whether sound is changed
     */
    public boolean changeMusic(int x){
        if(x > 410 && x < 450){
            musicTime = !musicTime;
            return true;
        }
        return false;
    }
}