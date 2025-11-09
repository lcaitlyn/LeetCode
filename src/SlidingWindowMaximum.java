import java.util.*;

public class SlidingWindowMaximum {

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length - k + 1;
//        int[] res = new int[nums.length - k + 1];
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//
//        for (int i = 0; i < k; i++) pq.add(nums[i]);
//
//        int l = 0, r = k;
//        for (int i = 0; i < n; i++) {
//            res[i] = pq.peek();
//            pq.remove(nums[l++]);
//            if (r < nums.length) pq.add(nums[r++]);
//        }
//
//        return res;
//    }

//    TLE
//    так ну тут медленная (что и ожидалось), но я думал хотя бы пройдет

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length - k + 1;
//        int[] res = new int[n];
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        int l = 0, r = 1, i = 0;
//        deque.add(0);
//        while (r < nums.length) {
//            if (r - l == k) {
//                res[i++] = nums[deque.getFirst()];
//                if (l == deque.getFirst()) {
//                    deque.removeFirst();
//                }
//                l++;
//            }
//            if (!deque.isEmpty()) {
//                if (nums[deque.getLast()] > nums[r]) deque.add(r);
//                if (nums[deque.getFirst()] < nums[r]) deque.clear();
//                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[r]) {
//                    deque.removeLast();
//                }
//            }
//            deque.add(r);
//            r++;
//        }
//        while (i < n) res[i++] = nums[deque.getFirst()];
//
//        return res;
//    }

//    beats 21.20% memory 5.25% runtime 40ms
//    beats 16.26% memory 6.54% runtime 49ms
//    пиздец ну и почему он медленный? делал вроде по гайду от гпт, он мне там подсказал как решать это говно
//    поменял LinkedList на ArrayDeque
//
//    ладно тут я просто криворукий, и нужно действия поменять местами, спрва добавлять и чекать, а потом считать res

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }

            deque.addLast(r);

            if (deque.getFirst() <= r - k) {
                deque.removeFirst();
            }

            if (r >= k - 1) {
                res[r - k + 1] = nums[deque.getFirst()];
            }
        }

        return res;
    }

//    beats 85% memory 6.23% runtime 29ms
//    это решение чата ГПТ

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
    }
}
