import java.util.List;

public class PalindromeLinkedList {

//    так вот тут щас пытался че нибудь придумать
//    думал насчёт быстрого и медленного указатель, по медленному разворачивать всю эту парашу
//    и потом заного пройтись сравнивая развернутый с серединой
//    но пока думал пришла идея как сделать брутфорсом за O(n^2)

    private boolean solution(ListNode head, ListNode last) {
        if (head == null) return true;

        ListNode prev = head;
        while (prev.next != last) {
            prev = prev.next;
        }

        if (head.val != prev.val) return false;

        return solution(head.next, prev);
    }

    public boolean isPalindrome(ListNode head) {
        return solution(head, null);
    }
}
