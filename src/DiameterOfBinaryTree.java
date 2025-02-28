import javax.swing.tree.TreeNode;

public class DiameterOfBinaryTree {
    // private int height(TreeNode node) {
    //     if (node == null) return 0;
    //     return 1 + Math.max(height(node.left), height(node.right));
    // }

    // public int diameterOfBinaryTree(TreeNode root) {
    //     if (root == null) return 0;

    //     int res = height(root.left) + height(root.right);
    //     int left = diameterOfBinaryTree(root.left);
    //     int right = diameterOfBinaryTree(root.right);

    //     if (left > res) return left;
    //     if (right > res) return right;
        
    //     return res;
    // }

    // Результат: runtime 8.17% memory 5.41%
    // это пиздец)
    // надо будет подумать где я проебал и почему
    // использовался DFS. Нужно изучить что такое
    
    // Крч я тупой, я уже все это время использова DFS
    // Думаю проебался я в Высоте, каждый раз я делал height заново, хотя нужно было
    // его просто сохранять да и все. ведь мы шли из малого и поднимались вверх
    // а ты поднимался вверх и использова еще height.
    // скорее всего мой time complexity поднялся до O(n^2), вместо O(n)

    private int res = 0;

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (left + right > res) {
            res = left + right;
        }
        
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    // time comp 100% memory 38%
    // все таки доделал до O(n), но использовал глобальную переменнную
    // первое решение сделал без неё.
}
