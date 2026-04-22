import java.util.PriorityQueue;

public class NumberOfRecentCalls {

//    private static class RecentCounter {
//
//        private int last;
//        private PriorityQueue<Integer> pq;
//
//        public RecentCounter() {
//            pq = new PriorityQueue<>();
//            last = Integer.MIN_VALUE;
//        }
//
//        public int ping(int t) {
//            if (t > last) {
//                while (!pq.isEmpty() && pq.peek() < t - 3000) {
//                    pq.poll();
//                }
//                last = t;
//            }
//
//            pq.add(t);
//            return pq.size();
//        }
//    }

//    beats 23.89% memory 92.36% runtime 23ms
//

//    upd от 09.04.2026 в рамках подготовки к Yandex Intern Week Offer


//    private static class RecentCounter {
//
//        private final PriorityQueue<Integer> pq;
//
//        public RecentCounter() {
//            pq = new PriorityQueue<>();
//        }
//
//        public int ping(int t) {
//            pq.add(t);
//
//            while (!pq.isEmpty() && pq.peek() < t - 3000) pq.poll();
//
//            return pq.size();
//        }
//    }

//    это упращенная версия кода выше (результат такой же)

    private static class RecentCounter {

        private final int[] arr;
        int l, r;

        public RecentCounter() {
            arr = new int[10001];
            l = 0;
            r = 0;
        }

        public int ping(int t) {
            arr[r] = t;
            r++;

            while (l <= r && arr[l] < t - 3000) l++;

            return r - l;
        }
    }

//    а это я заменил PriorityQueue на int[] с двумя указателями
//    runtime 19ms beats 93.54% memoery 75%

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
