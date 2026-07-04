public class MinimumWindowSubstring {


//    private static int getIndex(char c) {
//        if (Character.isUpperCase(c)) return c - 'A';
//        return c - 'a' + 26;
//    }
//
//    public static String minWindow(String s, String t) {
//        int[] map = new int[52];
//        boolean[] set = new boolean[52];
//
//        for (char c : t.toCharArray()) {
//            int i = getIndex(c);
//            map[i]++;
//            set[i] = true;
//        }
//
//        int start = -1, end = -1;
//        int l = 0, r = 0, missing = t.length();
//        while (r < s.length()) {
//            char c = s.charAt(r);
//            int i = getIndex(c);
//            if (set[i]) {
//                if (missing == t.length()) l = r;
//                if (map[i] > 0) missing--;
//                map[i]--;
//                while (missing == 0) {
//                    if (start == -1 || r - l < end - start) {
//                        start = l;
//                        end = r;
//                    }
//                    map[getIndex(s.charAt(l))]++;
//                    if (map[getIndex(s.charAt(l))] > 0) missing++;
//                    l++;
//                    while (l <= r && !set[getIndex(s.charAt(l))]) l++;
//                }
//            }
//            r++;
//        }
//        return start == -1 ? "" : s.substring(start, end + 1);
//    }

//    beats 72.37% memory 35.92% runtime 7ms
//    beats 14.17% memory 5.02% runtime 106ms
//    блять там был у меня res = s.substring() пиздец он медленный

//    просто убрав блядский substring с runtime 106ms -> 7ms ускорилось. в душе не ебал что так
//    и внатуре походу со substring в худшем случае у меня было O(n^2)



//    private static int getIndex(char c) {
//        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
//        return c - 'a';
//    }
//
//    public static String minWindow(String s, String t) {
//        int[] set = new int[52];
//        int[] map = new int[52];
//        int size = 0;
//        String res = "";
//
//        for (int i = 0; i < t.length(); i++) {
//            if (set[getIndex(t.charAt(i))] == 0) size++;
//
//            set[getIndex(t.charAt(i))]++;
//        }
//
//        int l = 0, r = 0;
//        while (r < s.length()) {
//            map[getIndex(s.charAt(r))]++;
//
//            if (map[getIndex(s.charAt(r))] == set[getIndex(s.charAt(r))]) {
//                size--;
//            }
//
//            while (set[getIndex(s.charAt(r))] > 0 && map[getIndex(s.charAt(l))] > set[getIndex(s.charAt(l))]) {
//                map[getIndex(s.charAt(l))]--;
//                l++;
//            }
//
//            while (l < r && set[getIndex(s.charAt(l))] == 0) {
//                l++;
//            }
//
//            if (size == 0 && (res.isEmpty() || res.length() > r - l)) {
//                res = s.substring(l, r + 1);
//            }
//
//            r++;
//        }
//
//        return res;
//    }

//    runtime 6ms beats 64.33% memory 50.25%
//    сделал еще раз в качестве тренировки

    private static int getIndex(char c) {
        return Character.isUpperCase(c) ? c - 'A' : c - 'a' + 26;
    }

    public static String minWindow(String s, String t) {
        int[] set = new int[52];
        int size = 0;
        for (char c : t.toCharArray()) {
            set[getIndex(c)]++;
            if (set[getIndex(c)] == 1) size++;
        }

        String res = "";
        int[] map = new int[52];
        int l = 0, r = 0;
        while (r < s.length()) {
            int i = getIndex(s.charAt(r));
            map[i]++;
            if (set[i] > 0 && map[i] == set[i]) size--;


            int j = getIndex(s.charAt(l));
            while (l < r && ((set[j] == 0) || (size == 0 && set[j] > 0 && map[j] > set[j]))) {
                if (set[j] > 0 && map[j] == set[j]) size++;
                map[j]--;
                l++;
                j = getIndex(s.charAt(l));
            }

            if (size == 0) {
                if (res.isEmpty() || r - l + 1 < res.length())
                    res = s.substring(l, r + 1);
            }

            r++;
        }

        return res;
    }

//    runtime 7ms

    public static void main(String[] args) {
//        System.out.println("BANC -> " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("abbbbbcdd -> " + minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("a", "aa"));
//        System.out.println(minWindow("ab", "b"));
//        System.out.println(minWindow("aab", "aab"));
    }
}
