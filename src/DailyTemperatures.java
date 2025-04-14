import java.util.*;

public class DailyTemperatures {

    // public static int[] dailyTemperatures(int[] temperatures) {
    //         int [] res = new int [temperatures.length];

    //         List<Integer> list = new ArrayList<>();
    //         for (int i = 0; i < temperatures.length; i++) {
    //             if (!list.isEmpty()) {
    //                 List<Integer> arr = new ArrayList<>();
    //                 for (Integer t : list) {
    //                     if (temperatures[t] < temperatures[i]) {
    //                         res[t] = i - t;
    //                         arr.add(t);
    //                     }
    //                 }
    //                 for (Integer t : arr) {
    //                     list.remove(t);
    //                 }
    //             }
    //             list.add(i);
    //         }

    //         return res;
    // }

    // Ну собственно TLE. О чем я +- и догадывался, стоит как-то подумать
    // вариант с тем чтобы брать минимального очень интересно подходит
    // конечно есть варик заменить мой лист на мапу листов, но тоже думаю не очень эффективно
    // по всем ключам мапы проходится. Но стоит попробовать че

    // public static int[] dailyTemperatures(int[] temperatures) {
    //     int [] res = new int [temperatures.length];

    //     TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    //     for (int i = 0; i < temperatures.length; i++) {
    //         if (!map.isEmpty()) {
    //             int min = map.firstKey();
    //             while (!map.isEmpty() && min < temperatures[i]) {
    //                 List<Integer> arr = map.get(min);
    //                 for (Integer j : arr) {
    //                     res[j] = i - j;
    //                 }
    //                 map.remove(min);
    //                 if (!map.isEmpty()) {
    //                     min = map.firstKey();
    //                 }
    //             }
    //         }
    //         List<Integer> list = map.getOrDefault(temperatures[i], new ArrayList<>());
    //         list.add(i);
    //         map.put(temperatures[i], list);
    //     }

    //     return res;
    // }

    // АХхаах ну и говнокод нахуй )
    // runtime 88ms beats 5%. ну хотя бы запускается блять и по памяти beats 98%
    // вообще конечно очень хуевенько думаешь как решить эту залупную задачу
    // начни думать ебать

    // думать не начал, посмотрел решение. хз как я до него не додумался ебать
    // проблема была что я не догадался в Stack<> закинуть int[](2)
    // где int[0] - значение int[1] - индекс

    // public static int[] dailyTemperatures(int[] temperatures) {
    //     Stack<int []> s = new Stack<>();
    //     int [] res = new int[temperatures.length];

    //     s.add(new int[]{temperatures[0], 0});
    //     for (int i = 1; i < temperatures.length; i++) {
    //         while (!s.isEmpty() && s.peek()[0] < temperatures[i]) {
    //             res[s.peek()[1]] = i - s.peek()[1];
    //             s.pop();
    //         }
    //         s.add(new int[]{temperatures[i], i});
    //     }

    //     return res;
    // }

    // Эмм блять по рантайму нихуя не изменилос 84ms beats 11%. memory 99% вообще
    // time complexity O(n). а чего так хуево тогда то

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int [] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                res[s.peek()] = i - s.peek();
                s.pop();
            }
            s.add(i);
        }

        return res;
    }

    // хз крч че за ебала там на литкоде, но это просто пиздец


    private static void print(int [] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
    }
}
