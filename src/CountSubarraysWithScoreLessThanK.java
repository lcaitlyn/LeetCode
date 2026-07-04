public class CountSubarraysWithScoreLessThanK {


    public static long countSubarrays(int[] nums, long k) {
        long res = 0;
        long sum = 0;

        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];

            while (l <= r && sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }

            if (l <= r && sum * (r - l + 1) < k)
                res += r - l + 1;

            r++;
        }

        return res;
    }

//    runtime 3ms beats 37.4% memory 6.09%
//    хз, изичный Hard
//    мб конечно потому что дохуя похожих прорешал (992, 1248, 1358, 713)
}
