import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    // сложно нахуй. самый просто способ брут форс
    // public int subarraySum(int[] nums, int k) {
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {

    //         int sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];

    //             if (sum == k) {
    //                 res++;
    //             }
    //         }
    //     }
    //     return res;
    // }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        int[] arr = new int[2001];
        Arrays.fill(arr, 0);

        arr[0 + 1000] = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (arr[sum - k + 1000] != -1) res += arr[sum - k + 1000];
            arr[sum + 1000]++;
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
        System.out.println("2 -> " + subarraySum2(new int[]{1, 1, 1}, 2));
//        System.out.println("1 -> " + subarraySum(new int[]{-1, -1, 1}, 1));
        System.out.println("1 -> " + subarraySum2(new int[]{-1, -1, 1}, 1));
    }
}
