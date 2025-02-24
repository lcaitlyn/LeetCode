package BTS_learning;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeImpl implements BinarySearchTree {
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

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        this.root = insertRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (root.value < value) return searchRec(root.left, value);
        return searchRec(root.right, value);
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private void printPreorderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreorderRec(node.left);
            printPreorderRec(node.right);
        }
    }

    // Прямой обход root -> left -> right
    public void printPreorder() {
        printPreorderRec(root);
        System.out.println();
    }

    private void printInorderRec(Node node) {
        if (node != null) {
            printInorderRec(node.left);
            System.out.print(node.value + " ");
            printInorderRec(node.right);
        }
    }

    // Симметричный обход left -> root -> right
    public void printInorder() {
        printInorderRec(root);
        System.out.println();
    }

    private void printPostorederRec(Node node) {
        if (node != null) {
            printPostorederRec(node.left);
            printPostorederRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Обратный обход left -> right -> root
    public void printPostorder() {
        printPostorederRec(root);
        System.out.println();
    }

    private boolean isList(Node node) {
        return (node.left == node && node.right == null);
    }

    private Node getMin(Node node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node getMax(Node node) {
        if (node == null) return null;

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) return null;

        if (value == node.value) {
            if (isList(node)) return null;

            if (node.left == null) return node.right;

            if (node.right == null) return node.left;

            Node tmp = getMin(node.right);  // ищем минимальную ноду из правого поддерева
            node.left = tmp.left;
            node.right = deleteRec(node.right, tmp.value);
        } else if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else {
            node.right = deleteRec(node.right, value);
        }
        return node;
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    public int findMin() {
        if (root == null) return -1;

        return getMin(root).value;
    }

    public int findMax() {
        if (root == null) return -1;

        return getMax(root).value;
    }

    private int countNodesRec(Node node) {
        if (node == null) return 0;

        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) return 0;

        return 1 + Integer.max(getHeightRec(node.left), getHeightRec(node.right));
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private void fillListRec(List<Integer> list, Node node) {
        if (node == null || list == null) return;

        list.add(node.value);
        fillListRec(list, node.left);
        fillListRec(list, node.right);
    }

    private Node buildBalancedTree(List<Integer> list, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (hi - lo) / 2 + lo;
        Node node = new Node(list.get(mid));
        node.left = buildBalancedTree(list, lo, mid - 1); // идем влево от середины
        node.right = buildBalancedTree(list, mid + 1, hi); // идем вправо от середины

        return node;
    }

    public void balance() {
        List<Integer> list = new ArrayList<>();
        fillListRec(list, root);
        root = buildBalancedTree(list, 0, list.size() - 1);
    }
}

