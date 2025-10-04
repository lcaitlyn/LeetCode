import java.util.*;

public class TopKFrequentWords {

//    public static List<String> topKFrequent(String[] words, int k) {
//        TreeMap<String, Integer> map = new TreeMap<>();
//        TreeSet<Integer> set = new TreeSet<>();
//        int max = 0;
//
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//            set.add(map.get(word));
//        }
//
//        List<String> list = new ArrayList<>();
//        while (k > 0) {
//            int last = set.pollLast();
//            for (String word : map.keySet()) {
//                if (map.get(word) == last) {
//                    list.add(word);
//                    k--;
//                }
//                if (k == 0) return list;
//            }
//        }
//
//        return list;
//    }

//  beats 6.85%, 12ms memory 55%
//    решал так, я еще не знаю про Heap(Min heap, max heap, priority queue)
//    сейчас почитаю и порешаю на эту тему, потом вернусь и сделаю эффективнее решение


    public static List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curSize = 0;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (!pq.contains(map.get(word))) {
                pq.add(map.get(word));
                curSize++;
                while (curSize > k) {
                    pq.poll();
                    curSize--;
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            int i = pq.poll();
            for (String word : map.keySet()) {
                if (map.get(word) == i) {
                    list.add(word);
                    k--;
                }
                if (k == 0) return list;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
    }
}
