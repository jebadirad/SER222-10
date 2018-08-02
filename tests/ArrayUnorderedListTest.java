import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUnorderedListTest {
    ArrayUnorderedList<Integer> AL;
    @Before
    public void setUp() {
        AL = new ArrayUnorderedList<Integer>(10);
    }

    @Test
    public void addToFront() {
        AL.addToFront(0);
        assertEquals((Integer)0, AL.first());
        AL.addToFront(1);
        assertEquals((Integer)1, AL.first());
        AL.addToFront(2);
        assertEquals((Integer)2, AL.first());
        AL.addToFront(3);
        assertEquals((Integer)3, AL.first());
        AL.addToFront(4);
        assertEquals((Integer)4, AL.first());
        AL.addToFront(5);
        assertEquals((Integer)5, AL.first());
        AL.addToFront(6);
        assertEquals((Integer)6, AL.first());
        AL.addToFront(7);
        AL.addToFront(8);

        AL.addToFront(9);
        AL.addToFront(10);
        AL.addToFront(11);
        assertEquals((Integer)11, AL.first());

    }


    @Test
    public void addToRear() {
        AL.addToRear(0);
        assertEquals((Integer)0, AL.last());
        AL.addToRear(1);
        assertEquals((Integer)1, AL.last());
        AL.addToRear(2);
        assertEquals((Integer)2, AL.last());
        AL.addToRear(3);
        assertEquals((Integer)3, AL.last());
        AL.addToRear(4);
        assertEquals((Integer)4, AL.last());
        AL.addToRear(5);
        assertEquals((Integer)5, AL.last());
        AL.addToRear(6);
        assertEquals((Integer)6, AL.last());
        AL.addToRear(7);
        AL.addToRear(8);

        AL.addToRear(9);
        assertEquals((Integer)9, AL.last());
        AL.addToRear(10);
        assertEquals((Integer)10, AL.last());
        AL.addToRear(11);
        assertEquals((Integer)11, AL.last());
    }
}