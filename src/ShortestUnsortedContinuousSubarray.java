import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestUnsortedContinuousSubarray {

//    public static int findUnsortedSubarray(int[] nums) {
//        тут хуйня если че
//        if (nums.length == 1) return 1;
//
//        int min = 0, max = 0;
//        int res = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[max]) {
//                max = i;
//            } else if (nums[i] < nums[min]) {
//                min = i;
//            }
//
//            if (min > max) {
//                res = (res == 0) ? min - max : Math.min(res, min - max);
//            }
//        }
//
//    }

    // хз я вот тут пытался че то сделать с указателя, но из этого нихуя не вышло
    // попробую сейчас сделать брут форсом (отсортировать массив)


//    я рот ебал кто делал примеры к этой задаче. я проебался с этой хуйней несколько дней делая вообще не то
//    я блять думал нужно найти "кратчайших подмассив из всех сломанных подмассивов в возрастающем массиве"
//    т.е по моей логике в примере 1 4 2 3 5 6 8 7 9 было бы 2 сломанных подмассива: 4 2 3 и 8 7 и самым
//    кратчайшим бы из них было 8 7 -> т.е ответ 2
//    а тут блять требовалось просто размер сломанного массива найти. т.е ответ: 7 -> [4 2 3 5 6 8 7]
//    пиздец я их рот шатал с такой формулировкой Shortest Unsorted Continuous Subarray
//    вот нахуй им пристопизденило написать Shortest уебки блять.
//    23 сентября создал я этот файл. а допер только 1 октября и то через распрашивание гпт по подсказкам, а не через
//     ответы, потому что в них тоже хуета была, потому что я другую задачу решал

    public static int findUnsortedSubarray(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            i++;
        }

        if (i == nums.length) return 0;

        int l = i - 1;
        i = nums.length - 2;
        while (i > -1 && nums[i] <= nums[i + 1]) {
            i--;
        }
        int r = i + 1;

        int min = nums[l], max = nums[r];
        for (int j = l; j < r + 1; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
        }

        for (int j = r; j < nums.length; j++) {
            if (nums[j] >= min && nums[j] < max) {
                r = j;
            }
        }

        for (int j = l; j > - 1; j--) {
            if (nums[j] > min && nums[j] <= max) {
                l = j;
            }
        }
//
//        System.out.println("l = " + l + " r = " + r + " min = " + min + " max = " + max);

        return r - l + 1;
    }

//    1 ms beats 96.29%. пиздец. ну код говна конечно. хз как они в один массив делают

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2}));
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 5, 4, 2, 6, 7}));
    }
}
