import java.util.Arrays;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        // rw = right wall, dw = down wall и остальные соответственно...
        int rw = n, dw = n, lw = -1, uw = 0;

        for (int cur = 1, i; cur <= n * n;) {
            // вправо
            i = lw + 1;
            while (i < rw) {
                arr[uw][i] = cur;
                i++;
                cur++;
            }
            rw--;

            // вниз
            i = uw + 1;
            while (i < dw) {
                arr[i][rw] = cur;
                cur++;
                i++;
            }
            dw--;

            // влево
            i = rw - 1;
            while (i > lw) {
                arr[dw][i] = cur;
                cur++;
                i--;
            }
            lw++;

            // вверх
            i = dw - 1;
            while (i > uw) {
                arr[i][lw] = cur;
                cur++;
                i--;
            }
            uw++;
        }

        return arr;
    }

    // beats 100%. 0ms пиздец че то долго делал. только посмотрев в ответы увидел что там со стенами какое-то решение
    // сам его и реализовал. крч выставил невидимые стены и сужал в центр их по мере прохождения

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }
}
