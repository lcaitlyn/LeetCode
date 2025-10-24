import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

    private static List<Integer> find(int[] map, int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (map[num + 1000] == 0) {
                set.add(num);
            }
        }

        return new ArrayList(set);
    }

    private static int[] makeMap(int[] nums) {
        int[] map = new int[2001];
        for (int num : nums) {
            map[num + 1000]++;
        }
        return map;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(find(makeMap(nums2), nums1));
        res.add(find(makeMap(nums1), nums2));
        return res;
    }

//    beats 98% memory 37% runtime 7ms
//    хз выше чем медианных ответ (видимо решается по другому как-то дефолтный ответ)

    public static void main(String[] args) {

    }
}
