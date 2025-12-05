import java.util.*;

public class _4Sum {

//    private static void rec(int[] nums, int i, int total, int target, List<Integer> list, Set<List<Integer>> set) {
//        if (list.size() == 4) {
//            if (total == target) set.add(new ArrayList(list));
//            return;
//        }
//        if (i == nums.length) return;
//        list.add(nums[i]);
//        rec(nums, i + 1, total + nums[i], target, list, set);
//        list.removeLast();
//        rec(nums, i + 1, total, target, list, set);
//    }
//
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        Set<List<Integer>> set = new HashSet();
//        rec(nums, 0, 0, target, new ArrayList(), set);
//        return new ArrayList(set);
//    }

//    TLE

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum4 = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum4 == target) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                    }
                    if (sum4 < target) {
                        l++;
                    } else {
                        r--;
                    }
                    while (l < r && r < n - 1 && nums[r] == nums[r + 1]) r--;
                    while (l < r && l > j + 1 && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return res;
    }

//    beats 11.68% memory 16.67% runtime 29ms
//

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{-294967296}, -294967296));
    }
}
