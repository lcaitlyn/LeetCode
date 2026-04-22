import java.util.*;

public class CountMentionsPerUser {

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort(
                Comparator.comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
                        .thenComparing(e -> e.get(0).equals("OFFLINE") ? 0 : 1)
        );

        int[] res = new int[numberOfUsers];
        int[] map = new int[numberOfUsers]; // <id, time>
        TreeMap<Integer, Set<Integer>> timeMap = new TreeMap<>(); // <time + 60, List.of(id)>
        int allCount = 0;

        for (List<String> event : events) {
            int timestamp = Integer.parseInt(event.get(1));
            if (event.get(0).startsWith("M")) {
                if (event.get(2).startsWith("A")) {
                    allCount++;
                } else if (event.get(2).startsWith("H")) {
                    allCount++;

                    while (!timeMap.isEmpty() && timeMap.firstKey() + 60 <= timestamp) {
                        timeMap.remove(timeMap.firstKey());
                    }

                    for (Integer key: timeMap.keySet()) {
                        for (int id : timeMap.get(key)) {
                            res[id]--;
                        }
                    }
                } else {
                    String[] users = event.get(2).split(" ");

                    for (String user : users) {
                        int id = Integer.parseInt(user, 2, user.length(), 10);
                        res[id]++;
                    }
                }
            } else {
                int id = Integer.parseInt(event.get(2));
                if (map[id] != 0) {
                    Set<Integer> users = timeMap.getOrDefault(map[id], new HashSet<>());
                    users.remove(id);
                }
                map[id] = timestamp;
                Set<Integer> users = timeMap.getOrDefault(timestamp, new HashSet<>());
                users.add(id);
                timeMap.put(timestamp, users);
            }
        }

        for (int i = 0; i < numberOfUsers; i++) {
            res[i] += allCount;
        }

        return res;
    }

//    beats 29.6% memory 5.60% runtime 38ms

    public static void main(String[] args) {
        List<List<String>> events;
        events = List.of(List.of("MESSAGE","10","id1 id0"), List.of("OFFLINE","11","0"), List.of("MESSAGE","71","HERE"));
//        System.out.println(Arrays.toString(countMentions(2, events)));
        events = List.of(List.of("MESSAGE","2","HERE"), List.of("OFFLINE","2","1"), List.of("OFFLINE","1","0"), List.of("MESSAGE","61","HERE"));
        events = new ArrayList<>(List.of(
                new ArrayList<>(List.of("MESSAGE","2","HERE")),
                new ArrayList<>(List.of("OFFLINE","2","1")),
                new ArrayList<>(List.of("OFFLINE","1","0")),
                new ArrayList<>(List.of("MESSAGE","61","HERE"))
        ));
//        System.out.println(Arrays.toString(countMentions(3, events)));
        events = new ArrayList<>(List.of(
                new ArrayList<>(List.of("MESSAGE","70","HERE")),
                new ArrayList<>(List.of("OFFLINE","10","0")),
                new ArrayList<>(List.of("OFFLINE","71","0"))
        ));
//        System.out.println(Arrays.toString(countMentions(2, events)));
        events = new ArrayList<>(List.of(
                new ArrayList<>(List.of("MESSAGE","174","HERE")),
                new ArrayList<>(List.of("OFFLINE","426","0")),
                new ArrayList<>(List.of("MESSAGE","98","ALL")),
                new ArrayList<>(List.of("MESSAGE","383","ALL")),
                new ArrayList<>(List.of("MESSAGE","178","id13 id1 id6 id0 id8 id6 id0")),
                new ArrayList<>(List.of("OFFLINE","474","10")),
                new ArrayList<>(List.of("MESSAGE","190","ALL")),
                new ArrayList<>(List.of("MESSAGE","190","HERE")),
                new ArrayList<>(List.of("MESSAGE","366","ALL")),
                new ArrayList<>(List.of("OFFLINE","113","4")),
                new ArrayList<>(List.of("MESSAGE","130","HERE")),
                new ArrayList<>(List.of("OFFLINE","299","10")),
                new ArrayList<>(List.of("OFFLINE","352","8")),
                new ArrayList<>(List.of("MESSAGE","167","id12 id13 id2 id10")),
                new ArrayList<>(List.of("MESSAGE","120","ALL")),
                new ArrayList<>(List.of("MESSAGE","175","ALL")),
                new ArrayList<>(List.of("OFFLINE","150","2")),
                new ArrayList<>(List.of("MESSAGE","124","ALL")),
                new ArrayList<>(List.of("OFFLINE","70","13"))
        ));
//        System.out.println(Arrays.toString(countMentions(15, events)));
        events = new ArrayList<>(List.of(
                new ArrayList<>(List.of("OFFLINE","10","0")),
                new ArrayList<>(List.of("MESSAGE","12","HERE"))
        ));
        System.out.println(Arrays.toString(countMentions(2, events)));
        PriorityQueue<String> pharmacy = new PriorityQueue<>();
        PriorityQueue<String> restaurant = new PriorityQueue<>();
        pharmacy.add("We0rOzWCZ1");
        pharmacy.add("GyFpNFw0ER");
        pharmacy.add("56irw4f6Kh");
        List<String> list = new ArrayList<>();
        list.addAll(pharmacy);
        System.out.println(list);
    }
}
