import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    // так ну насчёт решения хз. возможно сделать сортировку и уже от неё отталкиваться
    // ладно сделаю пока брут форсом. Хотя вопрос еще - как сделать то брут форсом еще
    // как будто один способ это сортировка

//    public static int[][] merge(int[][] intervals) {
//        int n = intervals.length;
//
//        if (n == 1) return intervals;
//
//        int[] a = new int[n], b = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = intervals[i][0];
//            b[i] = intervals[i][1];
//        }
//        Arrays.sort(a);
//        Arrays.sort(b);
//
//        List<int[]> list = new ArrayList<>();
//
//        int l = 0, r = 0;
//        while (l < n && r < n) {
//            while (r < n - 1 && (a[r + 1] <= b[l] || (b[r] >= a[r + 1] && b[r] <= b [r + 1]))) {
//                r++;
//            }
//
//            if (r == n) r--;
//
//            list.add(new int[]{a[l], b[r]});
//
//
//            r++;
//            l = (l == r) ? l + 1 : r;
//        }
//
//        n = list.size();
//        int [][] res = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            res[i][0] = list.get(i)[0];
//            res[i][1] = list.get(i)[1];
//        }
//
//        return res;
//    }

    // runtime 99.23 4ms (ср 8ms)
    // ебать я гений до такой хуйни догадался как-то и сделал выше среднего результата

    // ладно я ебал, щас посмотрел овтеты. там еще проще сделали

    // начнём с вывода, ебать ты хуйню сделал бро

    // вместо этого
//    n = list.size();
//    int [][] res = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//        res[i][0] = list.get(i)[0];
//        res[i][1] = list.get(i)[1];
//    }

//    надо было сделать так: return list.toArray(new int[list.size()][2]);

    // затем вместо
//    int[] a = new int[n], b = new int[n];
//        for (int i = 0; i < n; i++) {
//        a[i] = intervals[i][0];
//        b[i] = intervals[i][1];
//    }
//        Arrays.sort(a);
//        Arrays.sort(b);


    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int l = 0, r = 0;

        while (l < intervals.length) {
            while (r < intervals.length - 1
                    && (intervals[r + 1][0] <= intervals[l][1]
                    || (intervals[r][1] >= intervals[r + 1][0] && intervals[r][1] <= intervals[r + 1][1]))) {
                r++;
            }

            if (r == intervals.length) r--;

            list.add(new int[]{intervals[l][0], Math.max(intervals[l][1], intervals[r][1])});

            r++;
            l = (l == r) ? l + 1 : r;
        }

        return list.toArray(new int[list.size()][2]);
    }

    // вот мой чистый варик
//    upd 17.11 оказывается тут был WA [[1,4],[2,3]] на таком кейсе

//    List<int[]> merged = new ArrayList<>();
//    int[] prev = intervals[0];
//
//        for (int i = 1; i < intervals.length; i++) {
//        int[] interval = intervals[i];
//        if (interval[0] <= prev[1]) {
//            prev[1] = Math.max(prev[1], interval[1]);
//        } else {
//            merged.add(prev);
//            prev = interval;
//        }
//    }

    // вот как там решение в ответах. очень просто заходит ли массив в интервал или нет
    // блять ну как этот Math.max(int [], int []) работает лол. Я даже не ебу

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{4, 5}, {1, 4}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 1}, {1, 1}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{4, 7}, {1, 4}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {0, 2}, {3, 5}})));
    }
}
