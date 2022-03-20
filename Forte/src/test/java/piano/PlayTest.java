package piano;

import org.junit.Test;

// import processing.core.PApplet;

import static org.junit.Assert.*;

// import java.io.IOException;

public class PlayTest {

    @Test
    public void constructure() {
        assertNotNull(new Play());
    }
    
    @Test
    public void playTest() {
        Play p = new Play();
        assertFalse(p.getPlaystart()); // test default play mode
        p.buttonchange(20);
        assertTrue(p.getPlaystart()); // test pause mode
        p.buttonchange(70);
        assertFalse(p.getPlaystart());// test play mode
        
    }
    
}