import java.util.*;

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int target = 0 - nums[l] - nums[r];
                if (target == nums[i]) {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(list);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (target > nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    // Результат: Runtime 30-31 ms (beats 60%+)

    private static void printRes(List<List<Integer>> list) {
        list.forEach(System.out::println);
        System.out.println("size = " + list.size());
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        printRes(threeSum(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
