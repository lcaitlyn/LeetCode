public class AlternatingGroupsII {

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int n = colors.length;
        int l = 0, r = 1;

        while (l < n) {
            if (colors[r % n] == colors[(r - 1) % n]) {
                if (r >= n) break;
                l = r;
            }

            if (r - l + 1 == k) {
                res++;
                l++;
            }
            r++;
        }

        return res;
    }

//    runtime 5ms beats 65.5% memory 17.05%

    public static void main(String[] args) {
//        System.out.println("3 -> " + numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println("1 -> " + numberOfAlternatingGroups(new int[]{0,0,1}, 3));
    }
}
