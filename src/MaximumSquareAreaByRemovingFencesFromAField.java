import java.util.*;

public class MaximumSquareAreaByRemovingFencesFromAField {

    private static List<Integer> makeList(int n, int[] heights) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i : heights) list.add(i);
        list.add(n);
        return list;
    }

    private static Set<Integer> getHeight(List<Integer> list) {
        Set<Integer> set = new HashSet<>();

        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                set.add(list.get(i) - list.get(j));
            }
        }

        return set;
    }

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        Set<Integer> height = getHeight(makeList(m, hFences));
        Set<Integer> width = getHeight(makeList(n, vFences));

        long res = -1;
        for (int i : height) {
            if (width.contains(i)) {
                res = Math.max(res, i * i);
            }
        }

        int MOD = 1_000_000_007;
        return (int) res % MOD;
    }

    public static void main(String[] args) {
//        System.out.println(maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
//        System.out.println(maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));
        System.out.println(maximizeSquareArea(3, 9, new int[]{2}, new int[]{8,6,5,4}));
    }
}
