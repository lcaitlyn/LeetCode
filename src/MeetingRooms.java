import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {
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


    public static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> list;
        list = new ArrayList<>();
        list.add(new Interval(5, 8));
        list.add(new Interval(9, 10));
        list.add(new Interval(1, 3));
        System.out.println(canAttendMeetings(list));
        list = new ArrayList<>();
        list.add(new Interval(5, 8));
        list.add(new Interval(9, 10));
        list.add(new Interval(1, 10));
        System.out.println(canAttendMeetings(list));
    }
}
