public class ShortestPalindrome {

    private static int isValidPalindrome(String s, int l, int r) {
        if (s.length() - r >= l) return 0;

        while (l >= 0) {
            if (s.charAt(l) != s.charAt(r)) return 0;
            l--;
            r++;
        }
        return r;
    }

    public static String shortestPalindrome(String s) {
        if (s.isEmpty()) return s;

        int max = 1;
        int n = (s.length() % 2 == 0) ? s.length() / 2 : s.length() / 2 + 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, isValidPalindrome(s, i, i));
            max = Math.max(max, isValidPalindrome(s, i, i + 1));
        }

        if (max == s.length()) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= max; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aaacecaaa -> " + shortestPalindrome("aacecaaa"));
        System.out.println("dcbabcd -> " + shortestPalindrome("abcd"));
        System.out.println("a -> " + shortestPalindrome("a"));
        System.out.println("aa -> " + shortestPalindrome("aa"));
        System.out.println("bab -> " + shortestPalindrome("ab"));
        System.out.println("bbabb -> " + shortestPalindrome("abb"));
    }
}
