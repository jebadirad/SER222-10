import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBinaryTreeTest {
    LinkedBinaryTree<Integer> LBT;
   
    @Before
    public void setUp(){
        LBT = new LinkedBinaryTree<Integer>();
        LBT.root = new BinaryTreeNode<Integer>(0);
        LBT.root.setLeft(new BinaryTreeNode<Integer>(1));
        LBT.root.setRight(new BinaryTreeNode<Integer>(2));
        LBT.root.getLeft().setLeft(new BinaryTreeNode<Integer>(3));
        LBT.root.getLeft().setRight(new BinaryTreeNode<Integer>(4));
        LBT.root.getRight().setRight(new BinaryTreeNode<Integer>(5));
        LBT.root.getRight().getRight().setRight(new BinaryTreeNode<Integer>(6));
        LBT.getLeft().getLeft().getRootNode().setLeft(new BinaryTreeNode<Integer>(7));
        LBT.getLeft().getLeft().getRootNode().setRight(new BinaryTreeNode<Integer>(8));
        LBT.getLeft().getLeft().getLeft().getRootNode().setLeft(new BinaryTreeNode<Integer>(9));
        LBT.getRight().getRight().getRootNode().setLeft(new BinaryTreeNode<Integer>(10));
        LBT.getRight().getRight().getLeft().getRootNode().setRight(new BinaryTreeNode<Integer>(11));
        LBT.getRight().getRight().getLeft().getRight().getRootNode().setRight(new BinaryTreeNode<Integer>(12));
    }

    @Test(expected = EmptyCollectionException.class)
    public void getRootElementEmpty() {
        LinkedBinaryTree<Integer> empty = new LinkedBinaryTree<Integer>();
        empty.getRootElement();

    }
    @Test
    public void getRootElementTest(){
        assertEquals((Integer)0, LBT.getRootElement());
        assertEquals((Integer)1, LBT.getLeft().getRootElement());
        assertEquals((Integer)2, LBT.getRight().getRootElement());
    }

    @Test
    public void getRootNode() {
        LinkedBinaryTree<Integer> nodes = new LinkedBinaryTree<Integer>(0);
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(1);

        nodes.getRootNode().setLeft(node);
        assertEquals(node, nodes.getLeft().getRootNode());
    }

    @Test
    public void getLeft() {

        LinkedBinaryTree<Integer> left = LBT.getLeft();
        assertEquals((Integer)1, left.root.getElement());
        assertEquals((Integer)3, left.root.getLeft().getElement());
        assertEquals((Integer)4, left.root.getRight().getElement());

    }

    @Test
    public void getRight() {
        LinkedBinaryTree<Integer> right = LBT.getRight();
        assertEquals((Integer)2, right.getRootElement());
        assertEquals((Integer)5, right.getRight().getRootElement());
        assertEquals((Integer)6, right.getRight().getRight().getRootElement());

    }
    @Test(expected = EmptyCollectionException.class)
    public void getRightException(){
        LinkedBinaryTree<Integer> right = LBT.getRight();
        assertEquals(null, right.getLeft().getRootNode());
    }

    @Test
    public void size() {
        assertEquals((Integer)13, (Integer)LBT.size());
        LBT.getRight().getRight().getRight().getRootNode().setRight(new BinaryTreeNode<Integer>(7));
        assertEquals(14, LBT.size());
        LBT.getRootNode().setLeft(null);
        assertEquals((Integer)8, (Integer)LBT.size());


    }

    @Test
    public void getHeight() {
        LinkedBinaryTree<Integer> lbtEmpty = new LinkedBinaryTree<Integer>();
        assertEquals(0, lbtEmpty.getHeight());
        lbtEmpty.root = new BinaryTreeNode<Integer>(0);
        assertEquals(1, lbtEmpty.getHeight());
        lbtEmpty.getRootNode().setRight(new BinaryTreeNode<Integer>(1));

        assertEquals(2, lbtEmpty.getHeight());
        lbtEmpty.getRootNode().setLeft(new BinaryTreeNode<Integer>(2));
        assertEquals(2, lbtEmpty.getHeight());

        LinkedBinaryTree lbt2 = new LinkedBinaryTree<Integer>();
        lbt2.root = new BinaryTreeNode<Integer>(0);
        lbt2.root.setLeft(new BinaryTreeNode<Integer>(1));
        lbt2.root.setRight(new BinaryTreeNode<Integer>(2));
        lbt2.root.getLeft().setLeft(new BinaryTreeNode<Integer>(3));
        lbt2.root.getLeft().setRight(new BinaryTreeNode<Integer>(4));
        lbt2.root.getRight().setRight(new BinaryTreeNode<Integer>(5));
        lbt2.root.getRight().getRight().setRight(new BinaryTreeNode<Integer>(6));
        assertEquals(4, lbt2.getHeight());
        lbt2.getLeft().getLeft().getRootNode().setLeft(new BinaryTreeNode<Integer>(7));
        assertEquals(4, lbt2.getHeight());
        lbt2.getLeft().getLeft().getRootNode().setRight(new BinaryTreeNode<Integer>(8));
        assertEquals(4, lbt2.getHeight());
        lbt2.getLeft().getLeft().getLeft().getRootNode().setLeft(new BinaryTreeNode<Integer>(9));
        assertEquals(5, lbt2.getHeight());
        lbt2.getRight().getRight().getRootNode().setLeft(new BinaryTreeNode<Integer>(10));
        assertEquals(5, lbt2.getHeight());
        lbt2.getRight().getRight().getLeft().getRootNode().setRight(new BinaryTreeNode<Integer>(11));
        assertEquals(5, lbt2.getHeight());
        lbt2.getRight().getRight().getLeft().getRight().getRootNode().setRight(new BinaryTreeNode<Integer>(12));
        assertEquals(6, lbt2.getHeight());
        lbt2.getRootNode().setRight(null);
        assertEquals(5, lbt2.getHeight());


    }

    @Test
    public void contains() {
        assertTrue(LBT.contains(1));
        assertTrue(LBT.contains(12));
        assertTrue(LBT.contains(8));
        assertFalse(LBT.contains(13));
    }

    @Test
    public void toStringTest() {
        LinkedBinaryTree<Integer> LBTString = new LinkedBinaryTree<Integer>();
        LBTString.root = new BinaryTreeNode<Integer>(0);
        assertEquals("0", LBTString.toString());
        LBTString.getRootNode().setRight(new BinaryTreeNode<Integer>(1));
        LBTString.getRootNode().setLeft(new BinaryTreeNode<Integer>(2));
        assertEquals("2 0 1", LBTString.toString());

        assertEquals("9 7 3 8 1 4 0 2 10 11 12 5 6", LBT.toString());
    }
    @Test
    public void toStringPreOrderTest(){
        LinkedBinaryTree<Integer> LBTString = new LinkedBinaryTree<Integer>();
        LBTString.root = new BinaryTreeNode<Integer>(0);
        assertEquals("0", LBTString.toString());
        LBTString.getRootNode().setRight(new BinaryTreeNode<Integer>(1));
        LBTString.getRootNode().setLeft(new BinaryTreeNode<Integer>(2));
        LBTString.getLeft().getRootNode().setRight(new BinaryTreeNode<Integer>(3));
        LBTString.getLeft().getRootNode().setLeft(new BinaryTreeNode<Integer>(4));
        assertEquals("0 2 4 3 1", LBTString.toStringPreOrder());

        assertEquals("0 1 3 7 9 8 4 2 5 10 11 12 6", LBT.toStringPreOrder());
    }
   
}