import java.util.*;

public class PathWithMinimumEffort {

//    public static int minimumEffortPath(int[][] heights) {
//        int n = heights.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        int[][] diffs = new int[n][n];
//        for (int[] diff : diffs) Arrays.fill(diff, Integer.MAX_VALUE);
//        diffs[0][0] = 0;
//        boolean[][] visited = new boolean[n][n];
//        pq.add(new int[]{heights[0][0], 0, 0});
//
//        while (!pq.isEmpty()) {
//            int[] node = pq.poll();
//            int i = node[1];
//            int j = node[2];
//            if (visited[i][j]) continue;
//            visited[i][j] = true;
//
//            if (i + 1 < n) {
//                if (Math.abs(heights[i + 1][j] - heights[i][j]) < diffs[i + 1][j]) {
//                    diffs[i + 1][j] = Math.abs(heights[i + 1][j] - heights[i][j]);
//                    pq.add(new int[]{diffs[i + 1][j], i + 1, j});
//                }
//            }
//            if (j + 1 < n) {
//                if (Math.abs(heights[i][j + 1] - heights[i][j]) < diffs[i][j + 1]) {
//                    diffs[i][j + 1] = Math.abs(heights[i][j + 1] - heights[i][j]);
//                    pq.add(new int[]{diffs[i][j + 1], i, j + 1});
//                }
//            }
//            if (i - 1 >= 0) {
//                if (Math.abs(heights[i - 1][j] - heights[i][j]) < diffs[i - 1][j]) {
//                    diffs[i - 1][j] = Math.abs(heights[i - 1][j] - heights[i][j]);
//                    pq.add(new int[]{diffs[i - 1][j], i - 1, j});
//                }
//            }
//            if (j - 1 >= 0) {
//                if (Math.abs(heights[i][j - 1] - heights[i][j]) < diffs[i][j - 1]) {
//                    diffs[i][j - 1] = Math.abs(heights[i][j - 1] - heights[i][j]);
//                    pq.add(new int[]{diffs[i][j - 1], i, j - 1});
//                }
//            }
//        }
//        return diffs[n - 1][n - 1];
//    }

//    WA [[1,10,6,7,9,10,4,9]]
//    бля я вот че ебал что ли что эта залупа может быть в строчку нах. че за пиздец я в шоке
//    блять я думал мы в матрице работаем пиздец блять
//    и че мне нахуй вторую дейстрку писать чтобы dist[][] обойти? и найти max diff по пути что ли?

//    public static int minimumEffortPath(int[][] heights) {
//        int n = heights.length;
//        int m = heights[0].length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        int[][] diffs = new int[n][m];
//        for (int[] diff : diffs) Arrays.fill(diff, Integer.MAX_VALUE);
//        diffs[0][0] = 0;
//        boolean[][] visited = new boolean[n][m];
//        pq.add(new int[]{heights[0][0], 0, 0});
//
//        while (!pq.isEmpty()) {
//            int[] node = pq.poll();
//            int i = node[1];
//            int j = node[2];
//            if (visited[i][j]) continue;
//            visited[i][j] = true;
//
//            if (i + 1 < n) {
//                if (Math.abs(heights[i + 1][j] - heights[i][j]) < diffs[i + 1][j]) {
//                    diffs[i + 1][j] = Math.max(diffs[i][j], Math.abs(heights[i + 1][j] - heights[i][j]));
//                    pq.add(new int[]{diffs[i + 1][j], i + 1, j});
//                }
//            }
//            if (j + 1 < m) {
//                if (Math.abs(heights[i][j + 1] - heights[i][j]) < diffs[i][j + 1]) {
//                    diffs[i][j + 1] =  Math.max(diffs[i][j], Math.abs(heights[i][j + 1] - heights[i][j]));
//                    pq.add(new int[]{diffs[i][j + 1], i, j + 1});
//                }
//            }
//            if (i - 1 >= 0) {
//                if (Math.abs(heights[i - 1][j] - heights[i][j]) < diffs[i - 1][j]) {
//                    diffs[i - 1][j] =  Math.max(diffs[i][j], Math.abs(heights[i - 1][j] - heights[i][j]));
//                    pq.add(new int[]{diffs[i - 1][j], i - 1, j});
//                }
//            }
//            if (j - 1 >= 0) {
//                if (Math.abs(heights[i][j - 1] - heights[i][j]) < diffs[i][j - 1]) {
//                    diffs[i][j - 1] =  Math.max(diffs[i][j], Math.abs(heights[i][j - 1] - heights[i][j]));
//                    pq.add(new int[]{diffs[i][j - 1], i, j - 1});
//                }
//            }
//        }
//        return diffs[n - 1][m - 1];
//    }

//    beats 10.33% memory 5.96% runtime 97ms
//    пиздец. а че так медленно?(

//    крч почитал советов gpt мб щас че-нибудь и сделаю
//    как минимум с таким приколом
//      int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//      for (int[] d : dirs) {
//         int ni = i + d[0], nj = j + d[1];
//          ...
//      }
//    хотя это просто будет влиять на красоту кода и все
//    ну там и отпимизацию мб добавим


    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length,  m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] diffs = new int[n][m];
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] diff : diffs) Arrays.fill(diff, Integer.MAX_VALUE);
        diffs[0][0] = 0;
        pq.add(new int[]{heights[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int i = node[1], j = node[2];
            if (i == n - 1 && j == m - 1) return node[0]; // update

            for (int [] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                int newDiff = Math.max(diffs[i][j], Math.abs(heights[ni][nj] - heights[i][j]));
                if (newDiff < diffs[ni][nj]) {
                    diffs[ni][nj] = newDiff;
                    pq.add(new int[]{newDiff, ni, nj});
                }
            }
        }
        return diffs[n - 1][m - 1];
    }

//    beats 21.56% memory 5.96% runtime 65ms

//    update
//    beats 41.36% memory 5.95% runtime 47ms
//    почему то я не догадался выйти из цикла если мы уже дошли до нужной нам точки, ведь
//    дальше тупо нету смысла чекать, потому что мы итак чекали самые маленькие

    public static void main(String[] args) {
        int[][] heights;
        heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println("2 -> " + minimumEffortPath(heights));
        heights = new int[][]{
                {1, 2, 3},
                {3,8,4},
                {5,3,5}
        };
        System.out.println("1 -> " + minimumEffortPath(heights));
        heights = new int[][]{
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };
        System.out.println("0 -> " + minimumEffortPath(heights));
        heights = new int[][]{{1,10,6,7,9,10,4,9}};
        System.out.println("9 -> " + minimumEffortPath(heights));
    }
}
