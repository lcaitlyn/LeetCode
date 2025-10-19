import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    private static void union(int[] map, int[] rank, int a, int b) {
        if (a != b) {
            int pa = find(map, a);
            int pb = find(map, b);
            if (rank[pa] < rank[pb]) {
                map[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                map[pb] = pa;
            } else {
                map[pa] = pb;
                rank[pa]++;
            }
        }
    }

    private static int find(int[] map, int i) {
        while (map[i] != i)
            i = map[i];
        return i;
    }

    private static int[] makeSet(int n) {
        int[] map = new int[n];
        for (int i = 0; i < n; i++)
            map[i] = i;
        return map;
    }

    public static int findCircleNum(int[][] isConnected) {
        int[] map = makeSet(isConnected.length);
        int[] rank = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 0) continue;

                if (isConnected[i][i] > 0 && isConnected[i][j] > 0)
                    union(map, rank, i, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i : map) {
            set.add(find(map, i));
        }
        return set.size();
    }

//    beats 33% 3ms, memory 29.88% (upd beats 87%, 1ms, memory 5%)
//    наверное DFS быстрее был бы, но такой задачи не стояло. стояла задача тренировки над union-find (DSU)
//    а нет я просто еблан. написал вот эту строку не правильно:
//    map[pa] = pb;
//    rank[pa]++;
//    а должно было бы быть:
//    map[pb] = pa;
//    rank[pa]++;
//    итог: beats 87%, 1ms runtim, memory 5%. Так что всё нормик

    public static void main(String[] args) {
        int[][] map;
        map = new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
//        System.out.println(findCircleNum(map));
        map = new int[][] {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
//        System.out.println(findCircleNum(map));
        map = new int[][] {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(findCircleNum(map));
    }
}
