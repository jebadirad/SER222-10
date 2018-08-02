import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static org.junit.Assert.*;

public class ArrayListTest {
    ArrayUnorderedList<Integer> AL;
    @Before
    public void setUp() {
        AL = new ArrayUnorderedList<Integer>();
        AL.addToFront(0);
        AL.addToFront(1);
        AL.addToFront(2);
        AL.addToFront(3);
        AL.addToFront(4);
        AL.addToFront(5);
        AL.addToFront(6);



        
    }

    @Test
    public void removeLast() {
        assertEquals((Integer)0, AL.removeLast());
        assertEquals((Integer)1, AL.removeLast());

    }

    @Test
    public void removeFirst() {
        assertEquals((Integer)6, AL.removeFirst());
        assertEquals((Integer)5, AL.removeFirst());
    }
    @Test (expected = EmptyCollectionException.class)
    public void removeFirstEmpty(){

        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
        AL.removeFirst();
    }
    @Test(expected = EmptyCollectionException.class)
    public void removeLastEmpty(){

        AL.removeLast();
        AL.removeLast();
        AL.removeLast();
        AL.removeLast();
        AL.removeLast();
        AL.removeLast();
        AL.removeLast();
        AL.removeLast();

    }
}