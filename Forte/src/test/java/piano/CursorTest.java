
package piano;

import org.junit.Test;
import static org.junit.Assert.*;

public class CursorTest {

    @Test
    public void constructure() {
        assertNotNull(new Cursor());
    }

    @Test
    public void cursorTest(){
        Cursor c = new Cursor();
        assertEquals(c.get_pointer(), 49); 
        assertEquals(c.get_redline(), 60); // test default cursor
        c.move();
        assertNotEquals(c.get_pointer(), 49);
        assertNotEquals(c.get_redline(), 60); // test cursor move 
        c.buttonchange(70);
        assertEquals(c.get_pointer(), 49);
        assertEquals(c.get_redline(), 60); // test cursor back to its original place
        for(int i=0; i <= 540-49; i++){
            c.move();
        }
        assertEquals(c.get_pointer(), 49);
        assertEquals(c.get_redline(), 60); // test when cursor move to the end of piano roll
    }


}