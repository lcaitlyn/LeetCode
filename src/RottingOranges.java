import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private static int rec(int[][] grid, Queue<int[]> q) {
        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int [] orange = q.poll();
                int x = orange[0];
                int y = orange[1];
                grid[x][y] = 0;

                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 0;
                    q.add(new int[]{x, y + 1});
                }


                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 0;
                    q.add(new int[]{x + 1, y});
                }

                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 0;
                    q.add(new int[]{x, y - 1});

                }

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 0;
                    q.add(new int[]{x - 1, y});
                }
            }
            time++;
        }
        return time;
    }

    public static int orangesRotting(int[][] grid) {
        int res = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (!q.isEmpty())
            res = rec(grid, q);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return res;
    }

//    блять самая уебанская задача. тупо каждый тест кейс говна ебаного
//    пиздец я щас в тильте буду нахуй

//    beats 65% memory 50%

    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
//        System.out.println(orangesRotting(grid));
        grid = new int[][] {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
//        System.out.println(orangesRotting(grid));
        grid = new int[][]{
                {0, 2}
        };
//        System.out.println(orangesRotting(grid));
        grid = new int[][]{
                {1, 2}
        };
//        System.out.println(orangesRotting(grid));
        grid = new int[][] {
                {2,1,1},
                {1,1,1},
                {0,1,2}
        };
//        System.out.println(orangesRotting(grid));
        grid = new int[][] {
                {2,2},
                {1,1},
                {0,0},
                {2,0}
        };
        System.out.println(orangesRotting(grid));
    }

}
