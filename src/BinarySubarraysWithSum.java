import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;

        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int z = sum - goal;
            if (map.containsKey(z)) {
                res += map.get(z);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 1, 1, 1, 1}, 3));
    }
}
