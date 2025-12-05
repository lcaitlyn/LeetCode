import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

//    public static List<Integer> findDuplicates(int[] nums) {
//        int[] set = new int[100001];
//        List<Integer> result = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (set[nums[i] - 1] == 1) {
//                result.add(nums[i]);
//            }
//            set[nums[i] - 1]++;
//        }
//
//        return result;
//    }

//    beats 86.02% memory 12% runtime 6ms

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            int val = nums[index];
            if (val < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        return result;
    }

//    beats 86.02% memory 32% runtime 6ms
//    хз как чел пришел к такому решению

    public static void main(String[] args) {

    }
}
