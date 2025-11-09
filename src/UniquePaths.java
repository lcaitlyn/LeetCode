public class UniquePaths {

//    Давай подумаем без ответов, решений и подсказок с твоей стороны.
//    так ну тут я подумал, и Крч мы начинаем с левого верхнего,
//    туда добраться мы можем за 1 то есть path[0][0] = 1,
//    и затем мы можем идти только вниз или вправо,
//    то есть следующая клетка будет path[i][j] = path[i -1]]j] + path[i][j-1].
//    Ну вроде все

//    public static int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        dp[0][0] = 1;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i - 1 < 0 && j - 1 < 0) continue;
//
//                if (i - 1 < 0) {
//                    dp[i][j] = dp[i][j - 1];
//                } else if (j - 1 < 0) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//                }
//            }
//        }
//        return dp[m- 1][n - 1];
//    }

//    beats 100% memory 5.23% runtime 0ms
//    память ГПТ сказал что можно только хранить в одну строку
//    у меня сейчас память O(m * n)
//    думаю можно сделать O(n)

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 < 0) continue;

                if (i - 1 < 0) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

//    не изменилось

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
