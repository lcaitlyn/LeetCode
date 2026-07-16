import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    // такая шляпа тут не прокатит
// так давай сделаем брутфорсом нахуй

// так давай попробуем пройтись &. Хотя какая нахуй разница? всё равно получится
// тот же самый брут форс

// пиздец че то даже получилось с бит манипуляциями
// теперь такая хуйня "aa" и "bb" вышло. То есть нельзя их использовать
// Вопрос как теперь не добавлять испорченные строки?

// так окей. тут не обязательно использовать только 2 строки
// ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"]

// окей сделал
// дальше вот такое:
// ["a", "abc", "d", "de", "def"]
// а что тут не так? а так что можно убрать просто "a" ведь есть лучше "abc"
// а так же есть "def" который включает "de" и "d".
// Хотя нет, нельзя.
// Почему?
// Что есть в "def" будет "dec" то есть они будут пересекаться в "c"

// бля я хуй знает если честно как сделать кроме как бэктрекинга
// думаю есть намного лучший вариант



    private static int rec(List<Integer> list, int i, int sum) {
        if (i == list.size()) return getOnes(sum);
        int res = 0;
        if (sum == 0) res = rec(list, i + 1, list.get(i));
        if ((sum & list.get(i)) == 0)
            res = Math.max(res, rec(list, i + 1, sum | list.get(i)));
        return Math.max(res, rec(list, i + 1, sum));
    }

    private static int getOnes(int i) {
        int res = 0;
        while (i > 0) {
            res += i & 1;
            i >>= 1;
        }
        return res;
    }

    public static int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();

        for (String string : arr) {
            boolean isOkay = true;
            int a = 0;
            for (char c : string.toCharArray()) {
                if ((a >> c - 'a' & 1) == 1) isOkay = false;
                a += 1 << (c - 'a');
            }
            if (isOkay) list.add(a);
        }

        return rec(list, 0, 0);
    }

    // ахуеть
// во первых с первого раза написал rec() - backtracking
// хотя полгода уже бэктрекинг не писал а ту тсразу рабочий
// так еще и runtime 5ms beats 84.23% memory 90.22%

    public static void main(String[] args) {
        System.out.println("4 -> " + maxLength(List.of("un", "iq", "ue")));
        System.out.println("0 -> " + maxLength(List.of("aa", "bb", "cc")));
        System.out.println("16 -> " + maxLength(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
        System.out.println("6 -> " + maxLength(List.of("a", "abc", "d", "de", "def")));


        int i = 0;
        i += 1 << 5;
        i += 1 << 4;
        System.out.println(Integer.toBinaryString(i >> 3 & 1));
        System.out.println(Integer.toBinaryString(i >> 5 & 1));
        System.out.println(Integer.toBinaryString(i >> 4 & 1));
        i -= 1 << 5;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >> 5 & 1));

//        int i = 0;
//        i = 1 << ('b' - 'a');
//        i += 1 << ('a' - 'a');
//        i += 1 << ('z' - 'a');
//        int z = 0;
//        z = 1 << ('x' - 'a');
//        z += 1 << ('y' - 'a');
//        z += 1 << ('z' - 'a');
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(Integer.toBinaryString(z));
//        System.out.println(Integer.toBinaryString(z & i));
//        System.out.println(Integer.toBinaryString(z | i));
    }
}
