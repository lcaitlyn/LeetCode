import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    private static void swap(int [] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    private static List<Integer> createList(int [] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private static void backtrack(List<List<Integer>> res, int [] nums, int index) {
        if (index == nums.length) return;

        if (index + 1 == nums.length) {
            res.add(createList(nums));
            return;
        }

        for (int i = 0, size = nums.length - index; i < size; i++) {
            swap(nums, index, i + index);
            backtrack(res, nums, index + 1);
            swap(nums, i + index, index);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);
        return res;
    }

//    beats 100% 0ms, memory 93%
//    подсказку со swap дал GPT. Сперва были мысли он еще что-то предлагал обычное, но со свапом че то я быстро вкурил
//    даже не знаю как медленее эту тему сделать

//
//    private static void backtrack(List<List<Integer>> res, List<Integer> cur, int [] nums, int index) {
//        if (index == nums.length) {
//            res.add(new ArrayList<>(cur));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (cur.contains(nums[i])) continue;
//
//            cur.add(nums[i]);
//            backtrack(res, cur, nums, index + 1);
//            cur.removeLast();
//        }
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(res, new ArrayList<>(), nums, 0);
//        return res;
//    }

//    beats 34% 2ms runtime memory 34%
//    сделал чисто для себя чтобы понять суть

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1}));
        System.out.println(permute(new int[]{1,2,3,4}));
    }
}
