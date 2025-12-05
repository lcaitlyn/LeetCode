import java.util.List;

public class PalindromeLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    так вот тут щас пытался че нибудь придумать
//    думал насчёт быстрого и медленного указатель, по медленному разворачивать всю эту парашу
//    и потом заного пройтись сравнивая развернутый с серединой
//    но пока думал пришла идея как сделать брутфорсом за O(n^2)

//    private boolean solution(ListNode head, ListNode last) {
//        if (head == null) return true;
//
//        ListNode prev = head;
//        while (prev.next != last) {
//            prev = prev.next;
//        }
//
//        if (head.val != prev.val) return false;
//
//        return solution(head.next, prev);
//    }

//     upd 20.11.2025
//    что если изменить изначальный массив, а точнее его указатели
//    мб стоит пройтись 1 раз посчитать его размер и уже отцентра изменить его
//    крч вместо такого: 1 -> 2 -> 3 -> 2 -> 1
//    сделать вот так:   1 <- 2 <- 3 -> 2 -> 1
//    сделать вот так:   1 <- 2 <- 3 -> 3 -> 2 -> 1
//    получится тот же самый Expand From Centre
//    только из одного указателям мы не можем пойти в 2 стороны
//    сделать типо так что ли 1 <- 2 <- 3 <- L  R -> 3 -> 2 -> 1
//                            1 <- 2 <- L  R -> 2 -> 1
//    вопрос лишь как сделать эти два указателя

    public int getSize(ListNode head) {
        if (head == null) return 0;
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        int size = getSize(head);
        if (size == 1) return true;

        ListNode left;
        ListNode right = head;
        for (int i = 0; i < (size - 1) / 2; i++) {
            ListNode tmp = right.next;
            tmp.next = right;
            right.next.next =
        }
    }
}
