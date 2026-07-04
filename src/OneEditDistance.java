public class OneEditDistance {

    // так ну что тут сказать можно. очень странное задание
// сделать что ли тут 3 тест кейса?
// или мб сделать 2 мапы и потом сами мапы проверять?
// вообще хз. Хотелось бы сразу за цикл сделать.
// А как это сделать? И нам нужно чтобы наши строки были равны.
// очень странно как-то. Как будто 3 цикла надо сделать. Мб рил сделать, а потом
// уже че-нибудь придумать как их можно соединить?
// Для каждого тест кейса свой написать циклв?
// Пока сделаю так
// окей. Сделал 3 разных. Теперь могу их объединить в один цикл

    public static boolean isOneEditDistance(String s, String t) {
        boolean edited = false;

        int l = 0, r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) != t.charAt(r)) {
                if (edited) return false;
                edited = true;
                if (s.length() == t.length()) {

                } else if (s.length() + 1 == t.length()) {
                    l--;
                } else if (s.length() - 1 == t.length()) {
                    r--;
                } else {
                    return false;
                }
            }
            l++;
            r++;
        }
        if (!edited && (s.length() + 1 == t.length() || s.length() - 1 == t.length())) return true;
        return edited;
    }

//    найс. на китайском сайте запускал
//    https://www.lintcode.com/problem/640/
//    beats 1% runtime 378ms memory 20.04%

    public static void main(String[] args) {
        System.out.println("true -> " + isOneEditDistance("bcde", "abcde"));
    }
}
