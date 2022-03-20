package piano;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.PApplet;
import java.io.*;

public class SaveLoadTest {
    
    @Test
    public void constructure(){
        Grid g = new Grid();
        Music p = new Music();
        assertNotNull(new Save_Load(g, p));
    }

    @Test
    public void saveTest() throws IOException {
        Grid g = new Grid();
        Music p = new Music();
        Save_Load s = new Save_Load(g, p);
        g.blockchange(75, 95);
        s.store();
        File f = new File("blocks.txt");
        File i = new File("instrument.txt");
        BufferedReader blocks = PApplet.createReader(f);
        String str;
        while((str = blocks.readLine()) != null){
            assertEquals(str, 1+" "+1); // test whether save block correctly
        }
        blocks.close();
        BufferedReader instrument = PApplet.createReader(i);
        String num;
        while((num = instrument.readLine()) != null){
            assertEquals(num, "0");  // test whether save instrument correctly
        }
    }

    @Test
    public void loadTest() throws IOException {
        Grid g = new Grid();
        Music p = new Music();
        Save_Load s = new Save_Load(g, p);
        g.blockchange(75, 95);
        assertTrue(g.getBlocks()[1][1].isActive());
        assertEquals(p.getIndex(), 0);
        s.store();
        g.blockchange(90, 95);
        g.blockchange(90, 115);
        assertTrue(g.getBlocks()[2][1].isActive());
        assertTrue(g.getBlocks()[2][2].isActive());
        p.changeIndex(2);
        assertEquals(p.getIndex(), 2);
        s.load();
        assertNull(g.getBlocks()[2][1]);
        assertNull(g.getBlocks()[2][2]);
        assertEquals(p.getIndex(), 0); // test whether load correctly
    }

    @Test
    public void fileNotExist(){
        Grid g = new Grid();
        Music p = new Music();
        Save_Load s = new Save_Load(g, p);
        g.blockchange(75, 95);
        assertTrue(g.getBlocks()[1][1].isActive());
        s.load();
        assertTrue(g.getBlocks()[1][1].isActive()); // test no file exist
    }
}