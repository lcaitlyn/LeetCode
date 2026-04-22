import java.util.HashMap;
import java.util.Map;

public class CountSpecialTriplets {

    public static int specialTriplets(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        long MOD = 1_000_000_007L;
        long [] prev = new long[nums.length];
        long [] next = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prev[i] = map.getOrDefault((long) nums[i] * 2, 0);
            map.put((long) nums[i], map.getOrDefault((long) nums[i], 0) + 1);
        }

        map.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            next[i] = map.getOrDefault((long) nums[i] * 2, 0);
            map.put((long) nums[i], map.getOrDefault((long) nums[i], 0) + 1);
        }

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (prev[i] * next[i]) % MOD) % MOD;
        }

        return (int) res;
    }

//    beats 79.07% memory 13% runtime 180ms

    public static void main(String[] args) {
        System.out.println(specialTriplets(new int[]{6,3,6}));
        System.out.println(specialTriplets(new int[]{0, 1, 0, 0}));
        System.out.println(specialTriplets(new int[]{8, 4, 2, 8, 4}));
    }
}
