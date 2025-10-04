import java.util.*;

public class KClosestPointsToOrigin {

    private static int getSize(PriorityQueue<Double> pq, HashMap<Double, List<int[]>> map) {
        int sum = 0;
        for (double hypo : pq) {
            sum += map.get(hypo).size();
        }
        return sum;
     }

    public static int[][] kClosest(int[][] points, int k) {
        HashMap<Double, List<int[]>> map = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curSize = 0;

        for (int[] arr : points) {
            double hypo = Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]);
            List<int[]> list = map.getOrDefault(hypo, new ArrayList<>());
            list.add(arr);
            map.put(hypo, list);

            if (!pq.contains(hypo)) {
                pq.add(hypo);

                curSize = getSize(pq, map);
                while (curSize > k) {
                    pq.poll();
                    curSize = getSize(pq, map);
                }
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (i < k) {
            while (!pq.isEmpty()) {
                double hypo = pq.poll();
                for (int[] arr : map.get(hypo)) {
                    res[i] = arr;
                    i++;

                    if (i >= k) return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr;
        arr = kClosest(new int[][]{{1,3},{-2,2}}, 1);
        System.out.println(Arrays.deepToString(arr));
        arr = kClosest(new int[][]{{3,3},{5,-1}, {-2, 4}}, 2);
        System.out.println(Arrays.deepToString(arr));
        arr = kClosest(new int[][]{{2, 2}, {2, 2}, {3, 3}, {-2, 2}, {1, 1}}, 4);
        System.out.println(Arrays.deepToString(arr));
        arr = kClosest(new int[][]{{2, 2}, {2, 2}, {2, 2}, {2, 2},{2, 2}, {2, 2}, {1, 1}}, 1);
        System.out.println(Arrays.deepToString(arr));
    }
}
