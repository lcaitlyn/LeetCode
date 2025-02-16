public class FirstBadVersion {

    public static boolean isBadVersion(int n) {
        int version = 5; // можно менять версию в ручную
        return (n >= version);
    }
    
    public static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int ans = -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (isBadVersion(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(8));
    }
}
