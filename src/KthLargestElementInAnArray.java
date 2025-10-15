import java.util.Arrays;
import java.util.PriorityQueue;

//public class KthLargestElementInAnArray {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int size = 0;
//
//        for (int i : nums) {
//            pq.add(i);
//            size++;
//            if (size > k) {
//                pq.poll();
//                size--;
//            }
//        }
//
//        return pq.poll();
//    }

//    beats 56% 60ms, memory 22%
//    видимо че то быстрее можно придумать, а не просто через PriorityQueue

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

//    beats 94.52% memory 87% runtime 22ms. Пиздец и эта хуйня еще быстрее
}
