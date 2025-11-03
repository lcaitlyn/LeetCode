import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
//    https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
//    1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance


//    private static Map<Integer, Map<Integer, Integer>> makeGraph(int[][] edges) {
//        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//        for (int [] edge : edges) {
//            Map<Integer, Integer> from = map.getOrDefault(edge[0], new HashMap<>());
//            Map<Integer, Integer> to = map.getOrDefault(edge[1], new HashMap<>());
//            from.put(edge[1], edge[2]);
//            to.put(edge[0], edge[2]);
//            map.put(edge[0], from);
//            map.put(edge[1], to);
//        }
//        return map;
//    }

//    скинул чату такой варик карты, он сказал что норм, но лучше List<int[]>[]
//    ну ок хули

    private static List<int[]>[] makeGraphMap(int n, int[][] edges) {
        List<int[]>[] map = new ArrayList[n];

        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();

        for (int[] edge : edges) {
            map[edge[0]].add(new int[]{edge[1], edge[2]});
            map[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        return map;
    }

//    private static void dijkstra(List<int[]>[] map, int[] paths, int i, int value) {
//        if (value > paths[i]) return;
//
//        paths[i] = value;
//        for (int[] edge : map[i]) {
//            dijkstra(map, paths, edge[0], paths[i] + edge[1]);
//        }
//    }

    //    блять я его рот шатал нахуй на 53/54 выдасть TLE. хуесос ебаный (n = 100)

//    чатик написал что я со своей рекурсией на Дейкстре ебанулся и она медленная
//    предлагает сделать через Очередь

//    private static void dijkstra(List<int[]>[] map, int[] paths, int i) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        pq.add(new int[]{i, 0});
//
//        while (!pq.isEmpty()) {
//            int[] node = pq.poll();
//
//            for (int [] edge : map[node[0]]) {
//                if (node[1] + edge[1] < paths[edge[0]]) {
//                    paths[edge[0]] = node[1] + edge[1];
//                    pq.add(new int[]{edge[0], paths[edge[0]]});
//                }
//            }
//        }
//    }

//    beats 8.41% memory 6.57% runtime 68ms
//    че дал мне гпт, почему такая хуета:
//    "Когда n <= 100, Флойд-Уоршелл (O(N³)) реально может быть быстрее из-за простоты и отсутствия кучи структур.
//    Он тупо кэш-френдли и линейно идёт по массивам"

//    хотя в хинтах так и написано было

//    предлагает сделать dijkstra жадным, добавив boolean[] visited

//    private static void dijkstra(List<int[]>[] map, int[] paths, int i) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        pq.add(new int[]{i, 0});
//        boolean[] visited = new boolean[paths.length];
//
//        while (!pq.isEmpty()) {
//            int[] node = pq.poll();
//            if (visited[node[0]]) continue;
//            visited[node[0]] = true;
//
//            for (int[] edge : map[node[0]]) {
//                if (node[1] + edge[1] < paths[edge[0]]) {
//                    paths[edge[0]] = node[1] + edge[1];
//                    pq.add(new int[]{edge[0], paths[edge[0]]});
//                }
//            }
//        }
//    }
//
//
//
//    private static int[] findValidNeighbors(List<int[]>[] map, int start, int distanceThreshold) {
//        int[] paths = new int[map.length];
//
//        Arrays.fill(paths, Integer.MAX_VALUE);
//        paths[start] = 0;
//        dijkstra(map, paths, start);
//
//        int count = 0;
//        for (int i = 0; i < map.length; i++) {
//            if (paths[i] != 0 && paths[i] <= distanceThreshold) count++;
//        }
//        return new int[]{start, count};
//    }
//
//
//    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        List<int[]>[] map = makeGraphMap(n, edges);
//        PriorityQueue<int[]> cities = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        for (int i = 0; i < n; i++) {
//            cities.add(findValidNeighbors(map, i, distanceThreshold));
//        }
//        int[] ans = cities.poll();
//        int res = ans[0];
//        while (!cities.isEmpty() && ans[1] == cities.peek()[1]) {
//            ans = cities.poll();
//            res = Math.max(res, ans[0]);
//        }
//        return res;
//    }

//    beats 16.94% memory 5.41% runtime 43ms
//    ну чуть прироста дало. видимо надо переделать всё таки на этот Floyd–Warshall алгос
//
//    private static int[][] floyd(int n, List<int []>[] map) {
//        int[][] dist = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dist[i], Integer.MAX_VALUE);
//            dist[i][i] = 0;
//            for (int [] edge : map[i]) {
//                dist[i][edge[0]] = edge[1];
//            }
//        }
//
//        for (int k = 0; k < n; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
//                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
//                            dist[i][j] = dist[i][k] + dist[k][j];
//                        }
//                    }
//                }
//            }
//        }
//        return dist;
//    }
//
//    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        List<int[]>[] map = makeGraphMap(n, edges);
//        int[][] dist = floyd(n, map);
//
//        int index = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            for (int j = 0; j < n; j++) {
//                if (i == j) continue;
//                if (dist[i][j] <= distanceThreshold) count++;
//            }
//            if (count < min) {
//                min = count;
//                index = i;
//            }
//            if (count == min) index = Math.max(index, i);
//        }
//        return index;
//    }

//    beats 30.47% memory 5.14% runtime 15ms
//    что-то мне ахуенно подсказывает что тут можно и без мапы обойтись и замапить карту во floyde и без мапы

    private static int[][] floyd(int n, int[][] edges) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int [] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        return dist;
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = floyd(n, edges);

        int index = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (dist[i][j] <= distanceThreshold) count++;
            }
            if (count < min) {
                min = count;
                index = i;
            }
            if (count == min) index = Math.max(index, i);
        }
        return index;
    }

//    beats 35.85% memory 5.14% runtime 12ms

    public static void main(String[] args) {
        int[][] edges;
        edges = new int[][]{
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        System.out.println("3 -> " + findTheCity(4, edges, 4));
        edges = new int[][]{
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println("0 -> " + findTheCity(5, edges, 2));
        edges = new int[][]{{0, 3, 5}, {2, 3, 7}, {0, 5, 2}, {0, 2, 5}, {1, 2, 6}, {1, 4, 7}, {3, 4, 4}, {2, 5, 5}, {1, 5, 8}};
        System.out.println("5 -> " + findTheCity(6, edges, 8279));
    }
}
