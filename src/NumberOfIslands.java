import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    //    использую сейчас тут bfs. мб заменить на dfs
//    private static void paintIslandVisited(char[][] map, int sr, int sc) {
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{sr, sc});
//        int n = map.length;
//        int m = map[0].length;
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                int[] coords = q.poll();
//                int x = coords[0];
//                int y = coords[1];
//                map[x][y] = 'z';
//                if (x + 1 < n && map[x + 1][y] == '1') {
//                    q.add(new int[]{x + 1, y});
//                }
//                if (y + 1 < m && map[x][y + 1] == '1') {
//                    q.add(new int[]{x, y + 1});
//                }
//                if (x - 1 >= 0 && map[x - 1][y] == '1') {
//                    q.add(new int[]{x - 1, y});
//                }
//                if (y - 1 >= 0 && map[x][y - 1] == '1') {
//                    q.add(new int[]{x, y - 1});
//                }
//            }
//        }
//    }
//
//    public static int numIslands(char[][] grid) {
//        int res = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '1') {
//                    paintIslandVisited(grid, i, j);
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

//    алгос работает но TLE на вот таком вот примере:
//            [["1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","0","1","0","1","1"],
//            ["0","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","0"],
//            ["1","0","1","1","1","0","0","1","1","0","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","0","1","1","1","1","1","1","0","1","1","1","0","1","1","1","0","1","1","1"],
//            ["0","1","1","1","1","1","1","1","1","1","1","1","0","1","1","0","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["0","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","0","1","1","1","1","1","1","1","0","1","1","1","1","1","1"],
//            ["1","0","1","1","1","1","1","0","1","1","1","0","1","1","1","1","0","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","0"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","0"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
//            ["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]

//    ну оно нахуй и понятно. потому что я хожу за O(n^2) как минимум блять в основной функции
//    из отпимизаций вижу 2 способа пока: 1 . переделать на dfs 2. прыгать по y
//
//    private static void paintIslandVisited(char[][] map, int sr, int sc) {
//        int n = map.length;
//        int m = map[0].length;
//
//        map[sr][sc] = 'z';
//        if (sr + 1 < n && map[sr + 1][sc] == '1') {
//            paintIslandVisited(map, sr + 1, sc);
//        }
//        if (sc + 1 < m && map[sr][sc + 1] == '1') {
//            paintIslandVisited(map, sr, sc + 1);
//        }
//        if (sr - 1 >= 0 && map[sr - 1][sc] == '1') {
//            paintIslandVisited(map, sr - 1, sc);
//        }
//        if (sc - 1 >= 0 && map[sr][sc - 1] == '1') {
//            paintIslandVisited(map, sr, sc - 1);
//        }
//        return Math.max(sc, y);
//    }
//
//    public static int numIslands(char[][] grid) {
//        int res = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '1') {
//                    paintIslandVisited(grid, i, j);
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

//    beats 84.62% runtime 3ms. Memory 62%  Да, DFS быстрее нахуй
//    интересно если я все таки реализую тему с прыжками по Y че будет

    private static int paintIslandVisited(char[][] map, int sr, int sc) {
        int y = sc;
        int n = map.length;
        int m = map[0].length;

        map[sr][sc] = 'z';
        if (sr + 1 < n && map[sr + 1][sc] == '1') {
            paintIslandVisited(map, sr + 1, sc);
        }
        if (sc + 1 < m && map[sr][sc + 1] == '1') {
            y = paintIslandVisited(map, sr, sc + 1);
        }
        if (sr - 1 >= 0 && map[sr - 1][sc] == '1') {
            paintIslandVisited(map, sr - 1, sc);
        }
        if (sc - 1 >= 0 && map[sr][sc - 1] == '1') {
            paintIslandVisited(map, sr, sc - 1);
        }
        return Math.max(sc, y);
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    j = paintIslandVisited(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

//    beats 99% 2ms memory 40%. ну да прыжки явно ускорили

    public static void main(String[] args) {
        char[][] grid;
        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
        grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
}
