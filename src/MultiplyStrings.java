import java.util.Arrays;

public class MultiplyStrings {

//    private static int parseChar(char digit) {
//        return digit - '0';
//    }
//
//    private static char toChar(long digit) {
//        return (char) (digit + '0');
//    }
//
//    private static long parseInt(String number) {
//        int size = number.length();
//        long dec = (long) Math.pow(10, size);
//        long ans = 0;
//
//        for (int i = 0; i < number.length(); i++) {
//            dec /= 10;
//            int digit = parseChar(number.charAt(i));
//            ans += (int) (digit * dec);
//        }
//
//        return ans;
//    }
//
//    private static String toString(long number) {
//        if (number == 0) return "0";
//
//        StringBuilder ans = new StringBuilder();
//
//        while (number > 0) {
//            long a = number % 10;
//            ans.append(toChar(a));
//            number /= 10;
//        }
//
//        ans.reverse();
//        return ans.toString();
//    }
//
//    public static String multiply(String num1, String num2) {
//        System.out.println(parseInt(num1) * parseInt(num2));
//        return toString( parseInt(num1) * parseInt(num2));
//    }

    // крч идея хорошая, но это как брут форс. проблема этого решения в том, что можно выйти за рамки long
    // длина num1.length и num2.length < 200, т.е могут перемножаться числа в длину 200x200

    public static String multiply(String num1, String num2) {
        int [] arr = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[i + j + 1];
                arr[i + j + 1] = m % 10;
                arr[i + j] += m / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : arr) {
            if (d == 0 && sb.isEmpty()) continue;

            sb.append(d);
        }

        return !sb.isEmpty() ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
    }
}
