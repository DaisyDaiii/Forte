package piano;

public class Block {
    /**
     * status of block, actived/de-actived
     */
    private boolean active;
    
    /**
     * Constructor for the Block class
     */
    public Block(){
        this.active = false;
    }

    /**
     * return the status of block
     * 
     * @return   the status of block
     */
    public boolean isActive(){
        return active;
    }

    /**
     * change the status of block while click on the block
     */
    public void click(){
        active = !active;
    }
}