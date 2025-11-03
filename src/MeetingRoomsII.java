import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    private static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start +
                    ", " + end +
                    ')';
        }
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 1;
        pq.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (pq.peek() > intervals.get(i).start) {
                pq.add(intervals.get(i).end);
                res = Math.max(res, pq.size());
            } else {
                while (!pq.isEmpty() && pq.peek() <= intervals.get(i).start) {
                    pq.poll();
                }
                pq.add(intervals.get(i).end);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> list;
        list = new ArrayList<>();
        list.add(new Interval(0, 40));
        list.add(new Interval(5, 10));
        list.add(new Interval(15, 20));
//        System.out.println("2 -> " + minMeetingRooms(list));
        list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 6));
        list.add(new Interval(3, 7));
        list.add(new Interval(4, 8));
        list.add(new Interval(5, 9));
//        System.out.println("4 -> " + minMeetingRooms(list));
        list = new ArrayList<>();
        list.add(new Interval(25,579));
        list.add(new Interval(218,918));
        list.add(new Interval(1281,1307));
        list.add(new Interval(623,1320));
        list.add(new Interval(685,1353));
        list.add(new Interval(1308,1358));
        System.out.println("3 -> " + minMeetingRooms(list));
    }
}
