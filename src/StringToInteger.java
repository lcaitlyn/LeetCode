public class StringToInteger {

    public static int myAtoi(String s) {
        s = s.trim();
        int signIndex = -1;
        int start = -1, end = -1;

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                if (start == -1) {
                    start = i;
                }

                if (s.charAt(start) == '0') start = i;

                end = i;
            } else {
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (start != -1) break;

                    if (signIndex != -1) return 0;

                    signIndex = i;
                } else {
                    if (start == -1) i--;
                    break;
                }
            }
            i++;
        }

        if (start == -1) return 0;

        if (end - start > 10) {
            if (signIndex != -1 && s.charAt(signIndex) == '-') return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        long res = 0, des = 1;
        while (end >= start) {
            res += (long) (s.charAt(end) - '0') * des;
            des *= 10;
            end--;

            if (res > Integer.MAX_VALUE) {
                if (signIndex != -1 && s.charAt(signIndex) == '-') return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }

        if (signIndex != -1 && s.charAt(signIndex) == '-') res *= -1;

        return (int) res;
    }

//    beats 99.97% memory 26.75% runtime 1ms
//    только код не красивый и не читаемый особо

    public static void main(String[] args) {
//        System.out.println(myAtoi("   -0498773234a2"));
//        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("0000000000012345678"));
        System.out.println(myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
    }
}
