public class CountTheNumberOfComputerUnlockingPermutations {

//    private static int rec(int[] nums, boolean[] unlocked, int size) {
//        if (size == nums.length) return 1;
//
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (unlocked[i] == false && nums[i] > nums[0]) {
//                unlocked[i] = true;
//                size++;
//                res += rec(nums, unlocked, size);
//
//                unlocked[i] = false;
//                size--;
//            }
//        }
//        return res;
//    }
//
//    public static int countPermutations(int[] complexity) {
//        boolean[] unlocked = new boolean[complexity.length];
//        unlocked[0] = true;
//        return rec(complexity, unlocked, 1);
//    }

//    TLE (ожидаемое)
//    ну хотя бы понял что от нас требуется

//    вообще это задачка явно на DP, только вопрос как её решать за O(n)

    public static int countPermutations(int[] complexity) {
        int MOD = 1_000_000_007;

        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) return 0;
        }

        long fact = 1;
        for (int i = 1; i < complexity.length; i++) {
            fact = fact * i % MOD;
        }

        return (int) fact;
    }

//    beats 100% memory 13.33% runtime 1ms

    public static void main(String[] args) {
        System.out.println(countPermutations(new int[]{1, 2, 3}));
    }
}
