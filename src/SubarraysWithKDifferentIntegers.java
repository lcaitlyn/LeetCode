import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {


//    public static int subarraysWithKDistinct(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//
//        int l = 0, r = 0;
//        int size = 0;
//        while (r < nums.length) {
//            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
//
//            if (map.get(nums[r]) == 1) size++;
//
//            while (size > k) {
//                map.put(nums[l], map.get(nums[l]) - 1);
//                if (map.get(nums[l]) == 0) size--;
//                if (size > k) res++;
//                l++;
//            }
//
//            if (size == k) res++;
//
//            r++;
//        }
//
//        while (size == k) {
//            map.put(nums[l], map.get(nums[l]) - 1);
//            if (map.get(nums[l]) == 0) size--;
//            if (size == k) res++;
//            l++;
//        }
//
//        return res;
//    }

//    бля тут я всё пытался сделать (возможно даже сделал правильный вариант со знаками)
//    но блять в ответах неправильно указал к чему стремится и поэтому поломал

//    public static int subarraysWithKDistinct(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//
//        int ln = 0, lf = 0, r = 0; // ln = leftNear pointer, lf = leftFar pointer
//        int size = 0;
//        while (r < nums.length) {
//            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
//
//            if (map.get(nums[r]) == 1) size++;
//
//            if (size > k) {
//                while (size > k) {
//                    map.put(nums[ln], map.get(nums[ln]) - 1);
//                    if (map.get(nums[ln]) == 0) size--;
//                    ln++;
//                }
//                lf = ln;
//            }
//
//            if (size == k) {
//                while (map.get(nums[ln]) > 1) {
//                    map.put(nums[ln], map.get(nums[ln]) - 1);
//                    ln++;
//                }
//                res += ln - lf + 1;
//            }
//
//            r++;
//        }
//
//        return res;
//    }

//    runtime 39ms, beats 88.12%, memory 66.8%
//    бля мб можно через int[] сделать

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int[] map = new int[20001];
        int res = 0;

        int ln = 0, lf = 0, r = 0; // ln = leftNear pointer, lf = leftFar pointer
        int size = 0;
        while (r < nums.length) {
            map[nums[r]]++;

            if (map[nums[r]] == 1) size++;

            if (size > k) {
                while (size > k) {
                    map[nums[ln]]--;
                    if (map[nums[ln]] == 0) size--;
                    ln++;
                }
                lf = ln;
            }

            if (size == k) {
                while (map[nums[ln]] > 1) {
                    map[nums[ln]]--;
                    ln++;
                }
                res += ln - lf + 1;
            }

            r++;
        }

        return res;
    }

//    runtime 5ms, beats 98.99%, memory 87.88%
//    ну да мапа зарешала

    public static void main(String[] args) {
        System.out.println("7 -> " + subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println("6 -> " + subarraysWithKDistinct(new int[]{1, 2, 1, 2}, 2));
        System.out.println("5 -> " + subarraysWithKDistinct(new int[]{1, 2, 2, 1}, 2));
        System.out.println("3 -> " + subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }
}
