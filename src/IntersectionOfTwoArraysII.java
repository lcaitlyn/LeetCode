import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {

    private static int[] find(int[] map, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map[num] > 0) {
                list.add(num);
                map[num]--;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int [] makeMap(int [] nums) {
        int [] map = new int[1001];
        for (int num : nums) {
            map[num]++;
        }
        return map;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);

        return find(makeMap(nums1), nums2);
    }

//    beats 97% memory 66.94% runtime 1 ms (3ms медианный ответ)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
