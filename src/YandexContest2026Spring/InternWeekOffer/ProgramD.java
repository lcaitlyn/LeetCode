import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;

public class ProgramD {

    private final static JSONParser parser = new JSONParser();

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean isJSON(String s) {
        try {
            Object obj = parser.parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        char[] arr = s.toCharArray();

        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '"') {
                int j = i + 1;
                while (j < n) {
                    if (arr[j] == '"') break;
                    j++;
                }
                if (j < n) intervals.add(new Interval(i, j + 1));
            } else if (c == '{' || c == '[') {
                Deque<Character> stack = new ArrayDeque<>();
                stack.push(c);
                int j = i + 1;
                while (j < n && !stack.isEmpty()) {
                    char ch = arr[j];
                    if (ch == '"') {
                        j++;
                        while (j < n) {
                            if (arr[j] == '"') break;
                            j++;
                        }
                    } else if (ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if ((ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '[')) {
                        stack.pop();
                    }
                    j++;
                }
                if (stack.isEmpty()) intervals.add(new Interval(i, j));
            } else if (c == '-' || Character.isDigit(c)) {
                int j = i;
                if (arr[j] == '-') j++;
                while (j < n && Character.isDigit(arr[j])) j++;
                intervals.add(new Interval(i, j));
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a.end));

        int m = intervals.size();

        int[] p = new int[m];
        Arrays.fill(p, -1);
        for (int i = 0; i < m; i++) {
            int l = 0, r = i - 1, res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (intervals.get(mid).end <= intervals.get(i).start) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            p[i] = res;
        }

        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            int len = intervals.get(i).end - intervals.get(i).start;
            if (p[i] != -1) len += dp[p[i]];
            dp[i] = i > 0 ? Math.max(dp[i - 1], len) : len;
        }

        List<Interval> res = new ArrayList<>();
        for (int i = m - 1; i >= 0;) {
            int len = intervals.get(i).end - intervals.get(i).start;
            if (p[i] != -1) len += dp[p[i]];
            if (i == 0 || dp[i] != dp[i - 1]) {
                res.add(intervals.get(i));
                i = p[i] != -1 ? p[i] : -1;
            } else {
                i--;
            }
        }

        int total = 0;
        for (Interval v : res) {
            total += v.end - v.start;
        }

        System.out.println(res.size() + " " + total);
        for (Interval v : res) {
            System.out.println(v.start + " " + v.end);
        }
    }
}