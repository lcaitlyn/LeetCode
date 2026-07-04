public class GetEqualSubstringsWithinBudget {

// как-то сложненько ебать
// вообще хуй знает че делать тут

// ну если это slidingWindow
// то скорее всего нужно поддерживать цену maxCost

// чтобы она не превышала и всё

    public static int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int cost = 0;

        int l = 0, r = 0;
        while (r < t.length()) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));

            while (l < t.length() && cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            res = Math.max(res, r - l + 1);

            r++;
        }

        return res;
    }

//    beats 25.63% runtime 9ms memory 18.94%
//    думал сложновато будет, в итоге за 5 минут решил

    public static void main(String[] args) {
        System.out.println("4 -> " + equalSubstring("pxezla", "loewbi", 25));
    }
}
