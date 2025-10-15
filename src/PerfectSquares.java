public class PerfectSquares {

    public static int numSquares(int n) {
        int a = 1;
        while (a * a < n) {
            a++;
        }
        a--;

        int sqr = a * a;
        while (n > 0) {
            if (n >= sqr) {
                System.out.println(sqr);
                n -= sqr;
            } else {
                a--;
                sqr = a * a;
            }
//            if (n - sqr >= (a - 1) * (a - 1)) {
//
//            } else {
//
//            }
        }

        return n;
    }


    public static void main(String[] args) {
        numSquares(12);
        numSquares(13);
    }
}
