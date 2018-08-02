import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBinarySearchTreeTest {
    LinkedBinarySearchTree<Integer> LBT;

    @Before
    public void setUp(){
        LBT = new LinkedBinarySearchTree<Integer>();
        LBT.addElement(5);
        LBT.addElement(1);
        LBT.addElement(2);
        LBT.addElement(7);
        LBT.addElement(9);
        LBT.addElement(0);
        LBT.addElement(-4);
        LBT.addElement(21);
        LBT.addElement(13);
        LBT.addElement(3);
        LBT.addElement(10);
        LBT.addElement(8);
    }
    @Test
    public void contains() {
        assertTrue(LBT.contains(0));
        assertTrue(LBT.contains(1));
        assertTrue(LBT.contains(2));
        assertTrue(LBT.contains(3));
        assertTrue(LBT.contains(-4));
        assertTrue(LBT.contains(5));
        assertTrue(LBT.contains(7));
        assertTrue(LBT.contains(8));
        assertTrue(LBT.contains(9));
        assertTrue( LBT.contains(10));
        assertTrue( LBT.contains(21));
        assertTrue(LBT.contains(13));
        assertFalse(LBT.contains(99));
        assertFalse(LBT.contains(4));
    }

    @Test
    public void find() {
        assertEquals((Integer)0, LBT.find(0));
        assertEquals((Integer)1, LBT.find(1));
        assertEquals((Integer)2, LBT.find(2));
        assertEquals((Integer)3, LBT.find(3));
        assertEquals((Integer)(-4), LBT.find(-4));
        assertEquals((Integer)5, LBT.find(5));
        assertEquals((Integer)7, LBT.find(7));
        assertEquals((Integer)8, LBT.find(8));
        assertEquals((Integer)9, LBT.find(9));
        assertEquals((Integer)10, LBT.find(10));
        assertEquals((Integer)21, LBT.find(21));
        assertEquals((Integer)13, LBT.find(13));



    }
    @Test(expected = ElementNotFoundException.class)
    public void cantFind(){
        LBT.find(99);
    }
}