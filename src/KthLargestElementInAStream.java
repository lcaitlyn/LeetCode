import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private final int size;
    private int curSize;
    private final PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        pq =  new PriorityQueue<>(size);

        for (int i : nums) {
            pq.add(i);
            curSize++;
            while (curSize > size) {
                pq.poll();
                curSize--;
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        curSize++;
        if (curSize > size) pq.poll();
        return pq.peek();
    }

    // beats 83% 20ms. Memery 80%.
    // быстрее наверное только своя собственная реализация Кучи
//     Возможно стоит её и на писать...

}
