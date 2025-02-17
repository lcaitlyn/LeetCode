public class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode createList(int [] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head.next;
    }

    private static void printList(ListNode list) {
        ListNode tail = list;

        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.next;
        }
        System.out.println();
    }

//    Решение через dummy


//    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null && list2 == null) return null;
//        if (list1 == null) return list2;
//        if (list2 == null) return list1;
//
//        ListNode head = new ListNode();
//        ListNode cur = head;
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        if (list1 != null) cur.next = list1;
//        if (list2 != null) cur.next = list2;
//
//        return head.next;
//    }


//    Решение рекурсией

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = createList(new int[]{1,2,3,4,5});
        ListNode list2 = createList(new int[]{1,3,3,4,6});
        printList(list1);
        printList(list2);

        ListNode result = mergeTwoLists(list1, list2);
        printList(result);
    }
}
