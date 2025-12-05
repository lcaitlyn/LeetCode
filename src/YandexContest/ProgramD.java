package YandexContest;

import java.util.*;

public class ProgramD {

//    private static void destroy(int[] nums, int[] res, int n, int start) {
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        int i = n - 1 - start;
//        while (i >= 0) {
//            Integer minJ = null;
//
//            for (Integer j : deque) {
//                if (nums[j] > nums[i]) {
//                    minJ = j;
//                    break;
//                }
//            }
//
//            if (minJ != null) {
//                res[i] = minJ - i;
//            }
//
//            if (!deque.isEmpty() && nums[deque.getFirst()] == nums[i]) {
//                deque.removeFirst();
//            }
//
//            deque.addFirst(i);
//            i -= 2;
//        }
//    }

//    private static void destroy(int[] nums, int[] res, int n, int start) {
//        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
//
//        int i = n - 1 - start;
//        while (i >= 0) {
//            SortedMap<Integer, TreeSet<Integer>> tail = map.tailMap(nums[i] + 1);
//            Integer minJ = null;
//
//            for (TreeSet<Integer> set : tail.values()) {
//                int j = set.first();
//                if (minJ == null || j < minJ) minJ = j;
//            }
//
//            if (minJ != null) {
//                res[i] = minJ - i;
//            }
//
//            TreeSet<Integer> set = map.getOrDefault(nums[i], new TreeSet<>());
//            set.add(i);
//            map.put(nums[i], set);
//            i -= 2;
//        }
//    }

        private static void destroy(int[] nums, int[] res, int n, int start) {
            Deque<Integer> deque = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = start; i < n; i += 2) {
                while (!deque.isEmpty() && nums[i] > deque.getFirst()) {
                    int num = deque.removeFirst();
                    int j = map.get(num);
                    res[j] = i - j;
                    map.remove(num);
                }

                deque.addFirst(nums[i]);
                map.put(nums[i], i);
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        destroy(nums, res, n, 0);
        destroy(nums, res, n, 1);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
