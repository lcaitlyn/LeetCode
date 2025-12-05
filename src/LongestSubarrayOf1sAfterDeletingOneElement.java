public class LongestSubarrayOf1sAfterDeletingOneElement {

//    public static int longestSubarray(int[] nums) {
//        int l = 0, r = 0, count = 0, max = 0;
//
//        int deleted = -1;
//        while (r < nums.length) {
//            if (nums[l] == 0) {
//                r++;
//                deleted++;
//                l = r;
//            } else if (nums[r] == 1) {
//                r++;
//                count++;
//                if (deleted < l) {
//                    max = Math.max(max, count - 1);
//                } else {
//                    max = Math.max(max, count);
//                }
//            } else {
//                if (deleted < l) {
//                    max = Math.max(max, count);
//                    deleted = r;
//                    r++;
//                } else if (nums[deleted + 1] == 1) {
//                    count -= deleted - l;
//                    l = deleted + 1;
//                } else {
//                    deleted = r;
//                    r++;
//                    l = r;
//                    count = 0;
//                }
//            }
//        }
//
//        if (deleted >= 0 && deleted < l) {
//            return Math.max(max, count);
//        }
//
//        return max;
//    }

    // beats 78.66% memory 90%
    // хз даже не пробовал делать брут форсом. просто сделал такое решение
    // очень замудренное, но это из-за корнер кейсов. ответы не смотрел

    // посмотрел ответы как всегда у меня замудренное решение сука. ведь я знал что оно должно быть проще
    // тем более я недавно решал ебаный Max Consecutive Ones III который очень похож

//    public static int longestSubarray(int[] nums) {
//        int zero = 0, max = 0;
//        int l = 0, r = 0;
//
//        while (r < nums.length) {
//            if (nums[r] == 0) {
//                zero++;
//                while (zero > 1) {
//                    if (nums[l] == 0) {
//                        zero--;
//                    }
//                    l++;
//                }
//            }
//            r++;
//            max = Math.max(max, r - l - 1);
//        }
//
//        return Math.max(max, r - l - 1);
//    }

//    upd. 19.11.25
//    res: 22.09.25
//    beats 82.11% memory 92.48% runtime 3ms

    public static int longestSubarray(int[] nums) {
        int zeros = 0, max = 0;
        int l = 0, r = 0;

        while (r < nums.length) {
            if (nums[r] == 0) zeros++;

            while (zeros > 1) {
                if (nums[l] == 0) zeros--;
                l++;
            }

            max = Math.max(max, r - l);
            r++;
        }

        return max;
    }

//    upd 18.11.2025
//    Дали эту задачу на Алгособесе в Яндекс

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
    }
}
