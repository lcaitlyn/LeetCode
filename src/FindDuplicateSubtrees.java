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

//    upd 02.07.2026 готовлюсь ко стаже
//    бля ахах ща снова начал решать эту здачу вот что получилось (коменты были ранее написаны этого текста):

    // бля хз как я такое решал.
// надо подумать
// мб проиндексировать их? по их руту. типо все у кого одна и та же цифра
// встречается и тех между собой сравнивать
// бля конечно размножаться проверки
// ну да ладно потом думать буду как улучшить

// бля вообще хз

// ебать посмотрел своё решение ебать там бля вообще на другом лвле

//    private boolean isSame(TreeNode a, TreeNode b) {
//        if (a == null && b == null) return true;
//        if (a == null || b == null) return false;
//
//        if (a.val != b.val) return false;
//        if (!isSame(a.left, b.left)) return false;
//        return isSame(a.right, b.right);
//    }
//
//    private void rec(Map<Integer, List<TreeNode>> map, TreeNode node) {
//        if (node == null) return;
//
//        List<TreeNode> list = map.getOrDefault(node.val, new ArrayList<>());
//        list.add(node);
//        map.put(node.val, list);
//
//        rec(map, node.left);
//        rec(map, node.right);
//    }
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> list = new ArrayList<>();
//
//        Map<Integer, List<TreeNode>> map = new HashMap<>();
//        rec(map, root);
//
//        for (List<TreeNode> l : map.values()) {
//            for (int i = 0; i < list.size(); i++) {
//                for (int j = i + 1; j < list.size(); j++) {
//                    if (isSame(l.get(i), l.get(j))) {
//                        list.add(l.get(i));
//                        list.add(l.get(j));
//                        i = j;
//                    }
//                }
//            }
//        }
//
//        return list;
//    }

//    и вот снова эта функция isSame
//    то есть я думаю так же как и тогда, а решал я эту задачу 2 октрбря 2025 а сегодня 2 июля 2026
//    хотя я думал я прокачался тут, хотя спроавдливости ради деревья я за эти полгода не особо решад

}
