public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (i == j)
                sum += mat[i][i];
            else
                sum += mat[i][i] + mat[i][j];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
