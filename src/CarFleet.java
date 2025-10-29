import java.util.*;

public class CarFleet {

//    бля вообще задача пиздец чет сложная для понимания нах
//


//    public static int carFleet(int target, int[] position, int[] speed) {
//        double[] time = new double[position.length];
//        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int i = 0; i < position.length; i++) {
//            time[i] = (double)(target - position[i]) / speed[i];
//            map.put(position[i], i);
//            pq.add(position[i]);
//        }
//
//        int res = 0;
//        double maxTime = 0;
//        while (!pq.isEmpty()) {
//            double curTime = time[map.get(pq.poll())];
//            if (curTime > maxTime) {
//                res++;
//                maxTime = curTime;
//            }
//        }
//
//        return res;
//    }

//    beats 5.10% memory 5.10% runtime 180ms
//    мб переделать на TreeMap?

//    чатик подсказал сделать так:
//        int n = position.length;
//            int[][] cars = new int[n][2];
//        for (int i = 0; i < n; i++) {
//                cars[i][0] = position[i]; // позиция
//                cars[i][1] = speed[i];    // скорость
//            }
//
//        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i]; // позиция
            cars[i][1] = speed[i]; // скорость
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double[] time = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        int res = 0; double maxTime = 0;
        for (int i = 0; i < position.length; i++) {
            double curTime = time[i];
            if (curTime > maxTime) {
                res++;
                maxTime = curTime;
            }
        }

        return res;
    }

//    beats 79.82% memory 85.14% runtime 75ms
//    спасибо чату


    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
        System.out.println(carFleet(100, new int[]{8,3,7,4,6,5}, new int[]{4,4,4,4,4,4}));
    }
}
