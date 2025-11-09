public class MinimumSizeSubarraySum {

//    public static int minSubArrayLen(int target, int[] nums) {
//        int res = Integer.MAX_VALUE;
//        int l = 0, r = 0;
//
//        int sum = 0;
//
//        while (r < nums.length && res == Integer.MAX_VALUE) {
//            if (nums[r] >= target)
//                return 1;
//            sum += nums[r];
//            while (sum >= target) {
//                res = r - l + 1;
//                sum -= nums[l];
//                l++;
//            }
//            r++;
//        }
//
//        while (r < nums.length) {
//            sum += nums[r];
//            sum -= nums[l];
//
//            while (sum >= target) {
//                res = r - l;
//                l++;
//                sum -= nums[l];
//            }
//            l++;
//            r++;
//        }
//
//        return (res == Integer.MAX_VALUE) ? 0 : res;
//    }

//    beats 17.26% memory 7.64% runtime 2ms (лол 2 мс и уже 17%)

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;

        int sum = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target) {
                if (r - l + 1 < res) {
                    res = r - l + 1;
                }
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return (res == Integer.MAX_VALUE) ? 0 : res;
    }

//    beats 99% более чистый вариант

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
