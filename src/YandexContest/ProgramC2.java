package YandexContest;

import java.util.*;

public class ProgramC2 {
    private static int find(int[] roots, int a) {
        if (roots[a] != a) roots[a] = find(roots, roots[a]);
        return roots[a];
    }

    private static void union(int[] roots, int a, int b) {
        int rootA = find(roots, a);
        int rootB = find(roots, b);

        if (rootA != rootB) {
            roots[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] roots = new int[n];

        for (int i = 0; i < n; i++) roots[i] = i;

        Map<String, Integer> wordToContexts = new HashMap<>();

        List<String[]> contexts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            String[] words = sc.nextLine().split(" ");
            contexts.add(words);
        }

        for (int i = 0; i < n; i++) {
            String[] words = contexts.get(i);
            for (String w : words) {
                if (!wordToContexts.containsKey(w)) {
                    wordToContexts.put(w, i);
                } else {
                    int j = wordToContexts.get(w);
                    int rootA = find(roots, i);
                    int rootB = find(roots, j);

                    if (rootA != rootB) {
                        union(roots, rootA, rootB);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        for (String w : wordToContexts.keySet()) {
            int root = find(roots, wordToContexts.get(w));
            int size = map.getOrDefault(root, 0) + 1;
            map.put(root, size);
            maxSize = Math.max(maxSize, size);
        }

        System.out.println(map.size() + " " + maxSize);
    }
}
