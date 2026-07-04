import java.util.*;

public class MaximumSubsequenceScore {

    private static long rec(int[] nums1, int[] nums2, int k, int i, long sum, int min) {
        if (k == 0) return (sum * min);
        if (i + k > nums1.length) return 0;

        long skip = rec(nums1, nums2, k, i + 1, sum, min);

        sum += nums1[i];
        min = Math.min(min, nums2[i]);
        k--;
        if (k == 0) return Math.max(skip, sum * min);

        return Math.max(skip, rec(nums1, nums2, k, i + 1, sum, min));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        return rec(nums1, nums2, k, 0, 0, Integer.MAX_VALUE);
    }

//    TLE

// бля ну какое-то странное задание
// как будто идём окном по двум массивам
// в правом держим priorityQueue
// а как блять левый двигать? правый вроде понятно пока он меньше K
// очень странно нах.

// Так пришла идея отсортировать, но нельзя так как subsequence ищем

// а блять. размер хуйни долэен быть РАВЕН k, а не <= K

// Так ну тут че то типо тоже - взять не взять?

// Бля это нихуя не slidingWindow, тут либо Greedy либо DP походу
// как минимум это рекурсия

// Попробуем решить с помощью рекурсии

// Сделал рекурсией - ожидаемо вышло в TLE
//
//    так погоди. Открыл подсказку и там написано:
//    How can we use sorting here?
//
//    так как нам нужна подпоследовательность, то так то мы можем брать любые числа.
//    Нам нужно вернуть maxScore а не саму подследовательность.
//    Сортировать думаю нужно по nums2, только индексы нужно сохранить
//            (отсортировать еще и nums1 чтобы они соотвествовали)
//    Как это сделать? int[][2] вот так. Что дальше? Дальше просто пройтись и всё
//
//    А нет не просто пройтись
//    Что если
//    n1=[100, 1, 2, 3]  n2=[1, 5, 6, 7] k = 2?
//    тогда сортировать по n1? .
//
//    Открыл вторую подсказу:
//    Try sorting the two arrays based on second array.
//    ну да как я и предпролагал. Только как считать то?
//
//    бля крч в пизду. просто скипну, не хочу думать тут

    public static void main(String[] args) {
        System.out.println("12 - > " + maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        System.out.println("30 - > " + maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
        System.out.println("49 - > " + maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 2));
        Deque<Integer> dq = new LinkedList<>();
    }
}
