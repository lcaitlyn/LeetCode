import java.util.*;

public class GenerateParentheses {

    // private static String addFirst(String s) {
    //     return "()" + s;
    // }

    // private static String addBack(String s) {
    //     return s + "()";
    // }

    // private static String wrap(String s) {
    //     return "(" + s + ")";
    // }

    // public static List<String> generateParenthesis(int n) {
    //     Queue<String> q = new LinkedList<>();
    //     q.add("()");

    //     int i = 1;
    //     while (i < n) {
    //         int size = q.size();
    //         for (int j = 0; j < size; j++) {
    //             Set<String> lib = new HashSet<>();
    //             String s = q.poll();
    //             String r = addFirst(s);
    //             if (!lib.contains(r)) {
    //                 lib.add(r);
    //                 q.add(r);
    //             }
    //             r = addBack(s);
    //             if (!lib.contains(r)) {
    //                 lib.add(r);
    //                 q.add(r);
    //             }
    //             r = wrap(s);
    //             if (!lib.contains(r)) {
    //                 lib.add(r);
    //                 q.add(r);
    //             }
    //         }
    //         i++;
    //     }

    //     List<String> res = new ArrayList<>();
    //     int size = q.size();
    //     for (int j = 0; j < size; j++) {
    //         res.add(q.poll());
    //     }
    //     return res;
    // }

    // ок мое решение немного хуйня, хотя это сразу понятно было, потому что задание на стек

    private static List<String> res;

    private static void run(String s, int o, int c) {
        if (c == 0) {
            res.add(s);
            return;
        }

        if (o != 0) {
            run(s + '(', o - 1, c);
        }
        if (c > o) {
           run(s + ')', o, c - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        run("", n, n);
        return res;
    }

    // runtime 2ms beats 48%. по моему мега простое и аккуратно 

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
