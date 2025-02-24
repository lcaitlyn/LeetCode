package AVL_learning;

public class AVLTreeImpl implements AVLTree {
    private Node root;

    class Node {
        private final int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value) node.left = insertRec(node.left, value);
        else if (value > node.value) node.right = insertRec(node.right, value);

        return node;
    }

    private int height(Node node) {
        if (node == null) return 0;

        return 1 + Integer.max(height(node.left), height(node.right));
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;

        if (Math.abs(height(node.left) - height(node.right)) > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private Node balance(Node node) {
        if (node == null) return null;

        // Если наша Node является одним из 4ых кейсов поворота
        if (isTurnCase(node)) {
            Node tmp = null;
            if (isLL(node)) {
                tmp = node.left;
                node.left.right = node;
                node.left = null;
            } else if (isRR(node)) {
                tmp = node.right;
                node.right.left = node;
                node.right = null;
            } else if (isLR(node)) {
                tmp = node.right.left;
                node.right.left.left = node;
                node.right.left.right = node.right;
                node.right.left = null;
                node.right.right = null;
                node.left = null;
                node.right = null;
            } else if (isRL(node)) {
                tmp = node.left.right;
                node.left.right.right = node;
                node.left.right.left = node.left;
                node.left.right = null;
                node.left.left = null;
                node.left = null;
                node.right = null;
            }
            return tmp;
        }

        if (height(node.left) > height(node.right)) {
            node.left = balance(node.left);
        } else {
            node.right = balance(node.right);
        }

        return node;
    }

    private boolean isTurnCase(Node node) {
        return (isLL(node) || isLR(node) || isRL(node) || isRR(node));
    }

    // Левый поворот (Right-Right case, RR), когда все уходит вправо
    private boolean isRR(Node node) {
        if (node == null) return false;
        if (node.right == null || node.left != null) return false;
        if (node.right.right == null || node.right.left != null) return false;
        return true;
    }

    // Правый поворот (Left-Left case, LL), когда все уходит влево
    private boolean isLL(Node node) {
        if (node == null) return false;
        if (node.left == null || node.right != null) return false;
        if (node.left.left == null || node.left.right != null) return false;
        return true;
    }

    // Право-левый поворот (Right-Left, RL)
    // Когда новый узел добавляется в правое поддерево левого узла
    private boolean isRL(Node node) {
        if (node == null) return false;
        if (node.left == null || node.right != null) return false;
        if (node.left.right == null || node.left.left != null) return false;
        return true;
    }

    // Лево-правый поворот (Left-Right, LR)
    // Когда новый узел добавляется в левое поддерево правого узла
    private boolean isLR(Node node) {
        if (node == null) return false;
        if (node.right == null || node.left != null) return false;
        if (node.right.left == null || node.right.right != null) return false;
        return true;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        
        if (!isBalanced(root)) {
            root = balance(root);
        }
    }

}
