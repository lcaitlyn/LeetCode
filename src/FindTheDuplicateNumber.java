public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) return slow;
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{18,13,14,17,9,19,7,17,4,6,17,5,11,10,2,15,8,12,16,17}));
    }

//    задача полная залупа.
//    реши https://leetcode.com/problems/linked-list-cycle-ii/description/
//    если не понял как решать эту

}
