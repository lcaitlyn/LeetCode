public class MinimumWindowSubstring {


    private static int getIndex(char c) {
        if (Character.isUpperCase(c)) return c - 'A';
        return c - 'a' + 26;
    }

    public static String minWindow(String s, String t) {
        int[] map = new int[52];
        boolean[] set = new boolean[52];

        for (char c : t.toCharArray()) {
            int i = getIndex(c);
            map[i]++;
            set[i] = true;
        }

        int start = -1, end = -1;
        int l = 0, r = 0, missing = t.length();
        while (r < s.length()) {
            char c = s.charAt(r);
            int i = getIndex(c);
            if (set[i]) {
                if (missing == t.length()) l = r;
                if (map[i] > 0) missing--;
                map[i]--;
                while (missing == 0) {
                    if (start == -1 || r - l < end - start) {
                        start = l;
                        end = r;
                    }
                    map[getIndex(s.charAt(l))]++;
                    if (map[getIndex(s.charAt(l))] > 0) missing++;
                    l++;
                    while (l <= r && !set[getIndex(s.charAt(l))]) l++;
                }
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }

//    beats 72.37% memory 35.92% runtime 7ms
//    beats 14.17% memory 5.02% runtime 106ms
//    блять там был у меня res = s.substring() пиздец он медленный

//    просто убрав блядский substring с runtime 106ms -> 7ms ускорилось. в душе не ебал что так
//    и внатуре походу со substring в худшем случае у меня было O(n^2)



    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("ab", "b"));
    }
}
