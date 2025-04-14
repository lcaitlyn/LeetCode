import java.util.*;

public class LongestConsecutiveSequence {
    
    // public static int longestConsecutive(int[] nums) {
    //     Arrays.sort(nums);

    //     int len = 0;
    //     int i = 0;
    //     int k = 1;
    //     while (i < nums.length - 1) {
    //         if (nums[i] + 1 == nums[i + 1]) {
    //             k++;
    //         }

    //         if (nums[i] + 1 < nums[i + 1]) {
    //             len = Math.max(len, k);
    //             k = 1;
    //         }

    //         i++;
    //     }

    //     return Math.max(k, len);
    // }

    // Runtime 18 ms Beats 85% (но я сделал какое то не стандартное решение), потом что оно
    // не популярно. Популярные решения за 27ms и за  12ms
    // По памяти 82%+


    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        while (!set.isEmpty()) {

        }
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,3,3,3,3,3,7,2,5,8,4,6,0,1}));
    }
}
