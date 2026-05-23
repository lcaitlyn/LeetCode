import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            int k = 1;
            while (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                k++;
                r++;
            }

            for (int i = 0; i < Math.min(2, k); i++) {
                nums[l++] = nums[r];
            }
            r++;
        }

        return l;
    }

//    только с ответами родил эту хуйню
//    runtime 1ms beats 17% memory 83%

    private static boolean isTrue(int[] nums, int[] expectedNums) {
        int k = removeDuplicates(nums); // Calls your implementation

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(expectedNums));
        System.out.println("k = " + k);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            if (nums[i] != expectedNums[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums;
        int[] expectedNums;
        nums = new int[]{1, 1, 1, 2, 2, 3};
        expectedNums = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(isTrue(nums, expectedNums));
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        expectedNums = new int[]{0, 0, 1, 1, 2, 3, 3};
        System.out.println(isTrue(nums, expectedNums));

    }
}
