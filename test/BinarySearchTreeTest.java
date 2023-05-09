import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @AfterEach
    void tearDown() {
        bst = null;
    }

    @Test
    void insertOne() {
        assertTrue(bst.insert(123));
        assertTrue(bst.contains(123));
    }

    @Test
    void insertDuplicate() {
        assertTrue(bst.insert(123));
        assertTrue(bst.contains(123));
        assertFalse(bst.insert(123));
    }

    @Test
    void removeElementEmpty() {
        assertFalse(bst.removeElement(123));
    }

    @Test
    void removeElementMatches() {
        bst.insert(123);
        assertTrue(bst.removeElement(123));
        assertFalse(bst.contains(123));
    }

    @Test
    void findMin() {
        bst.insert(123);
        bst.insert(12);
        bst.insert(14);
        assertEquals(12, bst.findMin());
        assertNotEquals(14, bst.findMin());
    }

    @Test
    void findMinEmpty() {
        assertNull(bst.findMin());
    }

    @Test
    void findMax() {
        bst.insert(123);
        bst.insert(12);
        bst.insert(14);
        assertEquals(123, bst.findMax());
        assertNotEquals(14, bst.findMax());
    }

    @Test
    void findMaxEmpty() {
        assertNull(bst.findMax());
    }

    @Test
    void rebalance() {
    }
}