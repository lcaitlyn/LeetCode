import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

//    private static int max(Map<Character, Integer> map) {
//        int max = 0;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > max) {
//                max = entry.getValue();
//            }
//        }
//        return max;
//    }
//
//    public static int characterReplacement(String s, int k) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        int res = 0;
//        int max = 0;
//        int l = 0;
//        int r = 0;
//        while (l < s.length()) {
//            if (r < s.length()) {
//                int c = map.getOrDefault(s.charAt(r), 0) + 1;
//                map.put(s.charAt(r), c);
//                max = Math.max(max, c);
//                r++;
//            } else {
//                int c = map.getOrDefault(s.charAt(l), 0) - 1;
//                map.put(s.charAt(l), c);
//                max = max(map);
//                l++;
//            }
//            int len = r - l;
//            if (len - max <= k) {
//                res = Math.max(res, len);
//            }
//        }
//
//        return res;
//    }

//    этот код 9 апреля 2025 я делал. сегодня 23.10.2025

//    private int removeZeros(String s, int k, char c) {
//        int res = 0, count = 0, zeros = 0;
//        int l = 0, r = 0;
//
//        while (r < s.length()) {
//            if (s.charAt(r) != c) zeros++;
//            while (l < s.length() && zeros > k) {
//                if (s.charAt(l) != c) {
//                    zeros--;
//                }
//                l++;
//                count--;
//            }
//            count++;
//            res = Math.max(res, count);
//            r++;
//        }
//        return res;
//    }
//
//    public int characterReplacement(String s, int k) {
//        Set<Character> set = new HashSet<>();
//        for (char c : s.toCharArray()) {
//            set.add(c);
//        }
//        int res = 0;
//        for (char c : set) {
//            res = Math.max(res, removeZeros(s, k, c));
//        }
//        return res;
//    }


//    beats 36.38% memory 60.94% runtime 21ms
//    не с первого раза получилось, но за минут 15-20 сделал
//    в прошлый раз видимо дрочился, но не получалось. видно прогресс за полгода есть
//    потому что тогда не смогу засабмитить даже задачу

//    но все равно мой ответ какой-то не стандантарный он между Топ лучишими ответами и Топ худшими (крч в яме между двух гор)

//    public static int characterReplacement(String s, int k) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int res = 0, l = 0, r = 0, zeros = 0, maxCount = 0;
//
//        while (r < s.length()) {
//            char c = s.charAt(r);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            maxCount = Math.max(maxCount, map.get(c));
//
//            if (r - l - maxCount < k) {
//                r++;
//                res = r - l;
//            } else {
//                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                l++;
//                r++;
//            }
//        }
//
//        return res;
//    }

//    beats 16% memory 11% runtime 36ms
//    пиздец чатГПт насоветовал сука. Хотя скорость сука стала O(n), вместо O(n + 26)
//    говорит переделать не под хэшмапу а с массивчиком

    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int res = 0, l = 0, r = 0, zeros = 0, maxCount = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            map[c - 'A']++;
            maxCount = Math.max(maxCount, map[c - 'A']);

            if (r - l - maxCount < k) {
                r++;
                res = r - l;
            } else {
                map[s.charAt(l) - 'A']--;
                l++;
                r++;
            }
        }

        return res;
    }

//    beats 65% memory 40% runtime 9ms
//    ну ок
//    пиздец я этот алгоритм долго выносил нах
//    думал как его реализовать, а точнее закодить пиздец как долго

    public static void main(String[] args) {
        System.out.println(characterReplacement("WAWDRNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AAA", 2));
        System.out.println(characterReplacement("ABAA", 0));
    }
}
