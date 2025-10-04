public class MaximumSubarray {

//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            if (sum > max) {
//                max = sum;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//            }
//        }
//
//        return max;
//    }

//    самый примитив, даже запускать не буду нах

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            max = Math.max(max, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }

        return max;
    }

    // beats 99.43% memory 43%
    // вот такое вот решение. 10 дней назад посмотрел, сейчас просто решая вспомнил
    // мы идем по циклу просто и считаем сумму, если текущая сумма меньше нуля, то там предыдущее даже и
    // считать не нужно, потому что оно только будет тянуть вниз

    // как-то так.

    public static void main(String[] args) {

    }
}
