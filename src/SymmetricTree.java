public class SymmetricTree {

    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    private boolean equals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        if (!equals(left.left, right.right)) return false;

        return equals(left.right, right.left);
    }

    // beats 100% че то быстро решил эту тему

    public boolean isSymmetric(TreeNode root) {
        return equals(root.left, root.right);
    }
}
