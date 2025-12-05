package YandexContest;

import java.util.*;

public class ProgramA2 {

    static List<List<Integer>> graph;
    static int[] values;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        values = new int[n];
        for (int i = 0; i < n; i++) values[i] = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a); // если граф ориентированный, убрать эту строку
        }

        long maxSum = 0;
        visited = new boolean[n];

        // пробуем запустить DFS из каждой вершины
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dfs(i));
        }

        System.out.println(maxSum);
    }

    // DFS: посещаем вершину один раз и идём только по одному пути
    static long dfs(int node) {
        visited[node] = true;

        long maxChild = 0;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                long childSum = dfs(nei);
                if (childSum > maxChild) maxChild = childSum;
            }
        }

        visited[node] = false; // снимаем отметку для других стартов
        return values[node] + maxChild;
    }
}
