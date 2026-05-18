public class LinkedListCycleII {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;

            if (fast == null) return null;
            if (slow == fast) break;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

//    beats 100% runtime 0ms memory 30%
//    ну решил быстро, потому что по аналогии задача с https://leetcode.com/problems/find-the-duplicate-number/
}
