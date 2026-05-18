import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        List<Node> list = new ArrayList<>();
        Map<Node, Integer> map = new HashMap<>();
        Node node = head;
        Node newHead;
        Node newNode = new Node(-1);
        newHead = newNode;

        int i = 0;
        while (node != null) {
            Node tmp = new Node(node.val);
            list.add(tmp);
            map.put(node, i);
            newNode.next = tmp;
            newNode = newNode.next;
            node = node.next;
            i++;
        }

        node = head;
        newNode = newHead.next;
        while (node != null) {
            if (node.random == null) {
                newNode.random = null;
            } else {
                newNode.random = list.get(map.get(node.random));
            }
            newNode = newNode.next;
            node = node.next;
        }

        return newHead.next;
    }

//    0ms beats 100% memory 35%
//    как то по приколу решил сам (сразу мапу и лист применил, в ответах вроде так же)
}
