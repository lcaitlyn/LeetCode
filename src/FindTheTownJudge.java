import java.util.*;

public class FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {
        int [] trusted = new int[n + 1];
        int [] unTrusted = new int[n + 1];

        if (n == 1) return 1;

        for (int i = 0; i < trust.length; i++) {
            unTrusted[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        for (int i = 0; i < n + 1; i++) {
            if (trusted[i] == n - 1 && unTrusted[i] == 0) return i;
        }


        return -1;
    }

    // beats 67% 3ms

    public static void main(String[] args) {
//        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
//        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(1, new int[][]{{}}));
    }
}
