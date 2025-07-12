import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int z = sum % k;
            if (z < 0) {
                z += k;
            }
            if (map.containsKey(z)) {
                res += map.get(z);
            }
            map.put(z, map.getOrDefault(z, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(subarraysDivByK(new int[]{1, -10, 5}, 9));
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
//        System.out.println(subarraysDivByK(new int[]{2,-2,2,-4}, 6));
    }
}
