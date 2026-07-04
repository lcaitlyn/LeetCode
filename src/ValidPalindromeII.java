public class ValidPalindromeII {

    private static boolean isValid(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int l = 0 , r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isValid(s, l, r - 1)) return true;
                return (isValid(s, l + 1, r));
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true -> " + validPalindrome("gmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmg"));
//        System.out.println(validPalindrome("ccu"));
// x           validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul");
//        System.out.println(validPalindrome("upuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupu"));
    }
}
