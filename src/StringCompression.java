import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class StringCompression {

//    public static int compress(char[] chars) {
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//
//        for (char c : chars) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (char c : map.keySet()) {
//            sb.append(c);
//            if (map.get(c) > 1)
//                sb.append(map.get(c));
//        }
//
//        for (int i = 0; i < sb.length(); i++) {
//            chars[i] = sb.charAt(i);
//        }
//
//        return sb.length();
//    }

//    wrong answer ["a","a","a","b","b","a","a"]
//    output (мой): ["a","5","b","2"]
//    Expected: ["a","3","b","2","a","2"]
//    хах. а я думал по проще все
//    ладно еще подумаем немного

    public static int compress(char[] chars) {
        int count = 0;
        char cur = chars[0];

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == cur) {
                count++;
            } else {
                sb.append(cur);
                if (count > 1)
                    sb.append(count);
                count = 1;
                cur = c;
            }
        }
        sb.append(cur);
        if (count > 1)
            sb.append(count);

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

//    beats 99.64% memory 48% runtime 1ms

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(chars);
        System.out.println(compress(chars));
        System.out.println(chars);
    }
}
