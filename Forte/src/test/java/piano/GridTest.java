package piano;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {
    
    @Test
    public void constructure(){
        assertNotNull(new Grid());
    }

    @Test
    public void gridTest(){
        Grid g = new Grid();
        assertNull(g.getBlocks()[4][4]); // test default blocks on grid
        g.blockchange(120, 155);
        assertTrue(g.getBlocks()[4][4].isActive()); // test click on certain block
        g.buttonchange(100);
        assertNull(g.getBlocks()[4][4]); // test reset blocks on grid
    }
}