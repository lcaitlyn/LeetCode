import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

//    public static int totalFruit(int[] fruits) {
//        int res = 0;
//        int total = 0;
//        int l = 0, r = 0;
//        Map<Integer, Integer> map = new HashMap();
//
//        while (r < fruits.length) {
//            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
//            total++;
//
//            while (map.size() > 2) {
//                map.put(fruits[l], map.get(fruits[l]) - 1);
//                if (map.get(fruits[l]) == 0)
//                    map.remove(fruits[l]);
//                total--;
//                l++;
//            }
//            res = Math.max(res, total);
//            r++;
//        }
//        return res;
//    }

//    beats 20.28% memory 5.01% runtime 54ms
//    решил с первого раза, но почему то он медленный мб переделать HashMap -> int[]

//    public static int totalFruit(int[] fruits) {
//        int res = 0, total = 0, size = 0;
//        int l = 0, r = 0;
//        int[] map = new int[100001];
//
//        while (r < fruits.length) {
//            if (map[fruits[r]] == 0)
//                size++;
//            map[fruits[r]]++;
//            total++;
//
//            while (size > 2) {
//                map[fruits[l]]--;
//                if (map[fruits[l]] == 0)
//                    size--;
//                total--;
//                l++;
//            }
//            res = Math.max(res, total);
//            r++;
//        }
//        return res;
//    }

//    beats 91.77% memory 5.01% runtime 9ms
//    ахуеть мапа медленная
//    по памяти проседаем, хочу поменять мапу на int[2]

    public static int totalFruit(int[] fruits) {
        int res = 0, total = 0;
        int r = 0;
        int[] map = new int[2];
        map[0] = -1;
        map[1] = -1;

        while (r < fruits.length) {
            if (map[0] == -1) {
                map[0] = fruits[r];
            } else if (map[1] == -1 && map[0] != fruits[r]) {
                map[1] = fruits[r];
            }
            if (map[0] != fruits[r] && map[1] != fruits[r]) {
                total = 0;
                int l = r - 1;
                while (fruits[l] == fruits[r - 1]) {
                    total++;
                    l--;
                }
                map[0] = fruits[r - 1];
                map[1] = fruits[r];
            }
            total++;
            res = Math.max(res, total);
            r++;
        }
        return res;
    }

//    beats 93.9% memory 5.01% runtime 7ms
//    пиздец память вообще не изменилась лол

    public static void main(String[] args) {
//        System.out.println("4 -> " + totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println("4 -> " + totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
