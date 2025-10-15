import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    private static void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
//        if (!cur.isEmpty()) res.add(new ArrayList<>(cur));

        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int next = index;
        while (next < nums.length && nums[index] == nums[next]) {
            cur.add(nums[next]);
            next++;
        }

        for (int i = index; i < next; i++) {
            backtracking(res, cur, nums, next);
            cur.removeLast();
        }
        backtracking(res, cur, nums, next);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

//     beats 99% runtime 1ms memory 62%
//    чет долго я думал нах

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
