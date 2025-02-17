
public class LinkedListCycle {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // создаем Лист Нод
    private static ListNode createList(int [] arr) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }

    // печатаем лист
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    // Создаем цикл. Условия, чтобы создать цикл: pos < head.size; head != null;
    // Не стал добавлять проверки, чтобы не тратить время.
    private static ListNode makeCycle(ListNode head, int pos) {
        ListNode tail = head;
        ListNode target = head;
        int i = 0;
        while (tail.next != null) {
            if (i == pos) {
                target = tail;
            }
            tail = tail.next;
            i++;
        }
        tail.next = target;

        return head;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
//        Пиздец, чет много времени убил на поиск pos, который вообще не
//        надо было искать. А я зачем то искал, а ведь в задаче
//        просто спрашивалось, про то что имеет ли цикл петлю или нет.
    }



    public static void main(String[] args) {
        ListNode head = createList(new int[] {1,2,3,4,5,6,7});
        printList(head);
        head = makeCycle(head, 2);
        System.out.println(hasCycle(head));
    }
}
