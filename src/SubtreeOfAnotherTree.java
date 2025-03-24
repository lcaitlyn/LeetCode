import javax.swing.tree.TreeNode;

public class SubtreeOfAnotherTree {
    // private TreeNode find(TreeNode root, TreeNode subRoot) {
    //     if (root == null || subRoot == null) return null;
    //     if (root.val == subRoot.val) {
    //         return root;
    //     } 
    //     TreeNode left = find(root.left, subRoot);
    //     if (left != null) return left;
    //     return find(root.right, subRoot);
    // }

    // private boolean isEquals(TreeNode root, TreeNode subRoot) {
    //     if (root == null && subRoot == null) return true;
    //     if (root == null || subRoot == null) return false;
    //     if (root.val != subRoot.val) return false;
    //     if (isEquals(root.left, subRoot.left) == false) return false;
    //     return isEquals(root.right, subRoot.right);
    // }

    // public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    //     root = find(root, subRoot);
    //     if (root == null) return false;
    //     if (isEquals(root, subRoot) == true) return true;
    //     if (isSubtree(root.left, subRoot) == true) return true;
    //     return isSubtree(root.right, subRoot);
    // }

    // пытался уже немного решить, но чет не получилось
    // попробую заново

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true; 
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        if (!isSame(root.left, subRoot.left)) return false;
        return isSame(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            if (isSame(root, subRoot) == true) return true;
        }
        if (isSubtree(root.left, subRoot) == true) return true;
        return isSubtree(root.right, subRoot);
    }

    // результат: 97,42 runtime. Memory 41%
}
