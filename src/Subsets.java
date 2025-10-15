import java.util.ArrayList;
import java.util.List;

public class Subsets {


//    private static void action(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
//        if (cur != null) res.add(cur);
//
//        if (index == nums.length) return;
//
//        cur = (cur != null) ? new ArrayList<>(cur) : new ArrayList<>();
//
//        cur.add(nums[index]);
//        index++;
//
//        action(res, cur, nums, index);
//        action(res, null, nums, index);
//    }
//
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        action(res, list, nums, 0);
//        return res;
//    }

    private static void action(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {

        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        action(res, cur, nums, index + 1);
        cur.add(nums[index]);
        action(res, cur, nums, index + 1);
        cur.removeLast();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        action(res, list, nums, 0);
        return res;
    }

    // beats 100% 0ms, memory 18%. долго думал над этой задачей че-то

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }
}
