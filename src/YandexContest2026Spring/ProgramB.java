package YandexContest2026Spring;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramB {

    private static void printMap(int h, int w, char [][] map) {
        System.out.println("<_____________");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
                if (j + 1 != w) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("_____________>");
    }

    private static char[][] getCleanMap(int h, int w, char[][] map) {
        for (int i = 0; i < h; i++) {
            int row = i;
            while (row >= 0) {
                for (int j = 0; j < w; j++) {
                    if (map[row][j] == '0') continue;

                    if (row > 0 && map[row - 1][j] == '0') {
                        map[row - 1][j] = '-';
                        map[row][j] = '0';
                    } else if (row > 0 && j + 1 < w && map[row - 1][j + 1] == '0') {
                        map[row - 1][j + 1] = '-';
                        map[row][j] = '0';
                    } else if (row > 0 && j - 1 >= 0 && map[row - 1][j - 1] == '0') {
                        map[row - 1][j - 1] = '-';
                        map[row][j] = '0';
                    } else {
                        map[row][j] = '-';
                    }
                }
                row--;
                printMap(h, w, map);
            }


        }

        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = Integer.parseInt(sc.nextLine());
        int w = Integer.parseInt(sc.nextLine());
        char[][] map = new char[h][w];

        for (int i = 0; i < h; i++) {
            char[] line = sc.nextLine().toCharArray();
            for (int j = 0, k = 0; j < w; j++, k+=2) {
                map[i][j] = line[k];
            }
        }

//        map = getCleanMap(h, w, map);

//        printMap(h, w, map);

        int[] rocks = new int[w];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[j][i] == '0') rocks[i]++;
            }
        }

        for (int i = 1; i < w; i++) {
            if ()
        }

        System.out.println(Arrays.toString(rocks));

    }
}
