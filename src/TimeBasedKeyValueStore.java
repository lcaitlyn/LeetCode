import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    private static class TimeMap {

        private final Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> tree = map.getOrDefault(key, new TreeMap());
            tree.put(timestamp, value);
            map.put(key, tree);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> tree = map.get(key);
            if (tree == null) return "";
            Integer k = tree.floorKey(timestamp);
            if (k == null) return "";
            return tree.get(k);
        }
    }

//    beats 29.43% memory 96% runtime 154ms
//    судя по ответам это нельзя улучшить, потому что там от 130ms до 160ms средние ответы
//    делать binarySearch под это 0 желания че то

    public static void main(String[] args) {
    }
}
