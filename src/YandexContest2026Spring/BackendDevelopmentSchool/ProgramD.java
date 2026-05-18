package YandexContest2026Spring.BackendDevelopmentSchool;

import java.io.*;

//public class ProgramD {
//
//    private static boolean isPair(String s1, String s2) {
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != '?' && s2.charAt(i) != '?' && s1.charAt(i) != s2.charAt(i))
//                return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        String[] lines = s.split(" ");
//        int n = Integer.parseInt(lines[0]);
//
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(br.readLine());
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isPair(list.get(i), list.get(j))) res++;
//            }
//        }
//
//        System.out.println(res);
//    }
//}
//
//public class ProgramD {
//
//    private static class TrieNode {
//        TrieNode[] childs = new TrieNode[27];
//        int count = 0;
//        int sum = 0;
//    }
//
//    private static void add(TrieNode root, String s) {
//        TrieNode cur = root;
//        cur.sum++;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int idx = (c == '?') ? 26 : c - 'a';
//
//            if (cur.childs[idx] == null) cur.childs[idx] = new TrieNode();
//            cur = cur.childs[idx];
//            cur.sum++;
//        }
//
//        cur.count++;
//    }
//
//    private static int count(TrieNode node, String s, int i) {
//        if (node == null) return 0;
//        if (i == s.length()) return node.count;
//
//        char c = s.charAt(i);
//        if (c == '?') return node.sum;
//
//        int res = 0;
//        res += count(node.childs[c - 'a'], s, i + 1);
//        res += count(node.childs[26], s, i + 1);
//
//        return res;
//    }
//
//    public static void main(String[] args) throws IOException {
//        long t1 = System.nanoTime();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        String[] lines = s.split(" ");
//        int n = Integer.parseInt(lines[0]);
//
//        TrieNode root = new TrieNode();
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            s = br.readLine();
//            res += count(root, s, 0);
//            add(root, s);
//        }
//
//        System.out.println(res);
//        long t2 = System.nanoTime();
//        System.out.println((t2 - t1) / 1e6);
//    }
//}


public class ProgramD {

    private static class TrieNode {
        TrieNode[] childs = null;
        int count = 0;

        TrieNode getChild(int i, boolean isNeeded) {
            if (childs == null) {
                if (!isNeeded) return null;
                childs = new TrieNode[27];
            }
            if (childs[i] == null && isNeeded) {
                childs[i] = new TrieNode();
            }
            return childs[i];
        }
    }

    private static void add(TrieNode root, String s) {
        TrieNode curr = root;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int idx = (c == '?') ? 26 : c - 'a';
            curr = curr.getChild(idx, true);
        }
        curr.count++;
    }

    private static int count(TrieNode node, String s, int i) {
        if (node == null) return 0;
        if (i == s.length()) return node.count;

        int res = 0;
        char c = s.charAt(i);

        if (c != '?') {
            int idx = c - 'a';
            if (node.childs != null) {
                if (node.childs[idx] != null) {
                    res += count(node.childs[idx], s, i + 1);
                }if (node.childs[26] != null) {
                    res += count(node.childs[26], s, i + 1);
                }
            }
        } else {
            if (node.childs != null) {
                for (int j = 0; j < 27; j++) {
                    if (node.childs[j] != null) {
                        res += count(node.childs[j], s, i + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] lines = s.split(" ");
        int n = Integer.parseInt(lines[0]);

        TrieNode root = new TrieNode();

        long res = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            res += count(root, word, 0);
            add(root, word);
        }

        System.out.println(res);
    }
}

//public class ProgramD {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(reader.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        // Карта: шаблон -> сколько раз встретился
//        Map<String, Integer> counts = new HashMap<>();
//        String[] patterns = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            patterns[i] = reader.readLine();
//        }
//
//        long totalPairs = 0;
//
//        // Идем с конца в начало или с начала в конец, чтобы считать только пары (i < j)
//        for (int i = n - 1; i >= 0; i--) {
//            String s = patterns[i];
//
//            // 1. Сколько слов, считанных ранее, совместимы с текущим?
//            // Совместимость означает, что существует слово, подходящее под оба шаблона.
//            // Это эквивалентно тому, что текущий шаблон s "покрывает" какой-то набор слов.
//            totalPairs += counts.getOrDefault(s, 0);
//
//            // 2. Генерируем все под-шаблоны текущего слова и добавляем в индекс
//            // Для слова "ab?" это: "ab?", "a??", "?b?", "???"
//            generateAndAdd(s.toCharArray(), 0, counts);
//        }
//
//        System.out.println(totalPairs);
//    }
//
//    private static void generateAndAdd(char[] s, int index, Map<String, Integer> counts) {
//        if (index == s.length) {
//            String sub = new String(s);
//            counts.put(sub, counts.getOrDefault(sub, 1) + 1);
//            return;
//        }
//
//        char original = s[index];
//
//        // Вариант 1: Оставляем символ как есть (будь то буква или '?')
//        generateAndAdd(s, index + 1, counts);
//
//        // Вариант 2: Если это была буква, пробуем заменить её на '?'
//        // (чтобы это слово учитывалось при поиске более общих шаблонов)
//        if (original != '?') {
//            s[index] = '?';
//            generateAndAdd(s, index + 1, counts);
//            s[index] = original; // Возвращаем назад для рекурсии
//        }
//    }
//}
