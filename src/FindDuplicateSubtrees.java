public class FindDuplicateSubtrees {

//    private boolean isSame(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//
//        if (p == null || q == null) return false;
//
//        if (p.val != q.val) return false;
//
//        if (!isSame(p.left, q.left)) return false;
//
//        return isSame(p.right, q.right);
//    }
//
//    private void solution(TreeNode p, TreeNode q, List<TreeNode> list) {
//        if (p == null && q == null) return;
//
//        if (p == null || q == null) return;
//
//        if (p.val == q.val && isSame(p, q))
//            list.add(p);
//
//        solution(p.left, q, list);
//        solution(p, q.right, list);
//    }
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> res = new ArrayList<>();
//
//        if (root != null)
//            solution(root.left, root.right, res);
//
//        return res;
//    }
//
//    начал сперва так решать, но оказалось что это не работает. В принципе вообщен не работает
//    я хотел узнать баг, а оказывается эта вся параша медленная из-за isSameTree() и скорость получается
//    O(n^2)-O(n^3), оказывается можно было сделать за O(n)

    private String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) return "#";

        String s = String.valueOf(node.val);
        s += "," + serialize(node.left, map, res);
        s += "," + serialize(node.right, map, res);

        map.put(s, map.getOrDefault(s, 0) + 1);

        if (map.get(s) == 2) {
            res.add(node);
        }

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        if (root == null) return res;

        // System.out.println( serialize(root, map, res));
        serialize(root, map, res);

        return res;
    }

    // вот такое чудо вышло
//    [2,1,11,11,null,1]
//    допустим такой пример
//            2
//           / \
//          1   11
//         /   /
//        11   1
//    в мапе будет ["1,#,#", "11,#,#", "1,11,#,#,#", "11,1,#,#,#", "2,1,11,#,#,#,11,1,#,#,#"]
//    крч он вот эти он будет сравнивать если будет совпадения по мапе (т.е когда их будет 2), то запишет в
//    результат

}
