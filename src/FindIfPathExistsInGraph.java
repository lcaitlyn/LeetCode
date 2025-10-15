import java.util.*;

public class FindIfPathExistsInGraph {

//    private static boolean visit(int[][] edges, int[] map, int src, int dst) {
//        if (src == dst) return true;
//
//        if (map[src] != 0) return false;
//
//        map[src]++;
//        for (int i = 0; i < edges.length; i++) {
//            if (edges[i][0] == src) {
//                if (visit(edges, map, edges[i][1], dst)) return true;
//            }
//            if (edges[i][1] == src) {
//                if (visit(edges, map, edges[i][0], dst)) return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        return visit(edges, new int[n], source, destination);
//    }

//    тут рабочий, но TLE выдал на 24/34 тесте (n = 20000)
//    чат предложил сделать список соседей Map<Integer, List<Integer>> neighbors

//    private static boolean visit(Map<Integer, List<Integer>> neighbors, int[] map, int src, int dst) {
//        map[src]++;
//        for (int i : neighbors.get(src)) {
//            if (i == dst) return true;
//
//            if (map[i] != 0) continue;
//
//            if (visit(neighbors, map, i, dst)) return true;
//        }
//        return false;
//    }
//
//    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        if (source == destination) return true;
//
//        Map<Integer, List<Integer>> neighbors = new HashMap<>();
//
//        for (int i = 0; i < edges.length; i++) {
//            List<Integer> list;
//            list = neighbors.getOrDefault(edges[i][0], new ArrayList<>());
//            list.add(edges[i][1]);
//            neighbors.put(edges[i][0], list);
//            list = neighbors.getOrDefault(edges[i][1], new ArrayList<>());
//            list.add(edges[i][0]);
//            neighbors.put(edges[i][1], list);
//        }
//
//        return visit(neighbors, new int[n], source, destination);
//    }

//    beats 15% 265ms runtime 😢 memory 29%
//    пиздец ну и медленная хуетень

//    private static boolean visit(Map<Integer, List<Integer>> neighbors, int[] map, int src, int dst) {
//        map[src]++;
//
//        if (neighbors.get(src).contains(dst)) return true;
//
//        for (int i : neighbors.get(src)) {
//            if (i == dst) return true;
//
//            if (map[i] != 0) continue;
//
//            if (visit(neighbors, map, i, dst)) return true;
//        }
//        return false;
//    }
//
//    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        if (source == destination) return true;
//
//        Map<Integer, List<Integer>> neighbors = new HashMap<>();
//
//        for (int i = 0; i < edges.length; i++) {
//            List<Integer> list;
//            list = neighbors.getOrDefault(edges[i][0], new ArrayList<>());
//            list.add(edges[i][1]);
//            neighbors.put(edges[i][0], list);
//            list = neighbors.getOrDefault(edges[i][1], new ArrayList<>());
//            list.add(edges[i][0]);
//            neighbors.put(edges[i][1], list);
//        }
//
//        return visit(neighbors, new int[n], source, destination);
//    }

//    beats 23% 188ms memory 48%
//    добавил такое:
//    if (neighbors.get(src).contains(dst)) return true;
//

//    private static boolean visit(Map<Integer, List<Integer>> map, int n, int src, int dst) {
//        boolean[] visited = new boolean[n];
//        Queue<Integer> q = new LinkedList<>();
//
//        q.add(src);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                int key = q.poll();
//
//                visited[key] = true;
//
//                for (int neighbor : map.get(key)) {
//                    if (neighbor == dst) return true;
//
//                    if (visited[neighbor]) continue;
//
//                    q.add(neighbor);
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        if (source == destination) return true;
//
//        Map<Integer, List<Integer>> neighbors = new HashMap<>();
//
//        for (int i = 0; i < edges.length; i++) {
//            List<Integer> list;
//            list = neighbors.getOrDefault(edges[i][0], new ArrayList<>());
//            list.add(edges[i][1]);
//            neighbors.put(edges[i][0], list);
//            list = neighbors.getOrDefault(edges[i][1], new ArrayList<>());
//            list.add(edges[i][0]);
//            neighbors.put(edges[i][1], list);
//        }
//
//        return visit(neighbors, n, source, destination);
//    }

//    beats 35% runtime 156ms memory 71%
//    сделал BFS, стало чуть быстрее
//    это мой изначальный варик BFS, еще немного по изменял его по советам ГПТ, стало чуть медленее . Щас вернул в изначальный вид
//    вопрос - как сделать быстрее?) наверное стэк


//    private static void union(int[] map, int[] rank, int a, int b) {
//        if (a != b) {
//            int parentA = find(map, a);
//            int parentB = find(map, b);
//            map[parentB] = parentA;
//        }
//    }
//
//    private static int find(int[] map, int i) {
//        while (i != map[i]) {
//            i = map[i];
//        }
//        return i;
//    }
//
//    private static int[] makeSet(int n) {
//        int[] map = new int[n];
//        for (int i = 0; i < map.length; i++) {
//            map[i] = i;
//        }
//        return map;
//    }
//
//    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        int[] map = makeSet(n);
//        int[] rank = new int[n];
//
//        for (int[] edge : edges) {
//            union(map, rank, edge[0], edge[1]);
//        }
//
//        return  (find(map, source) == find(map, destination));
//    }

//    beats 5% memory 99.5%
//    реализовал DSU (union find). Ахуенно медленная залупа. зато по памяти ебет

    private static void union(int[] map, int[] rank, int a, int b) {
        if (a != b) {
            int parentA = find(map, a);
            int parentB = find(map, b);
            if (rank[parentA] < rank[parentB]) {
                map[parentA] = parentB;
            } else if (rank[parentA] > rank[parentB]) {
                map[parentB] = parentA;
            } else {
                map[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    private static int find(int[] map, int i) {
        while (i != map[i]) {
            i = map[i];
        }
        return i;
    }

    private static int[] makeSet(int n) {
        int[] map = new int[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = i;
        }
        return map;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] map = makeSet(n);
        int[] rank = new int[n];

        for (int[] edge : edges) {
            union(map, rank, edge[0], edge[1]);
        }

        return (find(map, source) == find(map, destination));
    }

//    beats 98.45%, 13ms memory 96.9%
//    пиздец чуть чуть изменил код предыдущим (добавил всего лишь ранги) и так сильно все поменялось нахуй

    public static void main(String[] args) {
//        System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
