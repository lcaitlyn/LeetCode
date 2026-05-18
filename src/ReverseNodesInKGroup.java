public class ReverseNodesInKGroup {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;

        ListNode res = null;
        ListNode node = head;

        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        node = null;

        ListNode reversedTail = head;
        for (int i = 0; i < k; i++) {
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        res = node;

        reversedTail.next = head;
        ListNode tail = reversedTail;

        while (true) {
            node = head;
            for (int i = 0; i < k; i++) {
                if (node == null) return res;
                node = node.next;
            }

            node = null;
            reversedTail = head;
            for (int i = 0; i < k; i++) {
                ListNode tmp = head.next;
                head.next = node;
                node = head;
                head = tmp;
            }

            tail.next = node;
            reversedTail.next = head;
            tail = reversedTail;
        }
    }

//    runtime 1ms, beats 29% memory 79%
//    странно что рантайм 1мс
}
