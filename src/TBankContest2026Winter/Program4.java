package TBankContest2026Winter;

import java.util.*;

public class Program4 {

    private static int findMinCycle(List<Integer>[] graph, int n) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            int[] root = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(root, -1);

            Queue<Integer> q = new LinkedList<>();
            dist[i] = 0;
            q.add(i);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        root[v] = u;
                        q.add(v);
                    } else if (root[u] != v) {
                        res = Math.min(res, dist[u] + dist[v] + 1);
                    }
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? - 1 : res;
    }

    private static List<Integer>[] makeGraph(List<String[]> list, int n) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (String [] str : list) {
            graph[Integer.parseInt(str[0]) - 1].add(Integer.parseInt(str[1]) - 1);
        }

        return graph;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        List<String []> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.nextLine().split(" "));
        }

        List<Integer>[] graph = makeGraph(list, n);

        System.out.println(findMinCycle(graph, n));
    }
}
