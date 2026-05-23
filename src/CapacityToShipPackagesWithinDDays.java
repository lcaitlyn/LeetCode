public class CapacityToShipPackagesWithinDDays {

    private static boolean isValid(int[] weights, int days, int weight) {
        int k = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weight < weights[i]) return false;

            k += weights[i];
            if (k > weight) {
                k = weights[i];
                days--;
            }
            if (days < 0) return false;
        }
        return days >= 0;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }

        int res = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (isValid(weights, days - 1, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

//    runtime 11ms beats 71.4% memory 35.34%

    public static void main(String[] args) {
        System.out.println("15 -> " + shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println("6 -> " + shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println("3 -> " + shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
