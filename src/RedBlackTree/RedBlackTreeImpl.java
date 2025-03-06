package RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTreeImpl implements RedBlackTree {
    private enum Color {
        RED, BLACK
    }

    private TreeNode root;
    private TreeNode nil = new TreeNode(0, Color.BLACK);

    private class TreeNode {
        private final int value;

        private TreeNode left, right, parent;

        private Color color;

        public TreeNode(int value, Color color) {
            this.value = value;
            this.color = color;
            this.left = nil;
            this.right = nil;
            this.parent = nil;
        }
    }

    private boolean isRed(TreeNode node) {
        return node != nil && node.color == Color.RED;
    }

    private void rightRotate(TreeNode node) {
        TreeNode a = node.left;
        TreeNode b = a.right;
        TreeNode p = node.parent;

        if (b != nil) {
            b.parent = node;
        }

        a.parent = p;
        node.parent = a;

        if (p == nil) {
            root = a;
        } else if (p.left == node) {
            p.left = a;
        } else {
            p.right = a;
        }

        a.right = node;
        node.left = b;
    }

    private void leftRotate(TreeNode node) {
        TreeNode a = node.right;
        TreeNode b = a.left;
        TreeNode p = node.parent;

        if (b != nil) {
            b.parent = node;
        }

        a.parent = p;
        node.parent = a;

        if (p == nil) {
            root = a;
        } else if (p.left == node) {
            p.left = a;
        } else {
            p.right = a;
        }
        a.left = node;
        node.right = b;
    }

    private TreeNode getGrandParent(TreeNode node) {
        if (node == nil || node.parent == nil) return null;
        return node.parent.parent;
    }

    private TreeNode getUncle(TreeNode node) {
        if (node == nil || node.parent == nil) return null;
        TreeNode grandParent = getGrandParent(node);
        return (grandParent.left == node.parent) ? grandParent.right : grandParent.left;
    }

    // Делаю по этому гайду https://www.youtube.com/watch?v=0BUX_PotA4c&t=198s
    // Там описаны 5 случаев. Ниже номера кейсов из видео
    private void recolor(TreeNode child) {
        while (isRed(child.parent)) {   // Пока родитель 🔴 идем вверх 
            TreeNode gp = getGrandParent(child);
            TreeNode uncle = getUncle(child);

            if (isRed(uncle)) { // 🔴 Дядя, значит меняем цвета
                child.parent.color = Color.BLACK;
                uncle.color = Color.BLACK;  // 2 кейс по видео
                if (gp != root) {
                    gp.color = Color.RED;   // 3 кейс, когда дед это root
                    child = gp;
                    continue;
                }
            } else {    // ⚫ дядя (значит кейсы 4 и 5)
                if (child.parent == gp.left) {   // перевес влево ↙️
                    if (child == child.parent.right) { // зигзаг (4 кейс) 〈
                        child = child.parent;
                        leftRotate(child);
                    }
                    rightRotate(gp);    // 5 кейс /
                } else {    // перевес вправо ↘️
                    if (child == child.parent.left) {   // 4 кейс 〉
                        child = child.parent;
                        rightRotate(child);
                    }
                    leftRotate(gp); // 5 кейс \
                }
                gp.color = Color.RED;
                child.parent.color = Color.BLACK;
            }
        }
        root.color = Color.BLACK;
    }

    private void insert(TreeNode node, int value) {
        if (node == null) {
            root = new TreeNode(value, Color.BLACK);
            return;
        }

        while (true) {
            if (value < node.value) {
                if (node.left == nil) {
                    node.left = new TreeNode(value, Color.RED);
                    node.left.parent = node;
                    if (isRed(node)) {
                        recolor(node.left);
                    }
                    break;
                }
                node = node.left;
            }
            if (value >= node.value) {
                if (node.right == nil) {
                    node.right = new TreeNode(value, Color.RED);
                    node.right.parent = node;
                    if (isRed(node)) {
                        recolor(node.right);
                    }
                    break;
                }
                node = node.right;
            }
        }
    }

    public void insert(int value) {
        insert(root, value);
    }

    public void printByBFS() {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != nil) {
                System.out.print(node.color.toString() + node.value + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
    }
}