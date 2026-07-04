import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI {


// так ладно думал легкая задачка, на самом деле оказалась чуть сложнее
// че сделать то можно? карту что ли? карту какую и чего нах
// хуй знает. кажется можно сделать просто считать к-во слов
// типо
// a -> 1
// aa -> 1
// aaa -> 1
// и если >3 то записывать в ответ
// по сути O(n) получается
// только бля substring хотя похуй? ключи то одинаковые
// ладно го попробуем

// так ладно. хуйню сделал, потому что остальные то я не проиндексировал
// то есть нужно тащить какую-то колесницу сабстрингов. а это блять как-то не
// очень не?

// что я еще могу сделать? префикс сум? как?
// ладно го доделаем тупым способом

    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>();
        int res = -1;

        int l = 0, r = 0;

        while (r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                sb.delete(0, sb.length());
                keys.clear();
                l = r;
            }

            sb.append(s.charAt(r));

            keys.add(sb.toString());

            for (String key : keys) {
                map.put(key, map.getOrDefault(key, 0) + 1);
                if (map.get(key) >= 3) res = Math.max(res, key.length());
            }

            r++;
        }

        return res;
    }

    // лол сработало 9ms beats 63.52% memory 36.47%
// но судя по графику есть еще лучше способ нах

// попробую воспользоваться подсказками
// The constraints are small. == Ограничения невелики.
// ну наверное намек на то что можно брутфорсом сделать

// подсказка 2
// Brute force checking all substrings.
// ну бля ебать подсказка конечно. я уже сделал брут форсом

// так ну видимо мой код можно как то улучшить

//    в итоге забью на улучшение

}
