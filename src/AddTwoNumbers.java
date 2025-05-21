public class AddTwoNumbers {

    private ListNode rec(ListNode l1, ListNode l2, int num) {
        if (num == 0) {
            if (l1 == null && l2 == null) return null;

            if (l1 == null) return l2;

            if (l2 == null) return l1;
        }

        if (l1 == null && l2 == null) return new ListNode(1);

        ListNode node;
        if (l1 == null) {
            num += l2.val;
            l2 = l2.next;
        } else if (l2 == null) {
            num += l1.val;
            l1 = l1.next;
        } else {
            num += l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (num > 9) {
            node = new ListNode(num - 10);
            node.next = rec(l1, l2, 1);
        } else {
            node = new ListNode(num);
            node.next = rec(l1, l2, 0);
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return rec(l1, l2, 0);
    }

    // beats 100% runtime 1ms, memory 83%
}
