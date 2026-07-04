import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
//    public static int numSubarraysWithSum(int[] nums, int goal) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0, sum = 0;
//
//        map.put(0, 1);
//        for (int num : nums) {
//            sum += num;
//            int z = sum - goal;
//            if (map.containsKey(z)) {
//                res += map.get(z);
//            }
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//        }
//        return res;
//    }

//    (4.06.2026) тут оказывается был такой результат:
//    runtime 22ms beats 41.72% memory 12.93% (сдавал 12.07.2025)
//    а ну бля, потому что мапа используется. логично

//    public static int numSubarraysWithSum(int[] nums, int goal) {
//        int res = 0;
//        int sum = 0;
//
//        int l = 0, m = 0, r = 0;
//        while (r < nums.length) {
//            sum += nums[r];
//
//            if (sum > goal) {
//                while (l < nums.length && sum > goal) {
//                    sum -= nums[l];
//                    l++;
//                }
//                m = l;
//            }
//
//            while (m < r && nums[m] == 0) m++;
//
//            if (l <= r && sum == goal) res += m - l + 1;
//
//            r++;
//        }
//
//        return res;
//    }

//    upd. 4.06.2026 (решаю в качестве подготовки, по примеру делаю 992, 1248, 1358 и т.д)
//    runtime 3ms beats 52.25% memory 76.55%

//    только щас (после того как апрувнул) решил посмотреть предыдущее решение, оказывается там
//    я решал с помощью prefixSum, а тут slidingWindow ебать

//    upd 15.06.2026

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;

        int sum = 0;
        for (int n : nums) {
            sum += n;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

//    15.06.2026
//    бля странно что это точно такое эе решение как и к 530

    public static void main(String[] args) {
//        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,1}, 2));
//        System.out.println(numSubarraysWithSum(new int[]{0, 1, 1, 1, 1}, 3));
        System.out.println("4 -> " + numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println("27 -> " + numSubarraysWithSum(new int[]{0,0,0,0,0,0,1,0,0,0}, 0));
    }
}
