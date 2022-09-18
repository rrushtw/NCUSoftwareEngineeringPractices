/* Class AVLNode */
class AVLNode {
    AVLNode left, right;
    int data;

    /* Constructor */
    public AVLNode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public AVLNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    public void put(AVLNode element) {
        // right
        if (element.data > data) {
            if (right == null) {
                right = element;
            } else {
                right.put(element);
            }

            return;
        }

        // left
        if (element.data < data) {
            if (left == null) {
                left = element;
            } else {
                left.put(element);
            }

            return;
        }
    }

    public int getBalanceFactor() {
        int leftHeight = left == null ? 0 : left.getHeight();
        int rightHeight = right == null ? 0 : right.getHeight();
        return leftHeight - rightHeight;
    }

    public int getAbsoluteBF() {
        return Math.abs(getBalanceFactor());
    }

    public int getHeight() {
        int leftHeight = left == null ? 0 : left.getHeight();
        int rightHeight = right == null ? 0 : right.getHeight();

        return Math.max(leftHeight, rightHeight) + 1;
    }
}