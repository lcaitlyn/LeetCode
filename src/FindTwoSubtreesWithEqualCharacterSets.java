import java.util.*;

//    Дано:
//    надо найти 2 дерева у которых множество букв одинаково
//
//    Пример: в одном поддереве есть буквы {A, B}, в другом {A, A, B}.
//    Пересечение {A,B} - буквы есть в обоих поддеревьях

public class FindTwoSubtreesWithEqualCharacterSets {


    private static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


//    private static boolean found = false;
//
//    private static Set<Set<Character>> seen = new HashSet<>();
//
//    private static Set<Character> dfs(TreeNode node) {
//        if (node == null) return new HashSet<>();
//
//        Set<Character> left = dfs(node.left);
//        Set<Character> right = dfs(node.right);
//
//        Set<Character> cur = new HashSet<>();
//        cur.addAll(left);
//        cur.addAll(right);
//        cur.add(node.val);
//
//        if (seen.contains(cur)) {
//            found = true;
//        }
//
//        seen.add(cur);
//
//        return cur;
//    }
//
//    public static boolean hasEqualSubtrees(TreeNode root) {
//        dfs(root);
//        return found;
//    }

//    решение через Set

    private static boolean res = false;

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if ((left & right) > 0) res = true;

        return 1 << (node.val - 'a') | left | right;
    }

    public static boolean hasEqualSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('b');
        TreeNode e = new TreeNode('e');
        c.left = d;
        c.right = e;
        a.left = b;
        a.right = c;
        System.out.println(hasEqualSubtrees(a));
    }
}
