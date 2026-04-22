public class CountSquareSumTriples {

    private static boolean isPerfectSquare(int n) {
        if (n < 0) return false;

        double res = Math.sqrt(n);
        long intPart = (long) res;
        return intPart == res;
    }

    public static int countTriples(int n) {
        int count = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = i * i + j * j;
                if (isPerfectSquare(sum) && Math.sqrt(sum) <= n) {
                    if (i != j) count++;
                    count++;
                }
            }
        }

        return count;
    }

//    beats 65.97% memory 64% runtime 9ms
//    я думаю можно намного быстрее вычислять все это

    public static void main(String[] args) {
        System.out.println(countTriples(5));
    }
}
