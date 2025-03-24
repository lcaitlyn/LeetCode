import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        if (i == intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }

        int start = (intervals[i][0] < newInterval[0]) ? intervals[i][0] : newInterval[0];

        while (i < intervals.length && newInterval[1] > intervals[i][1]) {
            i++;
        }
        if (i == intervals.length) {
            res.add(new int[]{start, newInterval[1]});
        } else if (newInterval[1] < intervals[i][0]) {
            res.add(new int []{start, newInterval[1]});
        } else {
            if (i < intervals.length) {
                res.add(new int[]{start, intervals[i][1]});
            } else {
                res.add(new int[]{start, newInterval[1]});
            }
            i++;
        }

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int [][] arr = new int [][] {new int[]{2,3}, new int[]{4,5}, new int[]{6,7}, new int[]{8,9}, new int[]{10,11}};
        int [][] arr1 = new int [][] {new int[]{1,3}, new int[]{6,9}};
        int [][] arr2 = new int [][] {new int[]{1,5}};

        int [][] res = insert(arr1, new int[]{2, 7});
        for (int [] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}

    // Провозился этим заданием пару дней.
    // В итоге от начального результата надо было добавить 1 микро условие (которое было очевидным)
    // Результат runime 99%
