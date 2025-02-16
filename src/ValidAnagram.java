import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        // if (s.length() != t.length()) return false;

        // Map<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);

        //     if (a != b) {
        //         Integer am = map.get(a);
        //         map.put(a, (am == null) ? 1 : am + 1);
        //         if (map.get(a).intValue() == 0) {
        //             map.remove(a);
        //         } 

        //         Integer bm = map.get(b);
        //         map.put(b, (bm == null) ? -1 : bm - 1);
        //         if (map.get(b).intValue() == 0) {
        //             map.remove(b);
        //         } 
        //     }
        // }

        // return (map.size() == 0);

        // for (char c : s.toCharArray()) {
        //     Integer a = map.get(c);
        //     map.put(c, (a == null) ? 1 : a + 1);
        // }

        // for (char c : t.toCharArray()) {
        //     Integer a = map.get(c);
        //     if (a == null || a.intValue() == 0) {
        //         return false;
        //     }
        //     if (a.intValue() == 0) {
        //         map.remove(c);
        //     }
        //     map.put(c, a - 1);
        // }

        // return true;

        if (s.length() != t.length()) return false;

        char [] arr = new char [26];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (a != b) {
                arr[a - 'a']++;
                arr[b - 'a']--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
    }
}
