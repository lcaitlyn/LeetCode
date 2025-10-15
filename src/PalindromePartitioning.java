import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static boolean palindrome(String s) {
        if (s.length() == 1) return true;

        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private static void backtracking(List<List<String>> res, List<String> cur, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (!palindrome(sb.toString())) continue;

            cur.add(sb.toString());
            backtracking(res, cur, s, i + 1);
            cur.removeLast();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), s, 0);
        return res;
    }

//    beats 14.88% :D runtime 10ms, memory 97.99%
//    че такой медленный, а по памяти быстрый сук
//    мб из-за функции проверки палиндрома

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("abbc"));
        System.out.println(partition("abbcc"));
        System.out.println(partition("efe"));
    }

}
