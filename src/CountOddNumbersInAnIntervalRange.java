public class CountOddNumbersInAnIntervalRange {

    public static int countOdds(int low, int high) {
        int diff = high - low;

        if (diff % 2 == 0) {
            if (low % 2 == 0 || high % 2 == 0) {
                return diff / 2;
            }
            if (low == high) {
                return 1;
            }
        }
        return diff / 2 + 1;
    }

//    beats 100% memory 21% runtime 0ms

    public static void main(String[] args) {
        System.out.println("2 -> " + countOdds(3, 6));
        System.out.println("1 -> " + countOdds(4, 6));
        System.out.println("3 -> " + countOdds(3, 7));
        System.out.println("2 -> " + countOdds(4, 7));
        System.out.println("0 -> " + countOdds(4, 4));
        System.out.println("1 -> " + countOdds(5, 5));
    }
}
