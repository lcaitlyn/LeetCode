package YandexContest;

import java.util.*;

public class ProgramC {
    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] roots, Set<String>[] wordsSets, int a, int b) {
        int rootA = find(roots, a);
        int rootB = find(roots, b);
        if (rootA == rootB) return;

        if (wordsSets[rootA].size() < wordsSets[rootB].size()) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        roots[rootB] = rootA;
        wordsSets[rootA].addAll(wordsSets[rootB]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] roots = new int[n];
        Set<String>[] wordsSets = new HashSet[n];

        for (int i = 0; i < n; i++) roots[i] = i;

        Map<String, List<Integer>> wordToContexts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            String[] words = sc.nextLine().split(" ");
            wordsSets[i] = new HashSet<>(Arrays.asList(words));
            for (String w : words) {
                List<Integer> list = wordToContexts.getOrDefault(w, new ArrayList<>());
                list.add(i);
                wordToContexts.put(w, list);
            }
        }

        for (List<Integer> list : wordToContexts.values()) {
            int first = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                union(roots, wordsSets, first, list.get(i));
            }
        }

        Set<Integer> set = new HashSet<>();
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            int root = find(roots, i);
            if (set.add(root)) {
                maxSize = Math.max(maxSize, wordsSets[root].size());
            }
        }

        System.out.println(set.size() + " " + maxSize);
    }
}
