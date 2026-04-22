import java.util.*;

public class CouponCodeValidator {

    private static boolean isValidCode(String code) {
        if (code.isEmpty()) return false;

        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    private static void fillList(List<String> list, TreeMap<String, Integer> map) {
        for (String key : map.keySet()) {
            int k = map.get(key);
            for (int i = 0; i < k; i++) {
                list.add(key);
            }
        }
    }

//    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
//        TreeMap<String, Integer> electronics = new TreeMap<>();
//        TreeMap<String, Integer> grocery = new TreeMap<>();
//        TreeMap<String, Integer> pharmacy = new TreeMap<>();
//        TreeMap<String, Integer> restaurant = new TreeMap<>();
//
//        for (int i = 0; i < code.length; i++) {
//            if (!isActive[i] || !isValidCode(code[i])) continue;
//
//            if (businessLine[i].equals("electronics")) {
//                electronics.put(code[i], electronics.getOrDefault(code[i], 0) + 1);
//            }
//            if (businessLine[i].equals("grocery")) {
//                grocery.put(code[i], grocery.getOrDefault(code[i], 0) + 1);
//            }
//            if (businessLine[i].equals("pharmacy")) {
//                pharmacy.put(code[i], pharmacy.getOrDefault(code[i], 0) + 1);
//            }
//            if (businessLine[i].equals("restaurant")) {
//                restaurant.put(code[i], restaurant.getOrDefault(code[i], 0) + 1);
//            }
//        }
//
//        List<String> list = new ArrayList<>();
//        fillList(list, electronics);
//        fillList(list, grocery);
//        fillList(list, pharmacy);
//        fillList(list, restaurant);
//        return list;
//    }

//    beats 74.55%, memory 26.66% runtime 9ms

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i] || !isValidCode(code[i])) continue;

            if (businessLine[i].equals("electronics")) {
                electronics.add(code[i]);
            }
            if (businessLine[i].equals("grocery")) {
                grocery.add(code[i]);
            }
            if (businessLine[i].equals("pharmacy")) {
                pharmacy.add(code[i]);
            }
            if (businessLine[i].equals("restaurant")) {
                restaurant.add(code[i]);
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> list = new ArrayList<>();
        list.addAll(electronics);
        list.addAll(grocery);
        list.addAll(pharmacy);
        list.addAll(restaurant);
        return list;
    }

//    beats 93.64% memory 47.27% runtime 6ms

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        TreeSet<String> set = new TreeSet<>();

        pq.add("We0rOzWCZ1");
        pq.add("GyFpNFw0ER");
        pq.add("56irw4f6Kh");

        set.add("We0rOzWCZ1");
        set.add("GyFpNFw0ER");
        set.add("56irw4f6Kh");

        System.out.println(pq);
        System.out.println(set);
    }
}
