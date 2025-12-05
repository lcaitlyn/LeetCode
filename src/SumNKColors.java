import java.util.*;

public class SumNKColors {

    static int N, K;
    static long[][][] memo;

    public static void main(String[] args) {
        N = 3;
        K = 2;
        memo = new long[N+1][N+1][K+1];
        System.out.println(rec(N, N, N, K, K)); // 10

        N = 4;
        K = 3;
        memo = new long[N+1][N+1][K+1];
        for(long[][] arr : memo)
            for(long[] a : arr)
                Arrays.fill(a, -1);
        System.out.println(rec(N, N, N, K, K)); // 51
    }

    private static long rec(int cur, int last, int n, int k, int j) {
        if (cur < 1 || last < 0) return 0;
        if (last == 0) return 1;
        if (memo[cur][last][j] != -1) return memo[cur][last][j];

        long down = 0;
        if (j == 0) down = rec(cur - 1, last, n, k, k); // переходим к следующему числу

        // берем текущий экземпляр
        long take = 0;
        if (j > 0 && last - cur >= 0)
            take = rec(cur, last - cur, n, k, j - 1);

        // пропускаем текущий экземпляр
        long skip = 0;
        if (j > 0)
            skip = rec(cur, last, n, k, j - 1);

        memo[cur][last][j] = down + take + skip;
        return memo[cur][last][j];
    }
}