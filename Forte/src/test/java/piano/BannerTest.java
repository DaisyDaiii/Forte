package piano;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class BannerTest {

    @Test
    public void constructure() {
        assertNotNull(new Banner());
    }

    @Test
    public void bannerTest() throws IOException {
        Banner b = new Banner();
        Cursor c = new Cursor();
        Grid g = new Grid();
        Music p = new Music();
        Save_Load save_load = new Save_Load(g, p);
        b.move(20, c, g, p, save_load);
        assertTrue(b.play.buttonchange(20)); // test play button
        b.move(70, c, g, p, save_load);
        assertTrue(b.play.buttonchange(70)); 
        assertTrue(c.buttonchange(70)); // test stop button
        b.move(100, c, g, p, save_load);
        assertTrue(g.buttonchange(100)); // test reset button
        b.move(160, c, g, p,save_load);
        assertTrue(save_load.buttonchange(160)); // test save button
        b.move(200, c, g, p, save_load);
        assertTrue(save_load.buttonchange(200)); // test load button
        b.move(300, c, g, p, save_load);
        assertTrue(p.buttonchange(300)); // test change instrument(prev)
        b.move(400, c, g, p, save_load);
        assertTrue(p.buttonchange(400)); // test change instrument(next)
        b.move(430, c, g, p, save_load);
        assertTrue(p.changeMusic(430)); // test change the sound of consecutive blocks
    }
}