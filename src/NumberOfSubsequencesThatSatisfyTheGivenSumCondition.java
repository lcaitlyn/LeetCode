import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        Arrays.sort(nums);

        long res = 0;

        int[] pow = new int[nums.length + 1];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res += pow[r - l];
                l++;
            } else {
                r--;
            }
        }

        return (int) res % MOD;
    }

//    beats 48.85% memory 75.19% runtime 33ms
//    пиздец ну и уебищное задание
//    еле еле сделал, даже с ответами нихуя не понятно

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }
}
