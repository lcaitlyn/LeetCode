public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        int res = nums.length + 1;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];

            if (sum >= k) {
                res = Math.min(res, r - l + 1);

                int m = r;
                int med = 0;
                while (m >= l && med < k) {
                    med += nums[m];
                    if (med >= k) {
                        res = Math.min(res, r - m + 1);
                        l = m;
                        sum = med;
                        break;
                    }
                    m--;
                }
            }

            if (res == 1) return 1;

            if (sum <= 0) {
                sum = 0;
                l = r + 1;
            }

            r++;
        }

        return (res == nums.length + 1) ? -1 : res;
    }

    public static void main(String[] args) {
//        System.out.println("5 -> " + shortestSubarray(new int[]{11,47,97,35,-46,59,46,51,59,80,14,-6,2,20,96,1,18,74,-17,71}, 282));
//        System.out.println("2 -> " + shortestSubarray(new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151));
//        System.out.println("2 -> " + shortestSubarray(new int[]{2,-1,1,-1,1,2}, 3));
//        System.out.println("4 -> " + shortestSubarray(new int[]{39353,64606,-23508,5678,-17612,40217,15351,-12613,-37037,64183,68965,-19778,-41764,-21512,17700,-23100,77370,64076,53385,30915,18025,17577,10658,77805,56466,-2947,29423,50001,31803,9888,71251,-6466,77254,-30515,2903,76974,-49661,-10089,66626,-7065,-46652,84755,-37843,-5067,67963,92475,15340,15212,54320,-5286}, 207007));
        int[] arr = new int[100_000];

        for (int i = 0; i < 100_000; i++) {
            arr[i] = i * ((i % 2 == 0) ? -1 : 1);
        }
        arr[0] = 100_002;

        System.out.println(shortestSubarray(arr, 100_000));
    }
}
