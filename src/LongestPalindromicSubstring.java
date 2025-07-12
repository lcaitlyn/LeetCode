public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String res = "" + s.charAt(0);
        int max = 1;
        int l,r;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            if (r - l > max) {
                res = s.substring(l + 1, r);
                max = r - l;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            l = i;
            r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            if (r - l > max) {
                res = s.substring(l + 1, r);
                max = r - l;
            }
        }

        return res;
    }

    // beats 63% memory 55%
    // хз решение уебищное по моему какое-то)

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
