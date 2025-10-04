public class _3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return target;

                    if (sum == res) continue;

                    if (Math.max(sum, target) - Math.min(sum, target) < Math.max(res, target) - Math.min(res, target)) res = sum;
                }
            }
        }

        return res;
    }

    // лол а че я не доделал
//     20 июня сдал 612 ms 0% beats лол, сегодня 23 сентября

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}
