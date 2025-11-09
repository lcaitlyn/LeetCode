import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

//    private final Map<Integer, Integer> map = new HashMap<>();
//    private int capacity;
//    private Deque<Integer> deque = new ArrayDeque<>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) return -1;
//
//        update(key);
//        return map.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (!map.containsKey(key) && map.size() == capacity) {
//            removeLast();
//        }
//        update(key);
//        map.put(key, value);
//    }
//
//    private void update(int key) {
//        deque.remove(key);
//        deque.add(key);
//    }
//
//    private void removeLast() {
//        if (!deque.isEmpty()) {
//            map.remove(deque.pollFirst());
//        }
//    }

//    TLE че за нахуй хули он на такой хуйне тупит
//    [[1],[6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[5],[15,15]]
//    скорее всего нужно свою реализацию писать

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {this.key = key; this.val = val;}
    }

    private final Map<Integer, Node> map;
    private final int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    private void update(Node node) {
        if (node == null) return;
        if (size == 1) return;
        if (node == head) return;
        if (node == tail) {
            Node tmp = tail.prev;
            tail.prev.next = null;
            tail.prev = null;
            tail = tmp;
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node tmp = node.next;
            node.prev.next = tmp;
            tmp.prev = node.prev;
            tmp = head;
            node.next = tmp;
            tmp.prev = node;
            head = node;
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        update(node);
        return (node == null) ? -1 : node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            update(node);
            return;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        size++;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        if (size > capacity) {
            map.remove(tail.key);
            Node tmp = tail.prev;
            tmp.next = null;
            tail.prev = null;
            tail = tmp;
        }
    }
}

//  beats 83.99% memory 5.07% runtime 43ms
// код конечно пиздец, как минимум в update() можно отрефакторить, но мне так в падлу
// итак долго откладывал решение этого говна, а тут еще че то фиксить - нет спасибо(

