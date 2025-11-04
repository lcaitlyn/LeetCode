public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                res++;
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

//    beats 32.73% memory 9.99% runtime 17ms
//    с первого раза сделал, но так как вчера делал 5. Longest Palindromic Substring
//    сделал через DP
//    если сделать через проход по стрингу + expandRomCentre, думаю быстрее будет
}
