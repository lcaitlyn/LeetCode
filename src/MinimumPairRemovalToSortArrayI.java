public class MinimumPairRemovalToSortArrayI {

    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;
        int min = nums[0], r = 1;
        int res = 0, sum = 0;

        while (r < n) {
            sum += nums[r];

            if (r + 1 == n && sum < min) return res + 2;

            if (sum < min) {
                res++;
            } else {
                min = sum;
                sum = 0;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1}));
    }
}
