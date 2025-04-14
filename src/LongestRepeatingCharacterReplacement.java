import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    private static int max(Map<Character, Integer> map) {
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (l < s.length()) {
            if (r < s.length()) {
                int c = map.getOrDefault(s.charAt(r), 0) + 1;
                map.put(s.charAt(r), c);
                max = Math.max(max, c);
                r++;
            } else {
                int c = map.getOrDefault(s.charAt(l), 0) - 1;
                map.put(s.charAt(l), c);
                max = max(map);
                l++;
            }
            int len = r - l;
            if (len - max <= k) {
                res = Math.max(res, len);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("WAWDRNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}
