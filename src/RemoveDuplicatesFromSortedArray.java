import java.util.Arrays;
import java.util.TreeSet;

public class RemoveDuplicatesFromSortedArray {

//    public static int removeDuplicates(int[] nums) {
//        TreeSet<Integer> set = new TreeSet<>();
//
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        int i = 0;
//        while (!set.isEmpty()) {
//            nums[i] = set.pollFirst();
//            i++;
//        }
//
//        return i;
//    }

    // RunTime 6ms (beats 5.13%)

    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }

        System.out.println(Arrays.toString(nums));

        return l + 1;
    }

    // runtime 0ms beats 100%

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3}));
    }
}
