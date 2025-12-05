import java.util.PriorityQueue;

public class NumberOfRecentCalls {

    private static class RecentCounter {

        private int last;
        private PriorityQueue<Integer> pq;

        public RecentCounter() {
            pq = new PriorityQueue<>();
            last = Integer.MIN_VALUE;
        }

        public int ping(int t) {
            if (t > last) {
                while (!pq.isEmpty() && pq.peek() < t - 3000) {
                    pq.poll();
                }
                last = t;
            }

            pq.add(t);
            return pq.size();
        }
    }

//    beats 23.89% memory 92.36% runtime 23ms
//

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
