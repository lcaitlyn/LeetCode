public class CountGoodNodesInBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int rec(TreeNode node, int max) {
        if (node == null) return 0;

        int res = 0;

        if (node.val >= max) res++;
        res += rec(node.left, Math.max(max, node.val));
        res += rec(node.right, Math.max(max, node.val));

        return res;
    }

    public int goodNodes(TreeNode root) {
        return rec(root, root.val);
    }

//    beats 94.22% memory 91.91% runtime 2ms
}
