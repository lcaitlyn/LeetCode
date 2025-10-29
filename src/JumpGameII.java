public class JumpGameII {

//    private static int rec(int[] nums, int index) {
//        if (index >= nums.length - 1) return 0;
//        if (nums[index] == 0) return Integer.MAX_VALUE;
//
//        return 1 + Math.min(rec(nums, index + 1), rec(nums, index + nums[index]));
//    }
//
//    public static int jump(int[] nums) {
//        return rec(nums, 0);
//    }

//    WA [4,1,1,3,1,1,1]
//    не правильно немного моя рекурсия работает. Думаю не стоит её продолжать развивать, все равно TLE выдаст
//    возможно стоит

//    public static int jump(int[] nums) {
//        int l = 0, r = nums[0];
//        if (nums.length == 1) return 0;
//        int count = 0;
//
//        while (r < nums.length) {
//            count++;
//            int cur = r;
//            int farthest = r;
//            if (r == nums.length - 1) return count;
//            while (r > l) {
//                farthest = Math.max(farthest ,r + nums[r]);
//                r--;
//            }
//            l = cur;
//            r = farthest;
//        }
//
//        if (l != nums.length - 1) count++;
//
//        return (count == 0) ? 1 : count;
//    }

//    beats 99% memry 31% runtime 1ms
//    пиздец заебали корнер кейсы сука. с 8ой попытки только сдал нахуй
//    ладно на самом деле я злой на себя, а не на задачу. надо было сразу все предусматривать
//    но откуда я мог знать?

//    бля почитал решения, оказывается кусок говна а не решение, надо было ебашить O(n) цикл от 0 до конца
//    мб переделаю если не впадлу будет

    public static int jump(int[] nums) {
        int end = 0, farthest = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                count++;
                end = farthest;
            }
        }
        return count;
    }

//    beats 99% memry 86% runtime 1ms
//    крч все таки сделал

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
        System.out.println(jump(new int[]{1,2,3}));
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        System.out.println(jump(new int[]{1,1,1,1}));
    }
}
