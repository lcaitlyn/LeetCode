import java.util.LinkedHashSet;

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        int [] alphabet = new int[26];

        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
