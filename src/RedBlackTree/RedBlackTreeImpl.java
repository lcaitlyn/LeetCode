package RedBlackTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTreeImpl implements RedBlackTree {
    private enum Color {
        RED, BLACK
    }

    private TreeNode root;
    private final TreeNode nil = new TreeNode(0, Color.BLACK);

    private class TreeNode {
        private int value;

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

    // возвращает единственного ребенка.  ребенка нет или их 2, возвращает nil
    private TreeNode getChild(TreeNode node) {
        if (getCountOfChild(node) != 1) return nil;

        return (node.left == nil) ? node.right : node.left;
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
        while (!q.isEmpty() && root != null) {
            TreeNode node = q.poll();
            if (node != nil) {
                System.out.print(node.color.toString() + node.value + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.println();
    }

    private TreeNode findTreeNode(TreeNode root, int value) {
        if (root == nil) return nil;
        if (value == root.value) return root;
        return (value < root.value) ? findTreeNode(root.left, value) : findTreeNode(root.right, value);
    }

    public boolean search(int value) {
        if (root == null) return false;
        return (findTreeNode(root, value) != nil);
    }

    private int getCountOfChild(TreeNode node) {
        int i = 0;
        if (node.left != nil)
            i++;
        if (node.right != nil)
            i++;
        return i;
    }

    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == nil) return nil;
        while (node.left != nil) {
            node = node.left;
        }
        return node;
    }

    private void balanceAfterRemoval(TreeNode node) {
        if (node == nil) return;

        TreeNode brother;
        while (node != root && node.color == Color.BLACK) {
            if (node == node.parent.left) {
                brother = node.parent.right;
                if (isRed(brother)) {
                    brother.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    leftRotate(node.parent);
                    brother = node.parent.right;
                }
                if (!isRed(brother.left) && !isRed(brother.right)) {
                    brother.color = Color.RED;
                    node = node.parent;
                } else {
                    if (isRed(brother.right)) {
                        brother.color = node.parent.color;
                        node.parent.color = Color.BLACK;
                        brother.right.color = Color.BLACK;
                        leftRotate(node.parent);
                        node = root;
                    } else if (isRed(brother.left)) {
                        brother.color = Color.RED;
                        brother.left.color = Color.BLACK;
                        rightRotate(brother);
                        brother = node.parent.right;
                    }
                }
            } else {
                brother = node.parent.left;
                if (isRed(brother)) {
                    brother.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    rightRotate(node.parent);
                    brother = node.parent.left;
                }
                if (!isRed(brother.left) && !isRed(brother.right)) {
                    brother.color = Color.RED;
                    node = node.parent;
                } else {
                    if (isRed(brother.left)) {
                        brother.color = node.parent.color;
                        node.parent.color = Color.BLACK;
                        brother.left.color = Color.BLACK;
                        rightRotate(node.parent);
                        node = root;
                    } else if (isRed(brother.right)) {
                        brother.color = Color.RED;
                        brother.right.color = Color.BLACK;
                        leftRotate(brother);
                        brother = node.parent.left;
                    }
                }
            }
        }
        node.color = Color.BLACK;
    }

    public void remove(int value) {
        if (root == null) return;

        TreeNode node = findTreeNode(root, value);

        if (node == nil) return; // если не нашли, выходим

        if (node == root && getCountOfChild(node) == 0) { // если удаляемый root и у него нет детей
            root = null;
            return;
        }

        TreeNode child = (getCountOfChild(node) < 2) ? getChild(node) : getMinTreeNode(node.right);
        if (node.parent == nil) { // если удаляемый root с детьми
            root = child;
        } else if (node.parent.left == node) { // если у удаляемого есть ребенок, отдаем его родителю, иначе туда идет nil
            node.parent.left = child;
        } else {
            node.parent.right = child;
        }

        if (node.color == Color.BLACK) {    // балансировка
            balanceAfterRemoval(child);
        }
    }
}