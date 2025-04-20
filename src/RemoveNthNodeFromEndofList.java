import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndofList {

    public static class ListNode {
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
    
    // private List<ListNode> getList(ListNode head) {
    //     List<ListNode> list = new ArrayList<>();

    //     while (head != null) {
    //         list.add(head);
    //         head = head.next;
    //     }

    //     return list;
    // }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if (head == null) return null;

    //     List<ListNode> list = getList(head);
    //     int i = list.size() - n;
        
    //     if (i == 0) {
    //         return (list.size() != 1) ? list.get(0).next : null;
    //     }

    //     ListNode tmp = list.get(i - 1);
    //     tmp.next = tmp.next.next;

    //     return list.get(0);
    // }

    // Результат: 0ms, beats 100%. memory 25% Хз конечно правильно ли я сделал свой варик
    // потому что думаю там надо было использова fast и slow

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        if (n == 0) return slow.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    // Результат: 0ms, beats 100%. memory 75% по мемаре улучшил прилу теперь по мемори O(1)

    public static void main(String[] args) {
        ListNode a = createList(new int[]{1, 2});
        printList(removeNthFromEnd(a, 2));
    }

    private static void printList(ListNode list) {
        ListNode tail = list;

        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.next;
        }
        System.out.println();
    }

    private static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head.next;
    }
}
