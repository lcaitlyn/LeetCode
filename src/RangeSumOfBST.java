import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

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

//    public int rangeSumBST(TreeNode root, int low, int high) {
//        Queue<TreeNode> q = new LinkedList<>();
//        int sum = 0;
//
//        q.add(root);
//        while (!q.isEmpty()) {
//            TreeNode node = q.poll();
//
//            if (node.val >= low && node.val <= high) sum += node.val;
//
//            if (node.left != null) q.add(node.left);
//            if (node.right != null) q.add(node.right);
//        }
//
//        return sum;
//    }

//    beats 9% memory 5% runtime 9ms

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) return 0;
        int sum = (node.val >= low && node.val <= high) ? node.val : 0;
        return sum + dfs(node.left, low, high) + dfs(node.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

//    beats 45.43% memory 23.68% runtime 1ms

    public static void main(String[] args) {

    }
}
