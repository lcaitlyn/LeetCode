import java.util.*;

public class MaximumFrequencyStack {

    private static class FreqStack {

        private final Map<Integer, Integer> freq;
        private final Map<Integer, Stack<Integer>> map;
        private int maxFreq;

        public FreqStack() {
            freq = new HashMap<>();
            map = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int f = freq.getOrDefault(val, 0) + 1;
            freq.put(val, f);
            maxFreq = Math.max(maxFreq, f);
            map.putIfAbsent(f, new Stack<>());
            map.get(f).push(val);
        }

        public int pop() {
            int res = map.get(maxFreq).pop();
            freq.put(res, maxFreq - 1);
            if (map.get(maxFreq).isEmpty()) maxFreq--;
            return res;
        }
    }

//    runtime 35ms beats 38.34% memory 52.45%
//    ну бля очень долго к этому решению шел (минут 5), а потом в ответы зашел и сразу понятно всё стало

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
