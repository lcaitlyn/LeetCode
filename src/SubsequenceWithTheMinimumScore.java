public class SubsequenceWithTheMinimumScore {

//    private static boolean isValid(String s, String t, int start, int end) {
//        int l = 0;
//        int r = 0;
//
//        while (r < start) {
//            while (l < s.length() && s.charAt(l) != t.charAt(r)) l++;
//
//            if (l == s.length()) return false;
//            l++;
//            r++;
//        }
//
//        r = end;
//        while (r < t.length()) {
//            while (l < s.length() && s.charAt(l) != t.charAt(r)) l++;
//
//            if (l == s.length()) return false;
//            l++;
//            r++;
//        }
//
//        return true;
//    }

//    public static int minimumScore(String s, String t) {
//        int res = 0;
//        int[] map = new int[26];
//
//        for (char c : s.toCharArray()) map[c - 'a']++;
//
//        int[] arr = new int[26];
//
//        int l = 0;
//        while (l < t.length()
//                && arr[t.charAt(l) - 'a'] <= map[t.charAt(l) - 'a']
//                && isValid(s, t, l + 1, t.length())) {
//            res = l + 1;
//            arr[t.charAt(l) - 'a']++;
//            l++;
//        }
//
//        l--;
//        int r = t.length() - 1;
//        while (l < r) {
//            arr[t.charAt(r) - 'a']++;
//            while (l >= 0
//                    && arr[t.charAt(l) - 'a'] > map[t.charAt(l) - 'a']) {
//                arr[t.charAt(l) - 'a']--;
//                l--;
//            }
//
//            if (arr[t.charAt(r) - 'a'] > map[t.charAt(r) - 'a']) break;
//            if (isValid(s, t, l + 1, r))
//                res = Math.max(res, t.length() - r  + (l + 1));
//
//            r--;
//        }
//
//        while (r < t.length()) {
//            if (isValid(s, t, 0, r))
//                res = Math.max(res, t.length() - r);
//
//            r++;
//        }
//
//        return t.length() - res;
//    }

//    public static int minimumScore(String s, String t) {
//        int l = 0, r = 0;
//        int res = 0;
//
//        while (true) {
//            while (r < t.length() && !isValid(s, t, l ,r)) {
//                r++;
//            }
//            res = Math.max(res, t.length() - r  + l);
//
//            if (res == t.length()) return 0;
//
//            l++;
//            while (l <= r && isValid(s, t, l ,r)) {
//                l++;
//            }
//            res = Math.max(res, t.length() - r  + (l - 1));
//
//            if (r == t.length()) break;
//        }
//
//        return t.length() - res;
//    }

    // Ебать задача походу похожа на 1658 и 1574.
// Нам нужно вырезать у строки t какую то часть, чтобы всё остальная часть стала валидной.
// Теперь как же это сделать нахуй? Опять же что мы хотим?
// Искать НЕ валидную часть в строке t и вырезать её.
// Я правильно понимаю чи не?
// А может...
// А нет.
// Хотел предложить идею в тем чтобы пройтись по s узнать не валидные или сколько в t[i] больше чем s[i]
// Типа если s = "aa" t = "aaa",  я думаю реультат дожен быть 1. 1 a нам нужно убрать, чтобы что t был subsequence s

// Опа.

// Прочитал условие:
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Крч тут нужно думать.

// Подумал пока косил траву и пришел к следующему выводу:

// И так во первых: буквы которые есть в t и которые нету в s - 100% попадут под удаление:
// s = "abc" t = "xyz" -> 3
// Второе: буквы которых больше в t чем букв в s
// s = "a" t = "aa" -> 1 (удалили вторую 'a')

// Итак что из этого могу сказать.
// А могу сказать то что нам нужно сделать "валидный" t, удалив из него не нужное.
// А что потом? А потом уже просто проверяем второй функций является ли он subsequence или нет.
// Какая сложность? Ну смотри мы будет брать валидные t это O(n)
// и каждый раз проходить им по s итого: O(s * t), не O(s + t) конечно
// но вроде тоже норм чи не? тем более задача хард
// Пока так.
// Осталось закодить
// А ну да, самое сложно наверное будет искать вот этот вот "валидный" подмассив.
// Вся дрянь наверное будет тут.

// Так вот сделал карту лишних сиволов:
// for (char c : s.toCharArray()) map[c - 'a']++;

// for (char c : t.toCharArray()) set[c - 'a']++;

// for (int i = 0; i < map.length; i++) {
//     set[i] -= map[i]; // тут храняться излишки
// }

// как теперь понять? валидный ли t?
// я думаю пройтись надо будет еще не один раз, а два раза. Почему?
// Первый раз мы пройдемся до того момента пока не встретим "не валидный" символ,
// то есть до этого не валидного символа всё остально будет валидным.
// А как пройтись то второй раз? Может быть стоит использовать 2 указателя?
// идти справа и слева?
// бля...
// или может стоит опять че то разматывать нахуй.
// Обратно разматывать что? левый указатель вот что.
// То есть мы сперва левым упремся, потом пойдем правым и будем разматывать левый.
// Ну окей го тестить.

// int l = 0;
// while (l < t.length() && set[l] > 0) {
//     set[l]--;
//     l++;
// }

// вот так крутанул влево. Стоит ли проверять теперь является ли он корректным?
// Похуй проверю. Хотел дописать что в рамках оптимизации буду убирать,
// но на самом деле всё равно надо чекать,
// потому что далнее говно может быть не валидным и всё.

// вот в итоге что пришло после неких тестов:
// int l = 0;
//         while (l < t.length()
//                 && set[t.charAt(l) - 'a'] <= map[t.charAt(l) - 'a']
//                 && isValid(s, t, l + 1, t.length())) {
//             res = l + 1;
// //            set[t.charAt(l) - 'a']--; // ?
//             l++;
//         }

// это то как крутим левую часть. только вот тут не ебу + или - должен
// set[t.charAt(l) - 'a']--;
// или нахуй это не нужно?

// ладно давай правую часть крутить


// бля у меня тут лютый запуп со своими set и map.
// А в частности сколько мне нужно, а сколько я могу пропустить. А что я не могу пропустить

// еще подумав, тут всё проще чем кажется
// нужно лишь поддерживать валидное окно в t и всё

// вот что получилось:
// public int minimumScore(String s, String t) {
//         int res = 0;
//         int[] map = new int[26];

//         for (char c : s.toCharArray()) map[c - 'a']++;

//         int[] arr = new int[26];

//         int l = 0;
//         while (l < t.length()
//                 && arr[t.charAt(l) - 'a'] <= map[t.charAt(l) - 'a']
//                 && isValid(s, t, l + 1, t.length())) {
//             res = l + 1;
//             arr[t.charAt(l) - 'a']++;
//             l++;
//         }

//         l--;
//         int r = t.length() - 1;
//         while (l < r) {
//             arr[t.charAt(r) - 'a']++;
//             while (l >= 0
//                     && arr[t.charAt(l) - 'a'] > map[t.charAt(l) - 'a']) {
//                 arr[t.charAt(l) - 'a']--;
//                 l--;
//             }

//             if (arr[t.charAt(r) - 'a'] > map[t.charAt(r) - 'a']) break;

//             if (isValid(s, t, l + 1, t.length()))
//                 res = Math.max(res, t.length() - r  + (l + 1));

//             r--;
//         }

//         return t.length() - res;
//     }

// и вышла ошибка s = "abecdebe" t = "eaebceae"
// output 2 expected 6

// s = "dabbbeddeabbaccecaee"
// t = "bcbbaabdbebecbebded"
// output 17 expected 16
// так ну че дальше?
// а вот еще не чекнул я то что нужно взять только правую часть и всё

// добавил это и всё равно не работает:
// while (r < t.length()) {
//             if (isValid(s, t, 0, r))
//                 res = Math.max(res, t.length() - r);

//             r++;
//         }

// я блять разраба мать ебал просто
// какое же уебщиное задание

// s = "dcadebdecbeaedd"
// t = "dcdadeb"
// output 2 expected 1
// ахаха блять какя же хуйня
// блять проще нахуй уже просто сделать O(s * t ^ 2) потому что я хз нахуй

// бля не ебу нахуй
// мб просто слева и справа идти по обоим или че нахуй?

// бля пиздец пример разъебный нахуй. сразу видно что очень тяжело
// и не понятно как и куда крутить нахуй

// блять я реально не понимаю нахуй как удалить эту 'a' это ж пиздец нахуй

// открываю подсказки нахуй:
// Maintain two pointers: i and j. We need to perform a similar operation: while t[0:i] + t[j:n] is not a subsequence of the string s, increase j.

// и что это? нихуя не понятно блять
// блять ну это n^2 не?
// окей блять если они хотят от меня квадрат, то хули не сделать нахуй
// погоди
// а как это сделать то нахуй?

// блять какой уебан разрабатывал нахуй подсказку? что такое "увеличиваем j"
// а с i то че делать. уебок ебанхуй он. такой же как и разраб

// может быть берем первый символ и идём по j, если isValid == true то
// увеличиваем i? так это вроде и есть O(t ^ 2)

// abacaba

// bzaa
// l
// r

// cde

// xyz
// l
// r

// abecdebe
// eaebceae

// так блять. погонял по тестами вроде че-то вырисовывается
// еще один тест нужен

// dcadebdecbeaedd
// dcda deb
// res = 2(убрать первые dc) -> 1(убрали вторую d)

// еще один вроде проходит


// dabbbeddeabbaccecaee
// bcbba abdbebecbebded

// может оптимизация еще есть? с чем? с тем что можно будет прыгать..
// а не, хуйня идея с прыжками

// неужели догнал че делать то надо или еще нет нахуй
// смотри как делать будем

// будем идти slidingWindow и будет смотреть всё оставшееся на корректность.
// Если остаток не валиден, то правым загребаем еще.
// Если валиден, то двигаем левый указатель
// Нужно будет еще isValid переписать
// а не, нахуя? итак вроде коррекная вродь

// Блять ну только поравдовался что тесты прошли:
// public int minimumScore(String s, String t) {
//         int l = 0, r = 0;
//         int res = 0;

//         while (true) {
//             while (r < t.length() && !isValid(s, t, l ,r)) {
//                 r++;
//             }
//             res = Math.max(res, t.length() - r  + l);

//             l++;
//             while (l <= r && isValid(s, t, l ,r)) {
//                 l++;
//             }
//             res = Math.max(res, t.length() - r  + (l - 1));

//             if (r == t.length()) break;
//         }

//         return t.length() - res;
//     }

// а опять вышла хуйня

// s = "adebddaccdcabaade"

// t = "adbae"

// o: -3 e: 0
// откуда вообще нахуй -3 взялось то блять

// АХАХАХАХАХАХ
// Сука
// TLE вышло на каком то ебанутом тесте

// Бля эта хуйня меня до ведет просто

// нужна оптимизация да? а как её сделать то блять. вообще не ебу
// у меня блять IDEA даже запустить такую хуйню не может лол

// блять просто ебнутый тест кейс нахуй

// блять я даже проверять в идеи такой тест кейс не могуйх нахуй

// в итоге сделал через StringBuilder s.length() = 100_000

// за то старый код (старое решение) тянет эту парашу и выдает ответ относительно быстро

// а точняк. была идея возвращать индекс, после которого нужно проверять
// в функции isValid. Типо не с 0 ля начинать проверять, а то откуда...
// бля хуйня

// бля вот проблема в этой хуйне в том что он в самом конце упирается в эту ебучую Zку
// и бля получается по максимому отрабатывает

// итак есть 2 вариант. Доделать 1ый вариант или ускорить вторую
// ну или пойти смотреть решения(

// так. А что если идти левым не с начала, а с r?

// dcadebdecbeaedd

// dcdadeb

// а не, оказывается 1ое решение тоже не проходит по TLE

// открыл вторую подсказку.

// We can check the condition greedily. Create the array leftmost[i] which denotes minimum index k, such that in prefix s[0:k] exists subsequence t[0:i]. Similarly, we define rightmost[i].

// нихуя не понятно блять
// щас мозг взорветься просто нахуй

// abacaba
// bzaa
// l[1, ?, ?, ?]
// r[?, ?, 4, 6]

// и че это за хуйня получилась?

// abecdebe
// eaebceae
// l[2, 0, 2, 1, 3, 2, 0, 2]
// r[7, 0, 7, 6, 3, 7, 0, 7]

// ну и что это даёт мне?

// блять какая то залупа не?

// бля крч в пизду видимо надо идти смотреть обзоры

//    крч спустя 12 часов решения этой хуйни (я начал 7.06.2026 в обед, а щас 23:46)
//    и так не понял как это решать. Оставлю видосик на завтра нахуй
//    Итог - литкод хуйня

//    так сегодня 08.06.2026 продолжаю решать.
//    на ютубе блять нету видосов, одни ебаные видосы с индусиками 💩

//    открыл третью подсказку.
//    If leftmost[i] < rightmost[j] then t[0:i] + t[j:n] is the subsequence of s.
//      она просто нихуя не дает

//    abecdebe
//    eaebceae s[k:n] t[i:n]
//    [2,8,8,8,8,8,8,8]
//    [-1,-1,-1,-1,-1,0,7]
//
//    ну тут вроде [1..6] убираем
//    хотя всё еще до конца не понимаю как эту залупу сделать
//
//      abacaba
//      bzaa
//      [1,7,7,7]
//      [-1,-1,4,6]
//
//    и тут сходится вроде i = 0, j = 2 итог вырезаем [1..1]
//
//    теперь этот год чекнем
//
//    aaaaa
//            aaaaz
//[0,1,2,3,5]
//        [-1,-1,-1,-1,-1]
//
//    так ну тут вроде то же че то есть
//
//    го еще это чекнем
//
//            dcadebdecbeaedd
//            dcdadeb
//            [ 0, 1,3,11,13,15,15] i = 2
//            [-1,-1,0,2, 6, 7, 9] j = 4
//            -> итоге вырезаем [3..3]
//
//    так ну вроде понятненько

    public static int minimumScore(String s, String t) {
        int[] lmost = new int[t.length()];
        int[] rmost = new int[t.length()];

        int k = 0;
        for (int i = 0; i < t.length(); i++) {
            while (k < s.length()) {
                if (s.charAt(k) == t.charAt(i)) break;
                k++;
            }
            lmost[i] = k;
            k++;
        }

        if (lmost[t.length() - 1] < s.length()) return 0;

        k = s.length() - 1;
        for (int i = t.length() - 1; i >= 0; i--) {
            while (k >= 0) {
                if (s.charAt(k) == t.charAt(i)) break;
                k--;
            }
            rmost[i] = k;
            k--;
        }

        int res = 0;
        int l = 0;
        while (l < t.length() && lmost[l] < s.length()) {
            l++;
            res++;
        }

        int r = t.length() - 1;
        while (l < r && r >= 0 && rmost[r] >= 0) {
            while (l >= 0 && lmost[l] >= rmost[r]) {
                l--;
            }

            res = Math.max(res, l + 1 + t.length() - r);

            r--;
        }

        return t.length() - res;
    }

//    УРА блять. Крч сделал нахуй, наконец то блять
//    runtime 9ms beats 61.43% memory 35%


    public static void main(String[] args) {
        System.out.println("12 -> " + minimumScore("chehcfiahigbhgaegjeieefhfaeghecahfeeeiehbieefggic", "hahhhieacbficfdhgicc"));
        System.out.println("1 -> " + minimumScore("acdedcdbabecdbebda", "bbecddb"));
        System.out.println("0 -> " + minimumScore("adebddaccdcabaade", "adbae"));
        System.out.println("1 -> " + minimumScore("abacaba", "bzaa"));
        System.out.println("6 -> " + minimumScore("abecdebe", "eaebceae"));
        System.out.println("16 -> " + minimumScore("dabbbeddeabbaccecaee", "bcbbaabdbebecbebded"));
        System.out.println("1 -> " + minimumScore("dcadebdecbeaedd", "dcdadeb"));
        System.out.println("1 -> " + minimumScore("aaaaa", "aaaaz"));
        System.out.println("1 -> " + minimumScore("aaaaa", "zaaaa"));
        System.out.println("1 -> " + minimumScore("aaaaa", "zaaaa"));
        StringBuilder sb = new StringBuilder();
        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for (int i = 0; i < 1000; i++) {
            sb.append(a);
        }
        String s = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(a);
        }
        sb.delete(0, 1);
        sb.append("z");
        String t = sb.toString();


        System.out.println("1 -> " + minimumScore(s, t));

    }

}
