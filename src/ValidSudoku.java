public class ValidSudoku {

    private static boolean isValidSubBox(char[][] board, int x, int y) {
        int[] set = new int[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] != '.') {
                    if (set[board[i][j] - '0'] > 0) return false;
                    set[board[i][j] - '0']++;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) return false;
            }
        }

        int[][][] set = new int[2][9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set[0][j][board[i][j] - '0'] > 0) return false;
                    set[0][j][board[i][j] - '0']++;
                    if (set[1][i][board[i][j] - '0'] > 0) return false;
                    set[1][i][board[i][j] - '0']++;
                }
            }
        }
        return true;
    }

//    beats 99.62% memory 19.43% runtime 1ms

    public static void main(String[] args) {
        char [][] board;
        board = new char[][] {
                new char[] {'5','3','.','.','7','.','.','.','.'},
                new char[] {'6','.','.','1','9','5','.','.','.'},
                new char[] {'.','9','8','.','.','.','.','6','.'},
                new char[] {'8','.','.','.','6','.','.','.','3'},
                new char[] {'4','.','.','8','.','3','.','.','1'},
                new char[] {'7','.','.','.','2','.','.','.','6'},
                new char[] {'.','6','.','.','.','.','2','8','.'},
                new char[] {'.','.','.','4','1','9','.','.','5'},
                new char[] {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));

        char [][] brokenBoard = new char[][] {
                new char[] {'8','3','.','.','7','.','.','.','.'},
                new char[] {'6','.','.','1','9','5','.','.','.'},
                new char[] {'.','9','8','.','.','.','.','6','.'},
                new char[] {'8','.','.','.','6','.','.','.','3'},
                new char[] {'4','.','.','8','.','3','.','.','1'},
                new char[] {'7','.','.','.','2','.','.','.','6'},
                new char[] {'.','6','.','.','.','.','2','8','.'},
                new char[] {'.','.','.','4','1','9','.','.','5'},
                new char[] {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(brokenBoard));

        board = new char[][] {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }
}
