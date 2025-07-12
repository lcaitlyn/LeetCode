public class IntegerToRoman {
    
//    private static String digitToString(int num, char ones, char fives, char tens) {
//        int remainder = num % 10;
//
//        return switch (remainder) {
//            case 1 -> "" + ones;
//            case 2 -> "" + ones + ones;
//            case 3 -> "" + ones + ones + ones;
//            case 4 -> "" + ones + fives;
//            case 5 -> "" + fives;
//            case 6 -> "" + fives + ones;
//            case 7 -> "" + fives + ones + ones;
//            case 8 -> "" + fives + ones + ones + ones;
//            case 9 -> "" + ones + tens;
//            default -> "";
//        };
//    }
//
//    public static String intToRoman(int num) {
//        String res;
//        int k = 10;
//
//        res = digitToString(num % 10, 'I', 'V', 'X');
//
//        if (num / 10 > 0)
//            res = digitToString(num / 10, 'X', 'L', 'C') + res;
//
//        if (num / 100 > 0)
//            res = digitToString(num / 100, 'C', 'D', 'M') + res;
//
//        if (num / 1000 > 0)
//            res = digitToString(num / 1000, 'M', '-', '-') + res;
//
//        return res;
//    }

    // Runtime 16 ms, Beats 6%


    public static String intToRoman(int num) {
        String [] letters = new String [] {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        int [] values = new int [] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num / values[i] > 0) {
                res.append(letters[i]);
                num -= values[i];
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("i = " + 1 + " = " + intToRoman(58));
    }
}
