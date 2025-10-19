import java.util.*;

public class AccountsMerge {

    private static void union(Map<String, String> map, String a, String b) {
        String pa = find(map, a);
        String pb = find(map, b);
        if (!pa.equals(pb)) {
            map.put(pb, pa);
        }
    }

    private static String find(Map<String, String> map, String child) {
        if (!map.containsKey(child)) {
            map.put(child, child);
            return child;
        }
        String parent = map.get(child);
        if (!parent.equals(child)) {
            parent = find(map, parent);
            map.put(child, parent);
        }
        return parent;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> names = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                union(map, account.get(1), account.get(i));
                names.put(account.get(i), account.getFirst());
            }
        }

        Map<String, TreeSet<String>> unify = new HashMap<>();
        for (String email : map.keySet()) {
            String parent = find(map, map.get(email));
            TreeSet<String> set = unify.getOrDefault(parent, new TreeSet<>());
            set.add(email);
            unify.put(parent, set);
        }

        List<List<String>> result = new ArrayList<>(unify.size());
        int i = 0;
        for (String rootEmail : unify.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(names.get(rootEmail));
            for (String email : unify.get(rootEmail)) {
                list.add(email);
            }
            result.add(list);
        }

        return result;
    }

//    beats 32.46% memory 21.62 runtime 38ms

    public static void main(String[] args) {
//        System.out.println(accountsMerge(List.of(
//                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
//                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
//                List.of("Mary", "mary@mail.com"),
//                List.of("John", "johnnybravo@mail.com")
//        )));
        System.out.println(accountsMerge(List.of(
                List.of("David","David0@m.co","David1@m.co"),
                List.of("David","David3@m.co","David4@m.co"),
                List.of("David","David4@m.co","David5@m.co"),
                List.of("David","David2@m.co","David3@m.co"),
                List.of("David","David1@m.co","David2@m.co")
        )));
    }
}
