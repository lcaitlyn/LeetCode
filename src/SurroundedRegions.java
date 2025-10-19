public class SurroundedRegions {


//    private void dfs(char [][]board, int x, int y, char color, char newColor) {
//        if (board[x][y] != color) return;
//
//        board[x][y] = newColor;
//
//        if (y + 1 < board[0].length && board[x][y + 1] == color) {
//            dfs(board, x, y + 1, color, newColor);
//        }
//        if (x + 1 < board.length && board[x + 1][y] == color) {
//            dfs(board, x + 1, y, color, newColor);
//        }
//        if (y - 1 >= 0 && board[x][y - 1] == color) {
//            dfs(board, x, y - 1, color, newColor);
//        }
//        if (x - 1 >=0 && board[x - 1][y] == color) {
//            dfs(board, x - 1, y, color, newColor);
//        }
//    }
//
//    public void solve(char[][] board) {
//        if (board.length < 3 || board[0].length < 3) return;
//
//        for (int y = 0; y < board[0].length; y++) {
//            if (board[0][y] == 'O') dfs(board, 0, y, 'O', 'Z');
//        }
//        for (int x = 0; x < board.length; x++) {
//            if (board[x][0] == 'O') dfs(board, x, 0, 'O', 'Z');
//        }
//        for (int y = 0; y < board[0].length; y++) {
//            if (board[board.length - 1][y] == 'O') dfs(board, board.length - 1, y, 'O', 'Z');
//        }
//        for (int x = 0; x < board.length; x++) {
//            if (board[x][board[0].length - 1] == 'O') dfs(board, x, board[0].length - 1, 'O', 'Z');
//        }
//
//        for (int x = 1; x < board.length - 1; x++) {
//            for (int y = 1; y < board[0].length - 1; y++) {
//                if (board[x][y] == 'O') dfs(board, x, y, 'O', 'X');
//            }
//        }
//
//        for (int x = 0; x < board.length; x++) {
//            for (int y = 0; y < board[0].length; y++) {
//                if (board[x][y] == 'Z') dfs(board, x, y, 'Z', 'O');
//            }
//        }
//    }

//    beats 30.7% 3ms runtime memory 5%.
//    крч я тут наебланил. сперва код прочитал. крч я начал попутал немного решение
//    а потом код не захотелось переписывать, чуть его изменил, на то чтобы он цвета закрашивал
//    и в итоге сделал, чтобы те что не нужно перекрашивать, я перекрасил в 'Z'. а потом обратно.
//    бля вот пока текст выше писал додумался как можно было чуть по легче сделать.
//    я мог просто нахуй вторую карту ввести с в неё внести адекватные
//    а потом снова по 'O' пройтись и те что не true (которые не ведут к стене), то их уже зачеркивать
//    ща реализую мб. блять чай просто хочеться пить( я итак чаепитие скипнул чтобы решить это

    private void finderDfs(char [][]board, boolean[][] map, int x, int y) {
        if (map[x][y]) return;

        map[x][y] = true;

        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            finderDfs(board, map, x, y + 1);
        }
        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            finderDfs(board, map, x + 1, y);
        }
        if (y - 1 >= 0 && board[x][y - 1] == 'O') {
            finderDfs(board, map, x, y - 1);
        }
        if (x - 1 >=0 && board[x - 1][y] == 'O') {
            finderDfs(board, map, x - 1, y);
        }
    }

    private void dfs(char [][]board, int x, int y, char color, char newColor) {
        if (board[x][y] != color) return;

        board[x][y] = newColor;

        if (y + 1 < board[0].length && board[x][y + 1] == color) {
            dfs(board, x, y + 1, color, newColor);
        }
        if (x + 1 < board.length && board[x + 1][y] == color) {
            dfs(board, x + 1, y, color, newColor);
        }
        if (y - 1 >= 0 && board[x][y - 1] == color) {
            dfs(board, x, y - 1, color, newColor);
        }
        if (x - 1 >=0 && board[x - 1][y] == color) {
            dfs(board, x - 1, y, color, newColor);
        }
    }

    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) return;

        boolean[][] map = new boolean[board.length][board[0].length];

        for (int y = 0; y < board[0].length; y++) {
            if (board[0][y] == 'O') finderDfs(board, map, 0, y);
        }
        for (int x = 0; x < board.length; x++) {
            if (board[x][0] == 'O') finderDfs(board, map, x, 0);
        }
        for (int y = 0; y < board[0].length; y++) {
            if (board[board.length - 1][y] == 'O')  finderDfs(board, map, board.length - 1, y);
        }
        for (int x = 0; x < board.length; x++) {
            if (board[x][board[0].length - 1] == 'O')  finderDfs(board, map, x, board[0].length - 1);
        }

        for (int x = 1; x < board.length - 1; x++) {
            for (int y = 1; y < board[0].length - 1; y++) {
                if (board[x][y] == 'O' && !map[x][y]) dfs(board, x, y, 'O', 'X');
            }
        }
    }

//    ахуенно такой же результат блять. пиздец

    public static void main(String[] args) {

    }
}
