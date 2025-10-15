import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map = new HashMap<>();
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                if (set.contains(t.charAt(i))) return false;
//
//                map.put(s.charAt(i), t.charAt(i));
//                set.add(t.charAt(i));
//            } else {
//                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
//            }
//        }
//
//        return true;
//    }

//    beats 57% rutime 12ms memory 72%
//     можем ли мы отсортировать два массива и сравнивать если не совпадения?
//    думаю нет
//    нам нужно найти к-во уникальных букв в первом и во втором

    public static void main(String[] args) {

    }
}
