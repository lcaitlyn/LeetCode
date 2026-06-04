import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (l < r && nums[r] - k > nums[l] + k) {
                l++;
            }

            res = Math.max(res, r - l + 1);

            r++;
        }

        return res;
    }

//    15 минут. и то минут 8 я пытался просто понять че от нас хотят
//    runtime 43ms beats 55.99% memory 44.98%

//    можно еще придумать быстрое решение за 4-10ms (мб нужно применить мапу)
//    https://leetcode.com/discuss/post/2166045/line-sweep-algorithms-by-c0d3m-8ebq/
//    вот способ как решать быстрее

    public static void main(String[] args) {
        System.out.println("3 -> " + maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }
}
