public class SumOfLeftLeaves {

    private int rec(TreeNode node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return node.val;

        return rec(node.left) + sumOfLeftLeaves(node.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        return rec(root.left) + sumOfLeftLeaves(root.right);
    }

//    beats 100% memory 81%
}
