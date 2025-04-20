import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode createList(int [] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
        }
        return head.next;
    }

    public static void printList(ListNode list) {
        ListNode tail = list;

        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.next;
        }
        System.out.println();
    }

    // Попробую написать самое просто и решение, которое приходит в голову
    // Это будет брутфорс думаю. Просто запишу все значения в List, а затем в обратном порядке
    // Пройдут и создам новый Лист
    //
    // public static ListNode reverseList(ListNode head) {
    //     if (head == null) return null;

    //     ListNode tail = head;
    //     List<Integer> list = new ArrayList<>();
    //     while (tail != null) {
    //         list.add(tail.val);
    //         tail = tail.next;
    //     }

    //     ListNode result = new ListNode();
    //     tail = result;
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         tail.next = new ListNode(list.get(i));
    //         tail = tail.next;
    //     }
    //     return result.next;
    // }
    // 
    // Результат: Runtime Beats 5.35%, Memory Beats 5.88%
    // 
    // Не в печатляюще, значит есть (хотя сразу понятно было), что есть решение лучше
    // Скорее всего это через 2 указателя
    /* 
    public static ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode tmp;

        while (head != null) {
            tmp = tail;
            tail = head;
            head = head.next;
            tail.next = tmp;
        }

        return tail;
    }
    */
    // Так ну это решение уже лучше.
    // Что я тут сделал. Я создал хвост, который будет указывать на Хэд и записывать себя в свой
    // хвост. Сложно так объяснить и расписать. Надеюсь поймешь
    // 
    // Результат: RunTime beats 100%, memory beats 39.09%


    // Еще есть способо через рекурсию. Нужно попробовать её реализовать.

    // Так. Ну и как его сделать?
    // Так как нам всегда прилетает голова, мы можем сокращать нашу голову, а 
    // Остаток записывать в хвост и заново запускать.
    // Точнее будем брать число и записывать его в хвост, и так каждое число будет новым хвостом

    private static ListNode getTail(ListNode head, ListNode tail) {
        if (head.next == null) {
            head.next = tail;
            return head;
        }

        ListNode tmp = head.next;
        head.next = tail;
        
        return getTail(tmp, head);
    }

    public static ListNode reverseList(ListNode head) {
        return (head != null) ? getTail(head, null) : null;
    }

    // реализовал через рекурсию
    // Когда мы дойдем до конца, то мы вернем наш хвост,
    // Пока мы не дошли до конца мы будем записывать в хвост число из хэда
    // 
    // Результат: RunTime beats 100%, memory beats 98.22%


    public static void main(String[] args) {
        ListNode list1 = createList(new int[]{1,2,3,4,5});
        ListNode list2 = createList(new int[]{1,3,3,4,6});
        printList(reverseList(list1));
        printList(reverseList(list2));
    }
}
