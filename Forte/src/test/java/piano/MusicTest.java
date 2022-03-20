package piano;

import org.junit.Test;

import static org.junit.Assert.*;

public class MusicTest {
    
    @Test
    public void constructure(){
        assertNotNull(new Music());
    }

    @Test
    public void musicTest(){
        Grid g = new Grid();
        Cursor c = new Cursor();
        Music p = new Music();
        assertEquals(p.music(g, c), "no sound"); 
        g.blockchange(60, 75);
        for(int i=0; i<10; i++){
            c.move();
        }
        assertEquals(p.music(g, c), "one by one"); //test whether it can make sound
        g.blockchange(75, 95);
        g.blockchange(90, 95);
        g.blockchange(105, 95);
        for(int i=0; i<6; i++){
            c.move();
        }
        assertEquals(p.music(g, c), "one by one"); // test default sound for consecutive blocks
        for(int i=0; i<14; i++){
            c.move();
        }
        assertEquals(p.music(g, c), "one by one");
        p.changeMusic(430);
        for(int i=0; i<10; i++){
            c.move();
        }
        assertEquals(p.music(g, c), "long sound"); // test sound for consecutive blocks after click change button
        p.changeMusic(440);
        assertEquals(p.music(g, c), "one by one"); // test sound for consecutive blocks after click change button
    }

    @Test
    public void instrumentTest(){
        Music p = new Music();
        assertEquals(p.getIndex(), 0); // test default instrument
        p.buttonchange(380);
        assertEquals(p.getIndex(), 1); // test click on next button
        p.buttonchange(380);
        p.buttonchange(380);
        assertEquals(p.getIndex(), 3); 
        p.buttonchange(380);
        assertEquals(p.getIndex(), 0); // test when current instrument is S, whether it will change to P after click on next button
        p.buttonchange(320);
        assertEquals(p.getIndex(), 3); // test when current instrument is P, whether it will change to S after click on prev button
        p.buttonchange(320);
        assertEquals(p.getIndex(), 2); // test click on prev buttton
        p.changeIndex(1);
        assertEquals(p.getIndex(), 1); // test change instrument
    }
}