import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
    @Test
    void InitializeAVLTree() {
        // Arrange
        AvlTree tree = new AvlTree();
        assertTrue(tree.isEmpty());

        tree.insert(2);
        assertFalse(tree.isEmpty());

        tree.makeEmpty();
        assertTrue(tree.isEmpty());
    }

    // #region Basic rotations
    @Test
    void Standard3InputsWithoutRotation() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);

        // Assert
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicLLRotation() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);

        // Assert
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicRRRotation() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);

        // Assert
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicLRRotation() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(6);
        tree.insert(2);
        tree.insert(5);

        // Assert
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }

    @Test
    void BasicRLRotation() {
        // Arrange
        AvlTree tree = new AvlTree();

        // Act
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);

        // Assert
        assertEquals("2 5 6", tree.inorder());
        assertEquals("5 2 6", tree.preorder());
        assertEquals("2 6 5", tree.postorder());
    }
    // #endregion

    // #region Advanced rotations
    @Test
    void AdvancedLLRotation() {
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
        assertEquals("2 5 6 9 13 14", tree.inorder());
        assertEquals("2 5 6 9 13 14", tree.preorder());
        assertEquals("2 5 9 14 13 6", tree.postorder());
    }

    @Test
    void AdvancedRRRotation() {
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
        assertEquals("5 6 9 13 14 17", tree.inorder());
        assertEquals("13 6 5 9 14 17", tree.preorder());
        assertEquals("5 9 6 17 14 13", tree.postorder());
    }

    @Test
    void AdvancedLRRotation() {
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
        assertEquals("2 5 6 9 14 17", tree.inorder());
        assertEquals("9 5 2 6 14 17", tree.preorder());
        assertEquals("2 6 5 17 14 9", tree.postorder());
    }

    @Test
    void AdvancedRLRotation() {
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
        assertEquals("2 5 6 9 14 17", tree.inorder());
        assertEquals("9 5 2 6 14 17", tree.preorder());
        assertEquals("2 6 5 17 14 9", tree.postorder());
    }
    // #endregion
}
