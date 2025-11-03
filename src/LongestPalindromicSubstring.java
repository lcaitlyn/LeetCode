public class LongestPalindromicSubstring {

//    public static String longestPalindrome(String s) {
//        String res = "" + s.charAt(0);
//        int max = 1;
//        int l,r;
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) != s.charAt(i + 1)) continue;
//            l = i;
//            r = i + 1;
//
//            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//                l--;
//                r++;
//            }
//            if (r - l > max) {
//                res = s.substring(l + 1, r);
//                max = r - l;
//            }
//        }
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            l = i;
//            r = i;
//
//            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
//                l--;
//                r++;
//            }
//
//            if (r - l > max) {
//                res = s.substring(l + 1, r);
//                max = r - l;
//            }
//        }
//
//        return res;
//    }

    // beats 63% memory 55%
    // хз решение уебищное по моему какое-то)
//    22.05.2025

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int l = 0, max = 1;

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
                max = 2;
                l = i;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        l = i;
                    }
                }
            }
        }
        return s.substring(l, l + max);
    }

//    beats 31.53% memory 5.35% runtime 113ms. Чет с DP медленее(
//    3.11.2025

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abababaa"));
        System.out.println(longestPalindrome("aaaa"));
    }
}
