import java.util.Arrays;

public class ReplaceTheSubstringForBalancedString {

//    public static int balancedString(String s) {
//        int k = s.length() / 4;
//        int size = 0;
//        int[] map = new int[26];
//
//        int l = 0;
//        for (int i = 0; i < s.length(); i++) {
//            map[s.charAt(i) - 'A']++;
//            if (size == 0 && map[s.charAt(i) - 'A'] == k + 1)
//                l = i;
//            if (map[s.charAt(i) - 'A'] == k + 1)
//                size++;
//        }
//
//        if (size == 0) return 0;
//
//        int r = l;
//        while (size > 0) {
//            map[s.charAt(r) - 'A']--;
//            if (map[s.charAt(r) - 'A'] == k)
//                size--;
//            r++;
//        }
//
//        return r - l + 1;
//    }

//    Если ты застал на просмотре "WWWQWWWWWWWWWWWWWWWWW", или не понял, что это за предложения, то воспользуйся этим предложением:
//    Ввод: s = "QQQWEEER"
//    Вывод: 3
//    Пояснение: Нам нужно заменить "QWE" на "WWR" (или в любом другом порядке этих символов), чтобы строка была сбалансирована ("QQQWWREER")

//    QQQWEEER
//    QQQWEEEQ

    public static int balancedString(String s) {
        int k = s.length() / 4;
        int size = 0;
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'A']++;
            if (map[s.charAt(i) - 'A'] == k + 1)
                size++;
        }

        if (size == 0) return 0;

        int res = s.length();
        int l = 0, r = 0;
        while (r < s.length()) {
            map[s.charAt(r) - 'A']--;

            if (map[s.charAt(r) - 'A'] == k) size--;
            while (l <= r && size == 0) {
                res = Math.min(res, r - l + 1);
                map[s.charAt(l) - 'A']++;
                if (map[s.charAt(l) - 'A'] == k + 1)
                    size++;
                l++;
            }

            r++;
        }

        return res;
    }

//    ура блять
//    runtime 9ms beats 70.15% memory 98.88%

    public static void main(String[] args) {
        System.out.println("3 -> " + balancedString("QQQWEEER"));
        System.out.println("4 -> " + balancedString("QQQWEEEQ"));
        System.out.println("4 -> " + balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
}
