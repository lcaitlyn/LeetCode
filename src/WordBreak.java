import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

//    бля вот я щас решил Implement Trie.
//    Как будто со всеми словами можно че то такое же придумать и как то их проиндексировать.
//    и если нам встречается первая буква слова, то мы запускам поиск слов в индексе.
//    если у нас два слова+ слова на одинаковую букву мы делаем что-то типо рекурсии
//    и начинаем проверять по длине слова и так набираем


//    Ладно возможно с Trie реально нету смысла усложнять.
//    Вообще для начала я хотел бы понять условия. Про каких условиях вы выводим true,
//    а про каких false. Наша строка должна содержать в себе все подстроки из dict?
//    То есть наша строка должна быть слеплена из слов в dict так?
//    Или она может сожержать в себе ещё какой нибудь мусор?
//    По типу строка «leetZcode” dict=“leet”, “code” и результат наше программы выдаст тру?

//    а что если в нашем dict есть лишние слова.
//    Допустим строка "leetleet" dict=“leet”,”code” что должна выдасть нам наша программа?

//    Ну все тогда, я сделаю мапу из слов, а точнее Map<Character, List<String>>
//    где буква будет первой буквой всех слов начинающихся с ней и буду идти по строке,
//    если слов несколько то буду запускать несколько итераций

    private static Map<Character, List<String>> makeMap(List<String> wordDict) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : wordDict) {
            List<String> list = map.getOrDefault(word.charAt(0), new ArrayList<>());
            list.add(word);
            map.put(word.charAt(0), list);
        }
        return map;
    }

//    private static boolean run(String s, Map<Character, List<String>> map) {
//        if (s.isEmpty()) return true;
//        if (!map.containsKey(s.charAt(0))) return false;
//        for (String word : map.get(s.charAt(0))) {
//            if (s.length() < word.length()) continue;
//            if (s.startsWith(word)) {
//                if (run(s.substring(word.length()), map)) return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Map<Character, List<String>> map = makeMap(wordDict);
//        return run(s, map);
//    }


//    TLE ожидамое нах TLE вышло
//    s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//    dict = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
//    я точно такой же и сделал пример (ну чуть поменьше), но сразу знал что TLE будет

    private static boolean run(String s, Map<Character, List<String>> map, int start, boolean[] visited) {
        if (start == s.length()) return true;
        if (visited[start]) return false;
        visited[start] = true;
        if (!map.containsKey(s.charAt(start))) return false;
        for (String word : map.get(s.charAt(start))) {
            if (s.length() < word.length()) continue;
            if (s.startsWith(word, start)) {
                if (run(s, map, start + word.length(), visited)) return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return run(s, makeMap(wordDict), 0, new boolean[s.length()]);
    }

//    beats 84.94% memory 59.61% runtime 2ms
//    переделал на s.startsWith(word, start)
//    beats 99.31% memory 64.15% runtime 1ms

//    чекнул в решения, там есть решение намного короче моего (через цикл в цикле)
//    типа O(S.length) * O(word.size())

    public static void main(String[] args) {
        System.out.println("true - > " + wordBreak("leetcode", List.of("leet", "code")));
        System.out.println("true - > " + wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println("false - > " + wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
        System.out.println("true - > " + wordBreak("aaaaaaa", List.of("aaa","aa","a")));
        System.out.println("false - > " + wordBreak("aaaaaab", List.of("aaa","aa","a")));
        System.out.println("true - > " + wordBreak("catsandogcat", List.of("cats","dog","sand","and","cat","an")));
        System.out.println("false - > " + wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))
        );
    }
}

