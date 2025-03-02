import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> arr = new ArrayList<>();
    //     Queue<TreeNode> q = new LinkedList<>();

    //     if (root == null) return arr;

    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         List<Integer> list = new ArrayList<>();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = q.poll();

    //             if (node != null) {
    //                 list.add(node.val);
    //                 q.add(node.left);
    //                 q.add(node.right);
    //             }
    //         }
    //         if (!list.isEmpty()) {
    //             arr.add(list);
    //         }
    //     }
    //     return arr;
    // }

    // Res: Runtime: 14.71% Memory 94.67%;
    // Скорее всего из-за цикла в цикле такой большой time complexity
    // Нужно подумать, как оптимизировать.

    // ну хуй знает. моё решение такой же как и в решения) немного рад за себя
    // но хули оно 15%. чуть медленее другого решения. мб проблема не во мне

    // понял. это литкод мозги ебет.
    // запустил абсолютно тот же код runtime 90%, memory 6%
}
