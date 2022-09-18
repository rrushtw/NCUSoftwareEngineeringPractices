import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/* Class AVLTree */
class AVLTree {
    private AVLNode root;
    private List<AVLNode> elements;

    /* Constructor */
    public AVLTree() {
        root = null;
        elements = new ArrayList<>();
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Make the tree logically empty */
    public void makeEmpty() {
        root = null;
        elements = new ArrayList<>();
    }

    /* Function to insert data */
    public void insert(int data) {
        AVLNode element = new AVLNode(data);

        if (root == null) {
            root = element;
        } else {
            root.put(element);
        }

        elements.add(element);
        rebalance();
    }

    private void rebalance() {
        if (elements.size() < 3) {
            return;
        }

        for (int i = 0; i < 1000; i++) {
            AVLNode target = elements.stream()
                    .filter(x -> x.getAbsoluteBF() > 1)// WHERE BalanceFactor > 1
                    .sorted(Comparator.comparing(new Function<AVLNode, Integer>() {
                        @Override
                        public Integer apply(AVLNode node) {
                            return node.getAbsoluteBF();
                        }
                    }))// ORDER BY BalanceFactor ASC
                    .findFirst().orElse(null);

            if (target == null) {
                break;
            }

            // rearrange
            int targetBF = target.getBalanceFactor();

            // if (Math.abs(targetBF) != 2){
            // System.out.println(targetBF);
            // }

            if (targetBF == 2) {
                int leftChildBF = target.left.getBalanceFactor();

                // if (Math.abs(leftChildBF) != 1){
                // System.out.println(leftChildBF);
                // }

                if (leftChildBF == 1) {
                    LLRoatation(target);
                    continue;
                }

                if (leftChildBF == -1) {
                    LRRotation(target);
                    continue;
                }
            }

            if (targetBF == -2) {
                int rightChildBF = target.right.getBalanceFactor();

                // if (Math.abs(rightChildBF) != 1){
                // System.out.println(rightChildBF);
                // }

                if (rightChildBF == 1) {
                    RLRotation(target);
                    continue;
                }

                if (rightChildBF == -1) {
                    RRRoatation(target);
                    continue;
                }
            }
        }
    }

    private void replaceConnection(AVLNode originalNode, AVLNode newNode) {
        AVLNode parent = elements.stream()
                .filter(x -> x.left == originalNode || x.right == originalNode)
                .findFirst().orElse(null);

        if (root == originalNode) {
            root = newNode;
            return;
        }

        if (parent.left == originalNode) {
            parent.left = newNode;
            return;
        }

        if (parent.right == originalNode) {
            parent.right = newNode;
            return;
        }
    }

    private void LLRoatation(AVLNode originalNode) {
        AVLNode newNode = originalNode.left;
        originalNode.left = null;

        if (newNode.right == null) {
            newNode.right = originalNode;
        } else {// newNode.right != null
            AVLNode temp = newNode.right;
            newNode.right = originalNode;
            newNode.put(temp);
        }

        replaceConnection(originalNode, newNode);
    }

    private void RRRoatation(AVLNode originalNode) {
        AVLNode newNode = originalNode.right;
        originalNode.right = null;

        if (newNode.left == null) {
            newNode.left = originalNode;
        } else {// newNode.left != null
            AVLNode temp = newNode.left;
            newNode.left = originalNode;
            newNode.put(temp);
        }

        replaceConnection(originalNode, newNode);
    }

    private void LRRotation(AVLNode originalNode) {
        AVLNode newNode = originalNode.left.right; // pick the left.right as new node
        originalNode.left.right = null;// reset the connection

        List<AVLNode> tempNodes = new ArrayList<>();
        if (newNode.left != null)
            tempNodes.add(newNode.left);
        if (newNode.right != null)
            tempNodes.add(newNode.right);

        newNode.left = originalNode.left;// pick the left as left child
        originalNode.left = null;// reset the connnection

        newNode.right = originalNode;// pick original node as right child

        for (AVLNode tempNode : tempNodes) {
            newNode.put(tempNode);
        }

        replaceConnection(originalNode, newNode);
    }

    private void RLRotation(AVLNode originalNode) {
        AVLNode newNode = originalNode.right.left; // pick the right.left as new node
        originalNode.right.left = null;// reset the connection

        List<AVLNode> tempNodes = new ArrayList<>();
        if (newNode.right != null)
            tempNodes.add(newNode.right);
        if (newNode.left != null)
            tempNodes.add(newNode.left);

        newNode.right = originalNode.right;// pick the right as right child
        originalNode.right = null;// reset the connnection

        newNode.left = originalNode;// pick original node as left child

        for (AVLNode tempNode : tempNodes) {
            newNode.put(tempNode);
        }

        replaceConnection(originalNode, newNode);
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(AVLNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(AVLNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(AVLNode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(AVLNode r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(AVLNode r) {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data + " ");
        }
    }
}