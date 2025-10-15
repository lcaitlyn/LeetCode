public class WordSearch {

    private static boolean finder(char[][] board, int x, int y, String word, int index) {
        if (board[x][y] != word.charAt(index)) return false;

        board[x][y] -= 'A';
        index++;

        if (index == word.length()) return true;

        boolean res = false;
        if (!res && x - 1 >= 0 && finder(board, x - 1, y, word, index)) res = true;
        if (!res && y + 1 < board[0].length && finder(board, x, y + 1, word, index)) res = true;
        if (!res && x + 1 < board.length && finder(board, x + 1, y, word, index)) res = true;
        if (!res && y - 1 >= 0 && finder(board, x, y - 1, word, index)) res = true;

        board[x][y] += 'A';
        return res;
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (finder(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }

//    beats 92.89% 117ms runtime. memory 89.57%
//    ахуеть с первого раза прошло

    public static void main(String[] args) {
        char[][] board;
        board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }
}
