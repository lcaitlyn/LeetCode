public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;

        if (t.length() == 0) return false;

        for (int i = 0; i < t.length(); i++) {

            if (t.length() - i < s.length()) return false;

            if (s.charAt(0) == t.charAt(i)) {
                i++;
                int r = 1;
                while (i < t.length() && r < s.length()) {
                    if (t.charAt(i) == s.charAt(r)) {
                        r++;
                    }
                    i++;
                }
                return r == s.length();
            }
        }
        return false;
    }

//    beats 66% memory 74% runtime 2ms
}
