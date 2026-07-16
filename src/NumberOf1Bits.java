public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("3 -> " + hammingWeight(11));
        System.out.println("1 -> " + hammingWeight(128));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(5 << 1));
        System.out.println(5);

        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i + " i >> 1 = " + (i >> 1));
        }

        System.out.println(126 | 652);
    }
}
