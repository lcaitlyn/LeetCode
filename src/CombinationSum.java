import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static void action(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int target) {
        if (index == candidates.length) return;

        cur.add(candidates[index]);
        target -= candidates[index];

        if (target == 0) res.add(new ArrayList<>(cur));

        if (target <= 0) return;

        action(res, cur, candidates, index, target);
        cur.removeLast();

        for (int i = index + 1; i < candidates.length; i++) {
            action(res, cur, candidates, i, target);
            cur.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            action(res, new ArrayList<>(), candidates, i, target);
        }
        return res;
    }

//     beats 85% runtime 2ms, memory 5%
//    крч немного не красивый код (чат гпт подсказал сделать как лучше, но все же )

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum(new int[]{3, 5, 8}, 11));
    }
}
