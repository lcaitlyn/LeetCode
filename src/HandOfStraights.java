import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HandOfStraights {


//    я вот подумал так, думал как их правильно рассортировать, но по сути мне это не важно нахуй.
//    я начал думать от корнер кейсов "при каком условии у нас будет false?",
//    а будет он если у нас будет при hand.length % groupSize != 0
//    это сразу вроде понятно и видно, а дальше как понять что числа нормальные?
//    я подумал если у нас будет одно и тоже число постоянно,
//    то оно явно заруинит нам всё и тут я такой "А сколько одинаковых чисел мы вообще может принять?"
//    ответ: hand.length / groupSize. Т.е если одинаковых чисел перевалило за эту отметку,
//    то мы не сможем добавить его в тот же подмассив


//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        if (hand.length % groupSize != 0) return false;
//
//        int[] map = new int[10001];
//
//        int k = hand.length / groupSize;
//        for (int i = 0; i < hand.length; i++) {
//            map[hand[i]]++;
//            if (map[hand[i]] > k) return false;
//        }
//        return true;
//    }

//    WA [8,10,12] gS = 3
//    я думал такое будет валидно
//    оказалось нужно чтобы они по очереди шли

//    public static boolean isNStraightHand(int[] hand, int groupSize) {
//        if (hand.length % groupSize != 0) return false;
//        int k = hand.length / groupSize;
//        int[][] dp = new int[k][2]; // dp[i][0] == size ; dp[i][1] == min value ;
//        Arrays.sort(hand);
//        for (int i = 0; i < hand.length; i++) {
//            boolean fit = false;
//            for (int j = 0; j < k; j++) {
//                if (dp[j][0] == groupSize) continue;
//                if (dp[j][1] + 1 == hand[i] || (dp[j][1] == 0 && dp[j][0] == 0)) {
//                    dp[j][0]++;
//                    dp[j][1] = hand[i];
//                    fit = true;
//                    break;
//                }
//            }
//            if (!fit) return false;
//        }
//        return true;
//    }

//    beats 6.98% memory 74.88% runtime 73ms

//    public static boolean isNStraightHand(int[] hand, int groupSize) {
//        if (hand.length % groupSize != 0) return false;
//        int k = hand.length / groupSize;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//
//        for (int i = 0; i < hand.length; i++) {
//            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
//        }
//
//        for (int i = 0; i < k; i++) {
//            int start = map.firstKey();
//            for (int j = 0; j < groupSize; j++) {
//                if (!map.containsKey(start)) return false;
//                map.put(start, map.get(start) - 1);
//                if (map.get(start) == 0) map.remove(start);
//                start++;
//            }
//        }
//        return true;
//    }

//    beats 20.97% memory 83.22% runtime 64ms

//    можно еще как то сделать с MinHeap (PriorityQueue)?

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        int k = hand.length / groupSize;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            pq.add(hand[i]);
        }

        for (int i = 0; i < k; i++) {
            int cur = pq.peek();
            for (int j = 0; j < groupSize; j++) {
                if (map.get(cur) == null || map.get(cur) == 0) return false;
                map.put(cur, map.get(cur) - 1);
                pq.remove(cur);
                cur++;
            }
        }
        return true;
    }


//    beats 36% memory 36% runtime 61ms
//    хуйня а не решение


    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5}, 4));
        System.out.println(isNStraightHand(new int[]{8,10,12}, 3));
        System.out.println(isNStraightHand(new int[]{9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11}, 10));
        System.out.println(isNStraightHand(new int[]{0,0}, 2));
    }
}
