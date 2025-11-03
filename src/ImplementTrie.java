import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

//    private static class Trie {
//
//        private static class TrieNode {
//            Map<Character, TrieNode> children = new HashMap<>();
//            boolean isEnd = false;
//        }
//
//        private final TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public void insert(String word) {
//            TrieNode node = root;
//            for (char c : word.toCharArray()) {
//                node.children.putIfAbsent(c, new TrieNode());
//                node = node.children.get(c);
//            }
//            node.isEnd = true;
//        }
//
//        public boolean search(String word) {
//            TrieNode node = root;
//            for (char c : word.toCharArray()) {
//                node = node.children.get(c);
//                if (node == null) return false;
//            }
//            return node.isEnd;
//        }
//
//        public boolean startsWith(String prefix) {
//            TrieNode node = root;
//            for (char c : prefix.toCharArray()) {
//                node = node.children.get(c);
//                if (node == null) return false;
//            }
//            return true;
//        }
//    }

//  beats 29.03% memory 5.40% runtime 41ms
//  наверное при помощи массивов быстрее скорости добывается

    private static class Trie {

        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) return false;
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) return false;
            }
            return true;
        }
    }

//    beats 100% memory 5.40% runtime 28s
//    ппц чет быстренько (ср.значение 32ms)

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        System.out.println(obj.search("word"));
        System.out.println(obj.search("hello"));
        System.out.println(obj.startsWith("wo"));
        System.out.println(obj.startsWith("he"));
    }
}
