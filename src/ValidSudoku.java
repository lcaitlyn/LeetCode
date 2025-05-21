import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    
    public static boolean isValidSudoku(char[][] board) {
        
        int length = 9
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Set<Character> set = new HashSet<>();
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        char [][] board = new char[][] {
            new char[] {"5","3",".",".","7",".",".",".","."},
            new char[] {"6",".",".","1","9","5",".",".","."},
            new char[] {".","9","8",".",".",".",".","6","."},
            new char[] {"8",".",".",".","6",".",".",".","3"},
            new char[] {"4",".",".","8",".","3",".",".","1"},
            new char[] {"7",".",".",".","2",".",".",".","6"},
            new char[] {".","6",".",".",".",".","2","8","."},
            new char[] {".",".",".","4","1","9",".",".","5"},
            new char[] {".",".",".",".","8",".",".","7","9"}
        };

        char [][] brokenBoard = new char[][] {
            new char[] {"8","3",".",".","7",".",".",".","."},
            new char[] {"6",".",".","1","9","5",".",".","."},
            new char[] {".","9","8",".",".",".",".","6","."},
            new char[] {"8",".",".",".","6",".",".",".","3"},
            new char[] {"4",".",".","8",".","3",".",".","1"},
            new char[] {"7",".",".",".","2",".",".",".","6"},
            new char[] {".","6",".",".",".",".","2","8","."},
            new char[] {".",".",".","4","1","9",".",".","5"},
            new char[] {".",".",".",".","8",".",".","7","9"}
        };

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(brokenBoard));
    }
}
