import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     Map<Character, Integer> map = new HashMap<>();

    //     for (char c : magazine.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }

    //     for (char c : ransomNote.toCharArray()) {
    //         Integer i = map.get(c);

    //         if (i == null || i <= 0) return false;

    //         map.put(c, i - 1);
    //     }

    //     return true;
    // }

    // Результат: 10ms beats 59%, memory beats 19%
    // ну поменяю наверное с мапы на array

    public boolean canConstruct(String ransomNote, String magazine) {
        int [] arr = new int[26];

        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (arr[c - 'a'] <= 0) return false;
            arr[c - 'a']--;
        }

        return true;
    }

    // runtime 2ms , beats 89% memory beats 70%
    
    public static void main(String[] args) {
        
    }
}
