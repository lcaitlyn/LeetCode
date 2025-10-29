public class JumpGame {

//    private static boolean rec(int[] nums, int index) {
//        if (index < 0) return false;
//        if (index == 0) return true;
//
//        int i = index - 1;
//        while (i >= 0) {
//            if (nums[i] + i >= index) {
//                if (rec(nums, i)) return true;
//            }
//            i--;
//        }
//        return false;
//    }
//
//    public static boolean canJump(int[] nums) {
//        return rec(nums, nums.length - 1);
//    }

//  TLE
//  76 / 175 testcases passed
//  [2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]

//    public static boolean canJump(int[] nums) {
//        int good = nums.length - 1;
//        int i = good - 1;
//        while (i >= 0) {
//            if (nums[i] + i >= good) {
//                good = i;
//            }
//            i--;
//        }
//        return (good == 0);
//    }

//    beats 84% memory 7% runtime 2ms
//    пиздец че это не Medium нихуя

    public static boolean canJump(int[] nums) {
        int farthest = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (farthest >= nums.length - 1) return true;
            if (i > farthest) return false;
            farthest = Math.max(farthest, nums[i] + i);
        }
        return farthest >= nums.length - 1;
    }

//    beats 84% memory 37% runtime 2ms
//    переделал под Greedy алгоритм

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }
}
