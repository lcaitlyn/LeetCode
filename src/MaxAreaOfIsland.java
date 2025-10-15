public class MaxAreaOfIsland {
    private static int paintIslandVisited(int[][] map, int sr, int sc) {
        int size = 1;
        int n = map.length;
        int m = map[0].length;

        map[sr][sc] = 0;
        if (sr + 1 < n && map[sr + 1][sc] == 1) {
            size += paintIslandVisited(map, sr + 1, sc);
        }
        if (sc + 1 < m && map[sr][sc + 1] == 1) {
            size += paintIslandVisited(map, sr, sc + 1);
        }
        if (sr - 1 >= 0 && map[sr - 1][sc] == 1) {
            size += paintIslandVisited(map, sr - 1, sc);
        }
        if (sc - 1 >= 0 && map[sr][sc - 1] == 1) {
            size += paintIslandVisited(map, sr, sc - 1);
        }

        return size;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, paintIslandVisited(grid, i, j));
                }
            }
        }
        return max;
    }

    // beats 100% runtime 1ms memory 60%
//     ахуеенно. но тут просто по аналогии с задачей №200. Number Of Islands

    public static void main(String[] args) {
        int [][] grid;
        grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
