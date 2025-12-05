import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

//  1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
//  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque();
        Deque<Integer> max = new ArrayDeque();
        int l = 0, r = 0;
        int res = 0;

        while (r < nums.length) {
            while (!max.isEmpty() && nums[max.getLast()] < nums[r]) {
                max.removeLast();
            }

            while (!min.isEmpty() && nums[min.getLast()] > nums[r]) {
                min.removeLast();
            }

            max.add(r);
            min.add(r);

            while (nums[max.getFirst()] - nums[min.getFirst()] > limit) {
                if (l == max.getFirst()) {
                    max.removeFirst();
                } else if (l == min.getFirst()) {
                    min.removeFirst();
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

//    beats 93.44% memory 5.20% runtime 31ms
//    кайф с первого раза сделал (ну чуть ошибок синтаксических было)


    public static void main(String[] args) {
        System.out.println("2 -> " + longestSubarray(new int[]{8, 2, 4, 7}, 4));
    }
}
