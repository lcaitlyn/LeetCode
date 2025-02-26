import javax.swing.tree.TreeNode;

public class DiameterOfBinaryTree {
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int res = height(root.left) + height(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        if (left > res) return left;
        if (right > res) return right;
        
        return res;
    }

    // Результат: runtime 8.17% memory 5.41%
    // это пиздец)
    // надо будет подумать где я проебал и почему
    // использовался DFS. Нужно изучить что такое
}
