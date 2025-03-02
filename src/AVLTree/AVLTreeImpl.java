package AVLTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTreeImpl implements AVLTree {
    private Node root;

    class Node {
        private final int value;
        private int height;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private void updateHeight(Node node) {
        if (node == null) return;

        node.height = 1 + Integer.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private Node rightRotate(Node node) {
        Node a = node.left;
        Node b = a.right;

        a.right = node;
        node.left = b;

        updateHeight(node);
        updateHeight(a);
        return a;
    }

    private Node leftRotate(Node node) {
        Node a = node.right;
        Node b = a.left;

        a.left = node;
        node.right = b;

        updateHeight(node);
        updateHeight(a);
        return a;
    }

    private Node balance(Node node) {
        if (node == null) return null;
        
        updateHeight(node);

        // Если наша Node является одним из 4ых кейсов поворота
        // Левый.Hgth - Правый.Hgth == - 2, значит перевес вправо
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.right) > 0) { // LR case
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        } else if (balanceFactor(node) > 1) { // перевес влево
            if (balanceFactor(node.left) < 0) { // RL case
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        return node;
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return (getHeight(node.left) - getHeight(node.right));
    }

    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value) node.left = insertRec(node.left, value);
        else if (value > node.value) node.right = insertRec(node.right, value);

        return balance(node);
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node getMin(Node node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) return null;

        if (node.value == value) {
            if (node.left == null && node.right == null) return null;

            if (node.left == null) return balance(node.right);
            if (node.right == null) return balance(node.left);

            Node tmp = getMin(node.right);  // ищем минимальную ноду из правого поддерева
            tmp.left = node.left;
            tmp.right = deleteRec(node.right, tmp.value);
            return balance(tmp);
        } else if (node.value > value) {
            node.left = deleteRec(node.left, value);
        } else if (node.value < value) {
            node.right = deleteRec(node.right, value);
        }
        
        return balance(node);
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) return false;
        if (value < node.value) return searchRec(node.left, value);
        if (value > node.value) return searchRec(node.right, value);
        return true;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    public void printTreeWithBFS() {
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node != null) {
                System.out.print(node.value + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println();
    }

    private List<List<Integer>> levelOrder(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();

        List<List<Integer>> arr = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                if (node != null) {
                    list.add(node.value);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                arr.add(list);
            }
        }
        return arr;
    }

    public List<List<Integer>> getByLevelOrder() {
        return levelOrder(root);
    }
}
