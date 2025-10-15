import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

//    private static void backtracking(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index) {
//        cur.add(candidates[index]);
//        target -= candidates[index];
//
//        if (target == 0) res.add(new ArrayList<>(cur));
//
//        if (target <= 0) return;
//
//        int i = index + 1;
////      крч тут надо закодить чтобы все повторные именно в этом цикле считал и запускал
////      новый бэктрек со следующим не похожим
//        while ()
//        for (int i = index + 1; i < candidates.length; i++) {
//            if (candidates[i])
//            backtracking(res, cur, candidates, target, i);
//            cur.removeLast();
//        }
//    }
//
//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
//        int i = 0;
//        while (i < candidates.length) {
//            int cur = candidates[i];
//            backtracking(res, new ArrayList<>(), candidates, target, i);
//            while (i < candidates.length && cur == candidates[i]) {
//                i++;
//            }
//        }
//        return res;
//    }

    private static void backtracking(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index) {
        System.out.println(cur);
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || index == candidates.length) return;

        int next = index;
        while (next < candidates.length && candidates[next] == candidates[index]) {
            cur.add(candidates[next]);
            target -= candidates[next];
            next++;
        }

        int i = next - 1;
        while (i >= index) {
            if (target >= 0) backtracking(res, cur, candidates, target, next);
            target += candidates[i];
            cur.removeLast();
            i--;
        }
        if (next < candidates.length && target - candidates[next] >= 0) backtracking(res, cur, candidates, target, next);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    // beats 14% 6ms. memory 87% было. изменил с
//     while (i >= index) {
//        backtracking(res, cur, candidates, target, next);
//        target += candidates[i];
//        cur.removeLast();
//        i--;
//    }
//    backtracking(res, cur, candidates, target, next);

//    на вот это (добавил два if)

//     while (i >= index) {
//        if (target >= 0) backtracking(res, cur, candidates, target, next);
//        target += candidates[i];
//        cur.removeLast();
//        i--;
//    }
//    if (next < candidates.length && target - candidates[next] >= 0) backtracking(res, cur, candidates, target, next);


//    beats 70% 3ms
//    можно было еще проверку сделать на if (candidates[index] > target) return;

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
//        System.out.println(combinationSum2(new int[]{2, 1, 1, 2, 1, 3, 3}, 3));
    }
}
