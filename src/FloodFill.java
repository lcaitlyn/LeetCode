import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {


//    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        Queue<int []> q = new LinkedList<>();
//        int originColor = image[sr][sc];
//        int m = image.length;
//        int n = image[0].length;
//
//        if (color == originColor) return image;
//
//        q.add(new int[]{sr, sc});
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                int [] coords = q.poll();
//                int x = coords[0];
//                int y = coords[1];
//                image[x][y] = color;
//                if (x + 1 < m && image[x+1][y] == originColor) {
//                    q.add(new int[]{x + 1, y});
//                }
//                if (y + 1 < n && image[x][y + 1] == originColor) {
//                    q.add(new int[]{x, y + 1});
//                }
//                if (x - 1 >= 0 && image[x - 1][y] == originColor) {
//                    q.add(new int[]{x - 1, y});
//                }
//                if (y - 1 >= 0 && image[x][y - 1] == originColor) {
//                    q.add(new int[]{x, y - 1});
//                }
//            }
//        }
//        return image;
//    }

//    runtime 1ms beats 45% memory 70%
//    а лол тут предлагают dfs юзать, а я через bfs ебанул

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;

        if (color == originColor) return image;

        image[sr][sc] = color;
        if (sr + 1 < m && image[sr + 1][sc] == originColor) {
            floodFill(image, sr + 1, sc, color);
        }
        if (sc + 1 < n && image[sr][sc + 1] == originColor) {
            floodFill(image, sr, sc + 1, color);
        }
        if (sr - 1 >= 0 && image[sr - 1][sc] == originColor) {
            floodFill(image, sr - 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == originColor) {
            floodFill(image, sr, sc - 1, color);
        }
        return image;
    }

//    beats 100% 0ms, memory 85%
//    ахуеть я сам до такого додумался. Использовал рекурсию и dfs

    public static void main(String[] args) {
        int[][] map;
        map = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(floodFill(map, 1, 1, 2)));
        map = new int[][]{
                {0, 0, 0}, {0, 0, 0}
        };
        System.out.println(Arrays.deepToString(floodFill(map, 0, 0, 0)));
    }
}
