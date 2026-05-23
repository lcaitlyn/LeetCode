import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo2DArraysBySummingValues {

//    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        if (n == 0) return nums2;
//        if (m == 0) return nums1;
//
//        List<int []> list = new ArrayList<>();
//
//        int l = 0, r = 0;
//        while (l < n || r < m) {
//            while (l == n && r < m) {
//                list.add(nums2[r]);
//                r++;
//            }
//
//            while (r == m && l < n) {
//                list.add(nums1[l]);
//                l++;
//            }
//
//            if (l == n && r == m) break;
//
//            int x = nums1[l][0];
//            int y = nums2[r][0];
//
//            if (x == y) {
//                list.add(new int[]{x, nums1[l][1] + nums2[r][1]});
//                l++; r++;
//            } else if (x < y) {
//                list.add(nums1[l]);
//                l++;
//            } else {
//                list.add(nums2[r]);
//                r++;
//            }
//        }
//
//        int[][] arr = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//
//        return arr;
//    }

//    runtime 121ms (на графике только от 0 до 6 :D) beats 6% memory 72%

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0) return nums2;
        if (m == 0) return nums1;

        int[][] arr = new int[n + m][2];

        int i = 0;
        int l = 0, r = 0;
        while (l < n && r < m) {
            int x = nums1[l][0];
            int y = nums2[r][0];

            if (x == y) {
                arr[i++] = new int[]{x, nums1[l++][1] + nums2[r++][1]};
            } else if (x < y) {
                arr[i++] = nums1[l++];
            } else {
                arr[i++] = nums2[r++];
            }
        }

        while (l == n && r < m) {
            arr[i++] = nums2[r++];
        }

        while (r == m && l < n) {
            arr[i++] = nums1[l++];
        }

        return Arrays.copyOf(arr, i);
    }

//    убрал List<> сразу стало быстрее
//    runtime 0ms beats 100% memory 86%

    public static void main(String[] args) {
        int[][] nums1; int[][] nums2;
        nums1 = new int[][] {
                {1,2}, {2,3}, {4,5}
        };
        nums2 = new int[][] {
                {1,4}, {3, 2}, {4,1}
        };
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
        nums1 = new int[][] {
                {2,4}, {3,6}, {5,5}
        };
        nums2 = new int[][] {
                {1,3}, {4, 3}
        };
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }
}
