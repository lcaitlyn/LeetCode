import java.util.*;


public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean fromLeft = true;

        if (root == null) return res;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node != null) {
                    list.add(node.val);

                    q.add(node.left);
                    q.add(node.right);
                }
            }

            if (!list.isEmpty()) res.add(list);


            fromLeft = !fromLeft;
        }

        for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }

        return res;
    }

    // beats 63.19% 1ms

    // for (int i = 1; i < res.size(); i += 2) {
    //            Collections.reverse(res.get(i));
    //        }

//    вот это стоит улучшить
}
