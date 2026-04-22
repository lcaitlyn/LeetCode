public class CountCoveredBuildings {

    public static int countCoveredBuildings(int n, int[][] buildings) {
        int res = 0;
        int[][] x = new int[n + 1][2];
        int[][] y = new int[n + 1][2];

        for (int[] coord : buildings) {
            if (x[coord[0]][0] == 0) {
                x[coord[0]][0] = coord[1];
                x[coord[0]][1] = coord[1];
            } else {
                x[coord[0]][0] = Math.min(x[coord[0]][0], coord[1]);
                x[coord[0]][1] = Math.max(x[coord[0]][1], coord[1]);
            }

            if (y[coord[1]][0] == 0) {
                y[coord[1]][0] = coord[0];
                y[coord[1]][1] = coord[0];
            } else {
                y[coord[1]][0] = Math.min(y[coord[1]][0], coord[0]);
                y[coord[1]][1] = Math.max(y[coord[1]][1], coord[0]);
            }
        }

        for (int[] coord : buildings) {
            if (x[coord[0]][0] < coord[1] && coord[1] < x[coord[0]][1]
                    && y[coord[1]][0] < coord[0] && coord[0] < y[coord[1]][1]) {
                res++;
            }
        }

        return res;
    }

//    beats 70.53% memory 52.63% runtime 42ms
//    какое-то опять не ординарное решение у меня (в графе где то там в самом маленьких процентах стоит)
//    работает так: я создал массив int[n + 1][2] по линии X где хранятся в int[X][min/max Y]
//    аналогично для линии Y -> int[Y][min/max X]
//    потом беру координату и смотрю по своей карте входит ли она в этот диапазон

    public static void main(String[] args) {
//        System.out.println(countCoveredBuildings(3, new int[][]{{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}}));
        System.out.println(countCoveredBuildings(4, new int[][]{{2,4},{1,2},{3,1},{1,4},{2,3},{3,3},{2,2},{1,3}}));
    }
}
