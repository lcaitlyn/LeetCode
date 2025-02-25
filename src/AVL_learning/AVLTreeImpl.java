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

        if (Math.abs(balanceFactor(node)) > 1) return false;

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private Node rightRotate(Node node) {
        Node a = node.left;
        Node b = a.right;

        a.right = node;
        node.left = b;

        return a;
    }

    private Node leftRotate(Node node) {
        Node a = node.right;
        Node b = a.left;

        a.left = node;
        node.right = b;

        return a;
    }

    private Node balance(Node node) {
        if (node == null) return null;

        // Если наша Node является одним из 4ых кейсов поворота
        if (isTurnCase(node)) {
            if (isLL(node)) {
                return rightRotate(node);
            } else if (isRR(node)) {
                return leftRotate(node);
            } else if (isLR(node)) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            } else if (isRL(node)) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
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

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return (height(node.left) - height(node.right));
    }

    // Левый поворот (Right-Right case, RR), когда все уходит вправо
    private boolean isRR(Node node) {
        if (node == null) return false;
        return (balanceFactor(node) < -1 && balanceFactor(node.right) <= 0);
    }

    // Правый поворот (Left-Left case, LL), когда все уходит влево
    private boolean isLL(Node node) {
        if (node == null) return false;
        return (balanceFactor(node) > 1 && balanceFactor(node.left) >= 0);
    }

    // Право-левый поворот (Right-Left, RL)
    // Когда новый узел добавляется в правое поддерево левого узла
    private boolean isRL(Node node) {
        if (node == null) return false;
        return (balanceFactor(node) < -1 && balanceFactor(node.right) > 0);
    }

    // Лево-правый поворот (Left-Right, LR)
    // Когда новый узел добавляется в левое поддерево правого узла
    private boolean isLR(Node node) {
        if (node == null) return false;
        return (balanceFactor(node) > 1 && balanceFactor(node.left) < 0);
    }

    public void insert(int value) {
        root = insertRec(root, value);
        
        if (!isBalanced(root)) {
            root = balance(root);
        }
    }

}
