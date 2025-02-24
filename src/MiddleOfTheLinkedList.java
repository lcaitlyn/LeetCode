
public class MiddleOfTheLinkedList {

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

    // Так ну при решении этой задачи, самое простое решение которое риходит в голову
    // это просто перебрать все значения, найти длину листа и уже исходя
    // из неё вычислить середину, пройтись до середины и вернуть элемент.
    // Конечно, так можно сделать, но в голову уже приходит сразу более оптимальное решение. 
    // Стоит ответить на вопрос: "а что такое середина?". Скорее всего она работает по какой-то формуле,
    // потому что у каждого числа мы можем вычислить её. Решение, которое приходит на ум - 
    // это идти по всем элемент, параллельно вычисляя значение середины и сразу же иметь
    // второй указатель на середину, и при достижении конца листа, сразу же вернуть это значени.
    // Думаю начать с простого решения, возможно что-то еще придет в голову.

    // public static ListNode middleNode(ListNode head) {
    //     int size = 0;
    //     ListNode tmp = head;

    //     while (tmp != null) {
    //         size++;
    //         tmp = tmp.next;
    //     }

    //     tmp = head;
    //     int i = 1;
    //     while (i < size / 2 + 1) {
    //         tmp = tmp.next;
    //         i++;
    //     }

    //     return tmp;
    // }

    // Результат: runtime 100%, memory 13.24%
    // Да, скорее всего решение с двумя указателями увеличит результат memory

    // Начал решать немного, но понял что моё решение, которое я описал раньше было
    // немного не правильным. Я нашел новую закономерность, при которое мидл сдвигается
    // мы сдвигаем мидл каждые 2 шага. т.е для массива длинной 4 или 5 мидл будет 3.
    // для массива 6 или 7 будет 4. и так далее. каждый раз он сдвигается на 1 при увелечении массива на два;
    // Осталось только закодировать это. 

    public static ListNode middleNode(ListNode head) {
        ListNode tmp = head;
        ListNode res = tmp;

        int key = 0;
        while (tmp != null) {
            tmp = tmp.next;
            key++;
            if (key % 2 == 0) {
                res = res.next;
            }
        }

        return res;
    }

    // Результат: 100% tc, me: 43.16%
    // Уже лучше. Идей как улучшить, пока нет. Загляну в решения
    // Решение по лучше как оказалось использова fast и slow поинтеры, которые я 
    // использовал в LinkedListCycle. По сути тоже самое один поинтер быстрее, другой медленее.
    // Конечно в голове проскользнула такая идея, использовать это, но что-то я не 
    // развил её.


    public static void main(String[] args) {
        ListNode head = createList(new int[] {1, 2, 3, 4});
        printList(head);
        System.out.println(middleNode(head).val);
    }
}

