import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private static void dfs(int [][] heights, boolean[][] ocean, int x, int y) {
        if (ocean[x][y]) return;

        ocean[x][y] = true;

        int level = heights[x][y];

        if (y + 1 < ocean[0].length && heights[x][y + 1] >= level) {
            dfs(heights, ocean, x, y + 1);
        }
        if (x + 1 < ocean.length && heights[x + 1][y] >= level) {
            dfs(heights, ocean, x + 1, y);
        }
        if (y - 1 >= 0 && heights[x][y - 1] >= level) {
            dfs(heights, ocean, x, y - 1);
        }
        if (x - 1 >= 0 && heights[x - 1][y] >= level) {
            dfs(heights, ocean, x - 1, y);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int x = 0; x < heights.length; x++) {
            dfs(heights, pacific, x, 0);
            dfs(heights, atlantic, x, heights[0].length - 1);
        }
        for (int y = 0; y < heights[0].length; y++) {
            dfs(heights, pacific, 0, y);
            dfs(heights, atlantic, heights.length - 1, y);
        }

        for (int x = 0; x < heights.length; x++) {
            for (int y = 0; y < heights[0].length; y++) {
                if (pacific[x][y] && atlantic[x][y]) {
                    result.add(List.of(x, y));
                }
            }
        }

        return result;
    }

//    beats 98% 4ms runtime. memory 98%. С первого раза решил 🥳
//    (ну там конечно гпт помог подсказкой, что нужно идти вверх, а не искать самый верх и спускаться вниз)

    public static void main(String[] args) {

    }
}
