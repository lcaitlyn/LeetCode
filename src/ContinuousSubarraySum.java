import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class ContinuousSubarraySum {
    // public boolean checkSubarraySum(int[] nums, int k) {
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         int sum = nums[i];
    //         for (int j = i + 1; j < nums.length; j++) {
    //             sum += nums[j];

    //             if (sum % k == 0) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // TLE

//    private static boolean rec(int nums[], int start, int end, int sum, int k) {
//        if (end - start < 1) return false;
//
//        if (sum % k == 0) return true;
//
//        if (rec(nums, start, end - 1, sum - nums[end], k) == true) {
//            return true;
//        }
//        return rec(nums, start + 1, end, sum - nums[start], k);
//    }
//
//    public static boolean checkSubarraySum(int[] nums, int k) {
//        if (nums.length == 1) return false;
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        return rec(nums, 0, nums.length - 1, sum, k);
//    }

    // сук тут тоже TLE. Надо решать при помощи HashMap

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.get(sum % k) != null) {
                if (i - map.get(sum % k) > 1) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }
        return false;
    }

    public boolean solution(int [] nums, int target) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) return true;
            map.put(sum - target, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{2, 4, 3}, 6));
    }
}
