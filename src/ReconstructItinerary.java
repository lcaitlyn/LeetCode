import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for (List<String> t : tickets) {
            Map<String, Integer> m = map.getOrDefault(t.get(0), new HashMap<>());
            m.put(t.get(1), m.getOrDefault(t.get(1), 0) + 1);
            map.put(t.get(0), m);
        }

        Map<String, Integer> m = map.get("JFK");

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<List<String>> list = List.of(List.of("MUC","LHR"), List.of("JFK","MUC"), List.of("SFO","SJC"), List.of("LHR","SFO"));
        findItinerary(list);
    }
}
