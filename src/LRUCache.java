import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> map = new HashMap<>();
    private int capacity;
    private Deque<Integer> deque = new ArrayDeque<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        update(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            removeLast();
        }
        update(key);
        map.put(key, value);
    }

    private void update(int key) {
        deque.remove(key);
        deque.add(key);
    }

    private void removeLast() {
        if (!deque.isEmpty()) {
            map.remove(deque.pollFirst());
        }
    }
}
