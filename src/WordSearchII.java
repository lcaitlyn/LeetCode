import java.util.*;

public class WordSearchII {

    private static TrieNode root = null;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int size = 0;
        boolean isWord = false;
    }

    private static void add(String word) {
        if (word.isEmpty()) return;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
                node.size++;
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    private static boolean remove(String word, int index, TrieNode node) {
        if (index == word.length()) {
            if (!node.isWord) return false;
            node.isWord = false;
            return node.size == 0;
        }

        TrieNode child = node.children[word.charAt(index) - 'a'];
        if (child == null) return false;

        if (remove(word, index + 1, child)) {
            node.size--;
            node.children[word.charAt(index) - 'a'] = null;
        }
        return node.size == 0 && !node.isWord;
    }

    private static void search(char[][] board, int i, int j, TrieNode node, List<String> list, StringBuilder sb) {
        char c = board[i][j];
        if (c == '#') return;
        node = node.children[c - 'a'];
        if (node == null) return;
        if (node.isWord) {
            list.add(sb.toString());
        }
        board[i][j] = '#';

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int [] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= board.length || nj >= board[0].length || board[ni][nj] == '#') continue;
            if (node.children[board[ni][nj] - 'a'] == null) continue;
            sb.append(board[ni][nj]);
            search(board, ni, nj, node, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        board[i][j] = c;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        Set<String> res = new HashSet<>();

        for (String word : words) add(word);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    List<String> list = new ArrayList<>();
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    search(board, i, j, root, list, sb);
                    for (String s : list) {
                        res.add(s);
                        remove(s, 0, root);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

//    beats 92.15% memory 10.42% runtime 60ms

//    первый варик:
//    beats 15.20% memory 6.23% runtime 857ms
//    крч из советов ГПТ реально который я заметил "⚙️ 5. Нет “обрезания” найденных слов в Trie"
//    ведь рил, я могу удалять просто из моего Trie
//    почему так? это сразу убивает повторы. если в board дохуя одинаковых слов,
//    то первое нахождение уже убьет его из Trie сразу и мы не будем снова его искать. единственное, как это сделать
//    ведь если будут слова pill и pillow, и мы соберемся удалить pill, то тут вроде просто. убираем с последней l
//    isWord = false;
//    и нам нужно откатываться, то последнего true;
//

//    beats 90% memory 6.23% runtime 65ms

//    но вот тут Set<String> res = new HashSet<>();
//    у меня был ArrayList что было логично, Крч у меня рутовое слово не удаляет в remove
//    если сделаю правильно, то такой тест кейс, должен будет отрабатывать правильно
//    board =
//            [["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"],["a","a","a","a","a","a","a","a","a","a","a","a"]]
//
//    words = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

//    подумал тут и решил добавить int size в ноду
//    так будет проще и быстрее удаление, проще чем ходить по всем буквам и чекать на null
//    что на каждом уровне будет давать O(26)

//    переделал итог:
//    beats 92.15% memory 10.42% runtime 60ms

    public static void main(String[] args) {
        char[][] board;
        board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'e', 'a', 't'}
        };
        System.out.println(findWords(board, new String[]{"oath","pea","eat","rain"}));
    }
}
