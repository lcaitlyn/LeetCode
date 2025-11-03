import java.sql.Array;
import java.util.*;

public class NetworkDelayTime {

    private static List<int[]>[] makeGraph(int[][] times, int n) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] time : times) {
            graph[time[0] - 1].add(new int[]{time[1] - 1, time[2]});
        }

        return graph;
    }

    private static int[] dijkstra(List<int[]>[] graph, int n, int index) {
        int[] dist = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[index] = 0;
        pq.add(new int[]{index, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            for (int[] time : graph[node[0]]) {
                if (node[1] + time[1] < dist[time[0]]) {
                    dist[time[0]] = node[1] + time[1];
                    pq.add(new int[]{time[0], node[1] + time[1]});
                }
            }
        }
        return dist;
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<int []>[] graph = makeGraph(times, n);

        int[] dist = dijkstra(graph, n, k - 1);
        int ans = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

//    beats 31.32% memory 24.19% runtime 17ms
//    с первого раза нах сдал. пиздец круто че?)
    
    public static void main(String[] args) {
        int [][] times;
        times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println("2 -> " + networkDelayTime(times, 4, 2));

        times = new int[][]{{1,2,1}};
        System.out.println("1 -> " + networkDelayTime(times, 2, 1));

        times = new int[][]{{1,2,1}};
        System.out.println("-1 -> " + networkDelayTime(times, 2, 2));
    }
}
