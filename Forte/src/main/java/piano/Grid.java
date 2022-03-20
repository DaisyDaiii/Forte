package piano;

import processing.core.PApplet;

public class Grid implements ButtonChange{
    private Block[][] blocks;

    /**
     * Constructor for the Grid class
     */
    public Grid(){
        this.blocks = new Block[32][13];
    }
    
    /**
     * Draw the grid of piano roll on app frame
     * All blocks are inactive when the program starts
     * A block is activated/deactivated when the user clicks on it.
     * If the block is actived, it has the block sprite rendered
     * 
     * @param app   the app where to draw
     */
    public void draw(PApplet app){
        app.image(app.loadImage("src/main/resources/grid.png"), 60, 75);
        for(int i = 0; i<32; i++){
            for(int j=0; j<13; j++){
                if(blocks[i][j] != null && blocks[i][j].isActive()){
                    app.image(app.loadImage("src/main/resources/block.png"), i*15+61, j*20+76);
                }
            }
        }
    }
    
    /**
     * When the user clicks on a block, it changes actived/de-actived
     * 
     * @param x   the current horizontal coordinate of the mouse
     * @param y   the current vertical coordinate of the mouse.
     */
    public void blockchange(int x, int y){
        int tempx = (int) Math.floor((x - 60) / 15);
        int tempy = (int) Math.floor((y - 75) / 20);
        if(blocks[tempx][tempy] == null){
            blocks[tempx][tempy] = new Block();
        }
        blocks[tempx][tempy].click();
    }

    /**
     * de-activate all blocks on the piano roll
     * @param x     the current horizontal coordinate of the mouse
     * @return      return if blocks are reset
     */
    public boolean buttonchange(int x){
        if(x > 95 && x < 135){
            this.blocks = new Block[32][13];
            return true;
        }
        return false;
    }

    /**
     * return all blocks
     * @return   return all blocks of grid
     */
    public Block[][] getBlocks(){
        return blocks;
    }

}