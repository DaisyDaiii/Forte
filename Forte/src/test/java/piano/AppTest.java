package piano;

import org.junit.Test;
import processing.core.PApplet;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void constructure() {
        assertNotNull(new App()); 
    }

    @Test
    public void drawTest(){
        App a = new App();
        PApplet.runSketch(new String[]{"piano.App"}, a);
    }
}