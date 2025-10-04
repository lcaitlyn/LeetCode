import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

//    private static int breakStones(PriorityQueue<Integer> pq) {
//        if (pq.size() == 1) return pq.poll();
//
//        if (pq.size() == 2) return pq.poll() - pq.poll();
//
//        int y = 0, x = 0;
//        while (pq.size() > 1) {
//            y = pq.poll();
//            x = pq.poll();
//
//            if (x != y) pq.add(y - x);
//        }
//
//        if (pq.size() == 1) return pq.poll();
//
//        return y - x;
//    }
//
//    public static int lastStoneWeight(int[] stones) {
//        if (stones.length == 1) return stones[0];
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i : stones) {
//            pq.add(i);
//        }
//
//        return breakStones(pq);
//    }

    // runtime 1ms beats 98,7% ; Memory 7%
    // видимо по памяти можно че то интереснее придумать лол
//     т.е че? не использовать PrivateQueue?

//    окей вот и подсказка есть оказывается
//    Hint 1
//    Simulate the process. We can do it with a heap, or by sorting some list of stones every time we take a turn.
//
//    public static int lastStoneWeight(int[] stones) {
//        if (stones.length == 1) return stones[0];
//
//        Arrays.sort(stones);
//        int r = stones.length - 1;
//        while (r - 1 >= 0) {
//            int y = Math.max(stones[r], stones[r - 1]);
//            int x = Math.min(stones[r], stones[r - 1]);
//            stones [r - 1] = y - x;
//            r--;
//        }
//        return stones[0];
//    }

    // не рабочий варик( на такой 42/74 тесте завалился: 7,6,7,6,9


    public static void main(String[] args) {
//        System.out.println(lastStoneWeight(new int[]{1}));
//        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
//        System.out.println(lastStoneWeight(new int[]{2, 2}));
//        System.out.println(lastStoneWeight(new int[]{3, 7, 8}));
        System.out.println(lastStoneWeight(new int[]{7,6,7,6,9}));
    }
}
