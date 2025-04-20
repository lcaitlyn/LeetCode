import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // решая эту задачу, я уже немного подумал и скорее всего не хочу делать какой-то жеский перебор
    // буду делать следующее. так как основное это надо найти длину не повторящий подстроки, 
    // я сделаю функцию которая будет просто находить длину неповторящихся символов в строке,
    // а после просто буду закидывать туда строки после split(' ').
    // поиск буду делать через массив int [].
    // так как по условию: consists of English letters, digits, symbols and spaces
    // размер массива будет 126(символ ~) - 33 (символ !) = 93.
    // в этот массив буду записывать есть ли значение, либо можно использовать сет

    // сперва сделаю тупой брутфорс, потом попытаюсь оптимизировать


    // private static int len(String s) {
    //     Set<Character> set = new HashSet<>();

    //     int i = 0;
    //     int max = 0;
    //     while (i < s.length()) {
    //         int j = i;
    //         int k = 0;
    //         while (j < s.length() && !set.contains(s.charAt(j))) {
    //             set.add(s.charAt(j));
    //             k++;
    //             j++;
    //         }

    //         max = Math.max(max, k);
    //         set.clear();
    //         i++;
    //     }
    //     return max;
    // }

    // public static int lengthOfLongestSubstring(String s) {
    // return len(s);
    // }

    // полный бред нижняя функция сплита нахуй не нужна была оказывается.

    // Результат len()  runtime 9,19% 83ms
    // думаю настало время скакать и подумать что такое ориг сабстрока

    // private static int lengthOfLongestSubstring(String s) {
    //     Map<Character, Integer> map = new HashMap<>();

    //     int i = 0;
    //     int max = 0;
    //     while (i < s.length()) {
    //         int j = i;
    //         int k = 0;
    //         while (j < s.length() && !map.containsKey(s.charAt(j))) {
    //             map.put(s.charAt(j), j);
    //             k++;
    //             j++;
    //         }
    //         if (j < s.length()) {
    //             i = map.get(s.charAt(j));
    //         }
    //         i++;
    //         max = Math.max(max, k);
    //         map.clear();
    //     }
    //     return max;
    // }

    // лол поменял алгоритм, а он до сих пор медленный
    // теперь у меня скачет, а все равно медленно.
    // Результат runtime 10% 79ms 

    // private static int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();

    //     int i = 0;
    //     int max = 0;
    //     while (i < s.length()) {
    //         if (set.contains(s.charAt(i))) {
    //             max = Math.max(max, set.size());
    //             set.clear();
    //             set.add(s.charAt(i));
    //         } else {
    //             set.add(s.charAt(i));
    //         }
    //         i++;
    //     }
    //     set.clear();
    //     while (i-- > 0) {
    //         if (set.contains(s.charAt(i))) {
    //             max = Math.max(max, set.size());
    //             set.clear();
    //             set.add(s.charAt(i));
    //         } else {
    //             set.add(s.charAt(i));
    //         }
    //     }

    //     return Math.max(max, set.size());
    // }

    // ок блять это решение не работает даже если крутануть в обратку

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                res = Math.max(res, set.size());
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            r++;
        }
        return res;
    }

    // result 5 ms beats 87.6%. Ура блять. Еле еле догадался. Хотя решение мега изи блять
        
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asjrgapa"));
    }
}
