public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, replaced = 0;
        int ans = 0;

        while (r < nums.length) {
            if (nums[r] == 1) {
                r++;
            } else {
                if (replaced < k) {
                    replaced++;
                    r++;
                } else {
                    if (nums[l] == 0) replaced--;
                    l++;
                }
            }

            if (l > r) r = l;

            if (replaced < 0) replaced = 0;

            ans = Math.max(ans, r-l);
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    }
}
