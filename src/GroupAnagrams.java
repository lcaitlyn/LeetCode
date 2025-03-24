import java.util.*;

public class GroupAnagrams {

    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char [] a = s.toCharArray();
            Arrays.sort(a);
            String key = new String(a);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        return map.values().stream().toList();
    }

    // результат 7 мс beats 66%

    private static void printRes(List<List<String>> list) {
        list.forEach(System.out::println);
        System.out.println("size = " + list.size());
    }
    
    public static void main(String[] args) {
        printRes(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
