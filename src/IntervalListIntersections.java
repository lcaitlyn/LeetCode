import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int []> list = new ArrayList<>();

        int l = 0, r = 0;
        while (l < firstList.length && r < secondList.length) {
            if (firstList[l][1] < secondList[r][0]) {
                l++;
            } else if (secondList[r][1] < firstList[l][0]) {
                r++;
            } else {
                int a = Math.max(firstList[l][0], secondList[r][0]);
                int b = Math.min(firstList[l][1], secondList[r][1]);
                
                list.add(new int [] {a, b});

                if (b == firstList[l][1]) {
                    l++;
                } else {
                    r++;
                }
            }
        }

        return list.toArray(new int [][]{});
    }

    // Beats 99%, runtime 3ms, memory 33%
    // Хз, но по памяти даже хз че улучшать. Мб от листа избавиться, но это уже слишком

    public static void main(String[] args) {
        // [[0,2],[5,10],[13,23],[24,25]]
        int [][] a = new int [][]{
            new int []{0, 2},
            new int []{5, 10},
            new int []{13, 23},
            new int []{24, 24}
        };

        // [[1,5],[8,12],[15,24],[25,26]]
        int [][] b = new int [][]{
            new int []{1, 5},
            new int []{8, 12},
            new int []{15, 24},
            new int []{25, 26}
        };

        System.out.println(Arrays.deepToString(intervalIntersection(a, b)));
    }
}
