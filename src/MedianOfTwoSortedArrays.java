public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int len1 = nums1.length, len2 = nums2.length;

        int total = len1 + len2;
        int half = total / 2;

        int l = 0, r = len1 - 1;

        while (true) {
            int med1 = Math.floorDiv(r - l, 2) + l;
            int med2 = half - med1 - 2;

            int maxLeft1 = (med1 < 0) ? Integer.MIN_VALUE : nums1[med1];
            int minRight1 = (med1 + 1 >= len1) ? Integer.MAX_VALUE : nums1[med1 + 1];
            int maxLeft2 = (med2 < 0) ? Integer.MIN_VALUE : nums2[med2];
            int minRight2 = (med2 + 1 >= len2) ? Integer.MAX_VALUE : nums2[med2 + 1];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (total % 2 == 1)
                    return Math.min(minRight1, minRight2);
                return (double)(Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
            }
            if (maxLeft1 > minRight2) {
                r = med1 - 1;
            } else {
                l = med1 + 1;
            }
        }
    }


//    beats 100% memory 5.01% runtime 1ms
//    ебал я рот этой задачи
//    я блять до сих пор не вкурил всего решения, а точнее дрочева с этими Max Min
//    хочется обосрать какое-же уебищное это задание, но на самом деле просто я ахуенно тупой(
//    пиздец, я думал щас по фасту решу это говнище
//    и даже с ответов зная как это решать, точнее алгоритм хуй я смог его написать сам
//    только блять по решение я смог переписать это
//    итог - алгоритмы хуйня

//    дай мне через неделю заново решить эту хуйню - я не решу. че уже там неделю нахуй
//    через час (даже не через день), я не решу нахуй
//    по меняй чуть чуть условия - сразу затуп будет галактический(
//    по факту задача - HARD
//    так тупил я только на PrefixSum (даже щас наверное хуй я их нормально решу)
//    хотя вроде binarySearch показалось мне не очень сложной проблемой, особенно после видоса от "кодируем"

    public static void main(String[] args) {
        int [] nums1, nums2;
//        nums1 = new int[] {1,2,3};
//        nums2 = new int[] {4,5};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{3,4,5}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{4, 5}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
    }
}
