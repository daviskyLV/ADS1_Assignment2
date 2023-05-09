import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Integer> tree;
    private BinaryTreeNode<Integer> node;
    private BinaryTreeNode<Integer> node2;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        node = new BinaryTreeNode<>(16);
        node2 = new BinaryTreeNode<>(25);
    }

    @AfterEach
    void tearDown() {
        tree = null;
        node = null;
        node2 = null;
    }

    @Test
    void getRoot() {
        assertNull(tree.getRoot());
        assertNotEquals(new BinaryTreeNode<>(1), tree.getRoot());
    }

    @Test
    void setRoot() {
        var a = new BinaryTreeNode<>(1);
        tree.setRoot(a);
        assertNotEquals(null, tree.getRoot());
        assertEquals(a, tree.getRoot());
    }

    @Test
    void isEmptyTrue() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        tree.setRoot(node);
        assertFalse(tree.isEmpty());
    }

    @Test
    void sizeZero() {
        assertEquals(0, tree.size());
        tree.setRoot(node);
        assertEquals(1, tree.size());
    }

    @Test
    void sizeOne() {
        tree.setRoot(node);
        assertEquals(1, tree.size());
    }

    @Test
    void containsFalse() {
        assertFalse(tree.contains(1));
    }

    @Test
    void containsTrue() {
        tree.setRoot(node);
        assertFalse(tree.contains(16));
    }

    @Test
    void inOrder() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void postOrder() {
    }

    @Test
    void levelOrderEmpty() {
        assertEquals(0, tree.levelOrder().size());
    }

    @Test
    void levelOrderFilled() {
        tree.setRoot(node);
        node.addRightChild(node2);
        var ordering = tree.levelOrder();
        assertEquals(2, ordering.size());
        assertEquals(16, ordering.get(0));
        assertEquals(25, ordering.get(1));
    }

    @Test
    void heightEmpty() {
        assertEquals(-1, tree.height());
    }

    @Test
    void heightSingle() {
        tree.setRoot(node);
        assertEquals(0, tree.height());
    }

    @Test
    void heightDouble() {
        tree.setRoot(node);
        node.addRightChild(node2);
        assertEquals(1, tree.height());
    }
}