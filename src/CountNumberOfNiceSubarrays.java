import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

//    public static int numberOfSubarrays(int[] nums, int k) {
//        int res = 0;
//        int size = 0;
//        int leftFar = 0, leftNear = 0, r = 0;
//
//        while (r < nums.length) {
//            if (nums[r] % 2 == 1) {
//                if (size == 0) leftNear = r;
//                size++;
//            }
//
//            if (size > k) {
//                leftNear++;
//                leftFar = leftNear;
//                size--;
//                while (nums[leftNear] % 2 == 0) leftNear++;
//            }
//
//            if (size == k) res += (leftNear - leftFar + 1);
//            r++;
//        }
//
//        return res;
//    }

//    runtime 8ms beats 92.42 memory 14.68%

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int oddCount = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1); // важно: "0 нечётных" уже было 1 раз

        for (int num : nums) {
            if (num % 2 == 1) oddCount++;
            res += freq.getOrDefault(oddCount - k, 0);
            freq.put(oddCount, freq.getOrDefault(oddCount, 0) + 1);
        }

        return res;

    }

//    ебать хуйня через prefixSum, как всегда нихуя не понятная блять
//    это если че гпт написал решение

    public static void main(String[] args) {
        System.out.println("16 -> " + numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
