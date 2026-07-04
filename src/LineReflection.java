import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LineReflection {

    public static boolean isReflected(int[][] points) {
        if (points.length == 0) return true;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        float med = (float) (points[0][0] + points[points.length - 1][0]) / 2;

        int l = 0, r = points.length - 1;
        while (l <= r) {
            if (points[l][1] != points[r][1]) return false;
            float mid = (float) (points[l][0] + points[r][0]) / 2;
            if (med != mid) return false;
            l++;
            r--;
        }
        return true;
    }

//    по китайскому литкоду https://www.lintcode.com/problem/908/
//    пишет что beats 95%

    public static void main(String[] args) {
        float med = (float) 7 / 2;
        System.out.println(med - 3);
        System.out.println(med - 4);
    }
}
