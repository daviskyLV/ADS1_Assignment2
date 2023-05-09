import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    private BinaryTreeNode<Integer> node;
    private final BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
    private final BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(10);

    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode<>(5);
    }

    @AfterEach
    void tearDown() {
        node = null;
    }

    @Test
    void setElement() {
        node.setElement(1);
        assertEquals(1, node.getElement());
    }

    @Test
    void getElement() {
        assertEquals(5, node.getElement());
    }

    @Test
    void addLeftChild() {
        node.addLeftChild(leftChild);
        assertEquals(leftChild, node.getLeftChild());
        assertNotEquals(null, node.getLeftChild());
    }

    @Test
    void addRightChild() {
        node.addRightChild(rightChild);
        assertEquals(rightChild, node.getRightChild());
        assertNotEquals(null, node.getRightChild());
    }

    @Test
    void getLeftChild() {
        assertNull(node.getRightChild());
        assertNotEquals(leftChild, node.getRightChild());
    }

    @Test
    void getRightChild() {
        assertNull(node.getRightChild());
        assertNotEquals(rightChild, node.getRightChild());
    }
}