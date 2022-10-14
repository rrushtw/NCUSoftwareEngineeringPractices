import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
    @Test
    void ALVtree_Initialize_ByCoverage() {
        // Arrange
        AvlTree tree;

        // Act
        tree = new AvlTree();

        // Assert
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.countNodes());
    }

    // #region AvlTree.insert()
    @Test
    void Insert_Normal_ByCoverage() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);

        // Assert
        assertFalse(tree.isEmpty());
        assertEquals("2", tree.inorder());
    }

    @Test
    void Insert_NegativeNumber_ByBoundary() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(-1);

        // Assert
        assertFalse(tree.isEmpty());
        assertEquals("-1", tree.inorder());
    }

    @Test
    void Insert_TheSameData_ByNegative() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);
        tree.insert(2);

        // Assert
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.countNodes());
        assertEquals("2", tree.inorder());
    }
    // #endregion

    // #region AvlTree.makeEmpty()
    @Test
    void MakeEmpty_Normal_ByCoverage() {
        // Arrange
        AvlTree tree = new AvlTree();
        tree.insert(2);

        // Act
        tree.makeEmpty();

        // Assert
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.countNodes());
    }

    @Test
    void MakeEmpty_WithoutInsert_ByNegative() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.makeEmpty();

        // Assert
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.countNodes());
    }
    // #endregion

    // #region AvlTree.search()
    @Test
    void Search_Normal_ByCoverage() {
        // Arrange
        AvlTree tree = new AvlTree();
        tree.insert(2);

        // Act
        boolean actual = tree.search(2);

        // Assert
        assertTrue(actual);
    }

    @Test
    void Search_WithEmptyTree_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        boolean actual = tree.search(2);

        // Assert
        assertFalse(actual);
    }

    @Test
    void Search_NoSuchNode_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();
        tree.insert(2);

        // Act
        boolean actual = tree.search(0);

        // Assert
        assertFalse(actual);
    }
    // #endregion

    // #region Basic rotations
    @Test
    void Standard3InputsWithoutRotation_ByCoverage() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        // Assert
        assertEquals(3, tree.countNodes());
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicLLRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);

        // Assert
        assertEquals(3, tree.countNodes());
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicRRRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);

        // Assert
        assertEquals(3, tree.countNodes());
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicLRRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(6);
        tree.insert(2);
        tree.insert(5);

        // Assert
        assertEquals(3, tree.countNodes());
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicRLRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);

        // Assert
        assertEquals(3, tree.countNodes());
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }
    // #endregion

    // #region Advanced rotations
    @Test
    void AdvancedLLRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(13);
        tree.insert(6);
        tree.insert(14);

        tree.insert(5);
        tree.insert(9);

        tree.insert(2);

        // Assert
        assertEquals(6, tree.countNodes());
        assertEquals("2 5 6 9 13 14", tree.inorder());
        assertEquals("6 5 2 13 9 14", tree.preorder());
        assertEquals("2 5 9 14 13 6", tree.postorder());
    }

    @Test
    void AdvancedRRRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(6);
        tree.insert(13);
        tree.insert(5);

        tree.insert(14);
        tree.insert(9);

        tree.insert(17);

        // Assert
        assertEquals(6, tree.countNodes());
        assertEquals("5 6 9 13 14 17", tree.inorder());
        assertEquals("13 6 5 9 14 17", tree.preorder());
        assertEquals("5 9 6 17 14 13", tree.postorder());
    }

    @Test
    void AdvancedLRRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(14);
        tree.insert(5);
        tree.insert(17);

        tree.insert(2);
        tree.insert(9);

        tree.insert(6);

        // Assert
        assertEquals(6, tree.countNodes());
        assertEquals("2 5 6 9 14 17", tree.inorder());
        assertEquals("9 5 2 6 14 17", tree.preorder());
        assertEquals("2 6 5 17 14 9", tree.postorder());
    }

    @Test
    void AdvancedRLRotation_ByPartition() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(5);
        tree.insert(2);
        tree.insert(14);

        tree.insert(9);
        tree.insert(17);

        tree.insert(6);

        // Assert
        assertEquals(6, tree.countNodes());
        assertEquals("2 5 6 9 14 17", tree.inorder());
        assertEquals("9 5 2 6 14 17", tree.preorder());
        assertEquals("2 6 5 17 14 9", tree.postorder());
    }
    // #endregion

    // #region Performance
    @Test
    void Rotation_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        long timeStamp = System.currentTimeMillis();

        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }

    @Test
    void CountNodes_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        // Act
        long timeStamp = System.currentTimeMillis();

        tree.countNodes();

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }

    @Test
    void Search_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        // Act
        long timeStamp = System.currentTimeMillis();

        tree.search((int)(Math.random() * 9999 + 1));

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }

    @Test
    void InOrder_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        // Act
        long timeStamp = System.currentTimeMillis();

        tree.inorder();

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }

    @Test
    void PreOrder_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        // Act
        long timeStamp = System.currentTimeMillis();

        tree.preorder();

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }

    @Test
    void PostOrder_ByPerformance() {
        // Arrange
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 9999; i++) {
            tree.insert(i);
        }

        // Act
        long timeStamp = System.currentTimeMillis();

        tree.postorder();

        long endStamep = System.currentTimeMillis();

        // Assert
        long actual = endStamep - timeStamp;
        assertTrue(actual < 100);
    }
    // #endregion
}
