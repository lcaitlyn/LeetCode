import java.util.LinkedList;
import java.util.Queue;

public class ImplementQueueUsingStacks {

    private static class MyQueue {

        private Queue<Integer> queue;

        public MyQueue() {
            queue = new LinkedList<>();
        }
        
        public void push(int x) {
            queue.add(x);
        }
        
        public int pop() {
            return queue.poll();
        }
        
        public int peek() {
            return (queue.isEmpty()) ? 0 : queue.peek();
        }
        
        public boolean empty() {
            return queue.isEmpty();
        }
    }
    
    
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        System.out.println(obj.peek());
        // int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + " " + " " + param_4);

    }
}
