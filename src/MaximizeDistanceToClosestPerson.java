public class MaximizeDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {
        int i = 0;
        int k = 0;
        int res = 0;

        while (i < seats.length && seats[i] == 0) {
            i++;
            k++;
        }

        if (k != 0) res = k;

        while (i < seats.length) {
            k = 0;
            if (seats[i] == 0) {
                while (i < seats.length && seats[i] == 0) {
                    k++;
                    i++;
                }

                if (i == seats.length) return Math.max(res, k);
            }
            res = Math.max(res, k / 2 + k % 2);
            i++;
        }

        return res;
    }

//    beats 44% memory 72% runtime 3ms

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{0, 0, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{0, 0, 0, 1, 0, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0}));
    }
}
