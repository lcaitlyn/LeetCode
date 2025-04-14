public class KokoEatingBananas {

    private static boolean isGood(int [] piles, int h, long val) {
        int hours = 0;
        for (int i : piles) {
            hours += (int) Math.ceilDiv(i, val);
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
    
    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 2147483647;
        
        int res = hi;
        while(lo <= hi) {
            int med = (hi - lo) / 2 + lo;
            if (isGood(piles, h, med)) {
                hi = med - 1;
                res = med;
            } else {
                lo = med + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
