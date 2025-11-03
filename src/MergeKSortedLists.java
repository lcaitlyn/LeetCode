import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists[0] == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode root = new ListNode();
        ListNode node = root;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            node.next = tmp;
            node = node.next;
            if (tmp.next != null) pq.add(tmp.next);
        }
        node.next = null;

        return root.next;
    }

//    beats 20% memory 5.15% runtime 8ms
//
//    решить при помощи: Divide And Conquer
//

    public static void main(String[] args) {
        mergeKLists(new ListNode[]{new ListNode(3), new ListNode(1), new ListNode(2)});
    }
}
