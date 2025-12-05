public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0, replaced = 0;

        while (r < nums.length) {
            if (nums[r] == 0) replaced++;

            while (replaced > k) {
                if (nums[l] == 0) replaced--;
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

//    beats 97.11% memory 89.31% runtime 3ms

    public static void main(String[] args) {
//        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    }
}
