import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        int z = 0, o = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z++;
            } else {
                o++;
            }
            int diff = Math.abs(z - o);
            if (map.containsKey(diff)) {
                res = Math.max(res, i - map.get(diff));
            }
                map.put(diff, i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }
}
