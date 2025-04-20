import java.util.ArrayList;
import java.util.List;

public class ReorderList {

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


    // крч думал будет не особо трудная задача, но усложнилась когда я увидел
    // что нам нужно не вернуть новый лист, а изменить текущий 
    // постараюсь сделать самый тупой и примитивный метод

    // private ListNode getPrevTail(ListNode head) {
    //     if (head == null || head.next == null) return null;
    //     while (head.next.next != null) {
    //         head = head.next;
    //     }
    //     return head;
    // }

    // private void reorder(ListNode head, ListNode prev) {
    //     if (head == null || prev == null || prev.next == null || head == prev) return;

    //     ListNode next = head.next;
    //     ListNode tail = prev.next;
    //     tail.next = next;
    //     head.next = tail;
    //     prev.next= null;

    //     reorder(next, getPrevTail(next));
    // }

    // public void reorderList(ListNode head) {
    //     reorder(head, getPrevTail(head));
    // }

    // Резульат: 389 ms beats 5.43%
    // вот мой тупой вариант, хотя я его и сделал даже через рекурсию
    // ну оно и логично, потому что тут O(N^2) по моему. 
    // Лол литкод показал O(n), но я думаю он ошибается

    // Ладно, как я могу ускорить всю эту хрень? Возмоджно использовать что-нибудь
    // Как то проиндексировать это говнище

    // Нет, походу я додумался. Мысль конечно такая уже была, но все же я щас развил её
    // Я создам вторую хрень только reversed. и буду брать из нормально и обратной по одной
    // пока указатели не будут указывать сами на себя.

    // Ахах, вроде такое крутое и простое решение, но когда я делаю обратный цикл, он меняет основной
    // и из-за этого не работает нихуя

    // значит нужно че-то придумать с рекурсией


//    private static List<ListNode> makeList(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head);
//            head = head.next;
//        }
//        return list;
//    }
//
//    public static void reorderList(ListNode head) {
//        if (head == null || head.next == null || head.next.next == null) return;
//
//        List<ListNode> list = makeList(head);
//        int l = 0;
//        int r = list.size() - 1;
//        while (r - l > 1) {
//            ListNode h = list.get(l);
//            ListNode t = list.get(r);
//            h.next = t;
//            l++;
//            t.next = list.get(l);
//            r--;
//        }
//        ListNode n = list.get(r);
//        n.next = null;
//    }

    //  Результат 4 ms beats 12.14%. Пиздец блять.
    //  Вот тут думаю O(n) точно, точнее O(2n), но странно что скорость такая слабая, значит че то есть
    //  еще поинтереснее. Думаю это точно с рекусией

    private static ListNode reverse(ListNode head, ListNode tail) {
        if (head.next == null) {
            head.next = tail;
            return head;
        }

        ListNode tmp = head.next;
        head.next = tail;

        return reverse(tmp, head);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode tail = reverse(findMiddle(head.next), null);

        ListNode headNext = head.next;
        ListNode tailNext = tail.next;
        while (head.next != null && tail.next != null) {
            headNext = head.next;
            tailNext = tail.next;
            head.next = tail;
            tail.next = headNext;
            head = headNext;
            tail = tailNext;
        }
    }

    // бля кайф, 2ms beats 86%. Все таки сделал первоначальный вариант, только тут O(n + log2n), вместо O(n + n)

    public static void main(String[] args) {
        ListNode a = createList(new int[]{1, 2, 3, 4, 5});
        reorderList(a);
        printList(a);
        printList(findMiddle(createList(new int[]{1, 2, 3, 4, 5, 6})));
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
