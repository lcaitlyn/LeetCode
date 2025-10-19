import java.util.Arrays;

public class RedundantConnection {

    private static void union(int set[], int[] rank, int a, int b) {
        if (a != b) {
            int pa = find(set, a);
            int pb = find(set, b);
            if (rank[pa] > rank[pb]) {
                set[pb] = pa;
            } else if (rank[pa] < rank[pb]) {
                set[pa] = pb;
            } else {
                set[pb] = pa;
                rank[pa]++;
            }
        }
    }

    private static int find(int[] set, int a) {
        int res = set[a];
        while (res != set[res]) {
            res = set[res];
        }
        return res;
    }

    private static int[] makeSet(int n) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }
        return set;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] set = makeSet(edges.length + 1);
        int[] rank = new int[edges.length + 1];

        for (int[] edge : edges) {
            if (find(set, edge[1]) == find(set, edge[0])) {
                return edge;
            }
            union(set, rank, edge[0], edge[1]);
        }

        return new int[]{};
    }

//    beats 71% memory 95% 1ms runtime

    public static void main(String[] args) {
        int [][] map;
        map = new int[][] {
                {3,4},
                {1,2},
                {2,4},
                {3,5},
                {2,5}
        };
        System.out.println(Arrays.toString(findRedundantConnection(map)));
    }


}
