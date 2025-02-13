public class ValidPalindrome {

	private static boolean isAlplaNumeric(char c) {
		return (c > 64 && c < 91) || (c > 47 && c < 58) || (c > 96 && c < 123);
	}

	private static char makeLowerCase(char c) {
		return (c > 64 && c < 91) ? (char) (c + 32) : c;
	}

	public static boolean isPalindrome(String s) {
		char [] a = s.toCharArray();
		int j = a.length - 1;
		int i = 0;
		while (i < j) {
			if (!isAlplaNumeric(a[i])) {
				i++;
			} else if (!isAlplaNumeric(a[j])) {
				j--;
			} else if (makeLowerCase(a[i]) != makeLowerCase(a[j])) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
    }

    public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}