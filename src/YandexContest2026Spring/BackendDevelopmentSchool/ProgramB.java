package YandexContest2026Spring.BackendDevelopmentSchool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ProgramB {

    private static String find(Map<String, String> root, String x) {
        if (!root.get(x).equals(x)) {
            root.put(x, find(root, root.get(x)));
        }
        return root.get(x);
    }

    private static boolean union(Map<String, String> root, Map<String, Integer> map, String a, String b) {
        a = find(root, a);
        b = find(root, b);

        if (a.equals(b)) return true;

        Integer x = map.get(a);
        Integer y = map.get(b);

        root.put(b, a);

        if (x == null) {
            map.put(a, y);
        } else if (y != null && !x.equals(y)) {
            return false;
        }
        return true;
    }

    private static boolean set(Map<String, String> root, Map<String, Integer> map, String key, int value) {
        key = find(root, key);

        Integer cur = map.get(key);
        if (cur == null) {
            map.put(key, value);
            return true;
        }
        return cur == value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = Integer.parseInt(s);

        Map<String, String> root = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        String[] a = new String[n];
        String[] b = new String[n];

        s = br.readLine();
        String[] lines = s.split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = lines[i];
        }

        lines = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = lines[i];
        }

        for (int i = 0; i < n; i++) {
            boolean isANum = Character.isDigit(a[i].charAt(0));
            boolean isBNum = Character.isDigit(b[i].charAt(0));

            if (isANum && isBNum) {
                if (!a[i].equals(b[i])) {
                    System.out.println("NO");
                    return;
                }
                continue;
            }

            if (!isANum) {
                root.putIfAbsent(a[i], a[i]);
                map.putIfAbsent(a[i], null);
            }
            if (!isBNum) {
                root.putIfAbsent(b[i], b[i]);
                map.putIfAbsent(b[i], null);
            }

            if (!isANum && !isBNum) {
                if (!union(root, map, a[i], b[i])) {
                    System.out.println("NO");
                    return;
                }
            } else if (!isANum) {
                if (!set(root, map, a[i], Integer.parseInt(b[i]))) {
                    System.out.println("NO");
                    return;
                }
            } else {
                if (!set(root, map, b[i], Integer.parseInt(a[i]))) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}