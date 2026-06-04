public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        int size = 0;

        int res = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            map[s.charAt(r) - 'a']++;
            if (map[s.charAt(r) - 'a'] == 1) size++;

            if (size == 3) {
                while (map[s.charAt(l) - 'a'] > 1) {
                    map[s.charAt(l) - 'a']--;
                    l++;
                }
                res += l + 1;
            }

            r++;
        }

        return res;
    }

//    runtime 11ms beats 91.74% memory 15.15
//    ну крч решаю по тихоньку. сложно прочитать всё вместе
}
