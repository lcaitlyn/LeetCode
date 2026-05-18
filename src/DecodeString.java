import java.util.Stack;

public class DecodeString {

//    "3[a2[b]]c4[d2[e3[fgh]]]"
//    1 -> "3[abb]c4[d2[e3[fgh]]]"
//    2 -> "abbabbabbc4[d2[e3[fgh]]]"
//    3 -> "abbabbabbc4[d2[efghfghfgh]]"
//    4 -> "abbabbabbc4[defghfghfghefghfghfgh]"
//    5 -> "abbabbabbcdefghfghfghefghfghfghdefghfghfghefghfghfghdefghfghfghefghfghfghdefghfghfghefghfghfgh"
    private static void rec(StringBuilder sb, int l) {
        int r = l + 1;
        while (Character.isDigit(sb.charAt(r))) r++;

        int k = Integer.parseInt(sb.substring(l, r));
        String s = sb.substring(r + 1, sb.length() - 1);
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb1.append(s);
        }
        sb.replace(l, sb.length(), sb1.toString());
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (Character.isDigit(s.charAt(i))) {
                stack.push(sb.length() - 1);
                i++;
                while (Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
            }
            if (s.charAt(i) == ']') {
                rec(sb, stack.pop());
            }
        }

        return sb.toString();
    }

//    пиздец чет сложновато (ну именно закодить, алгоритм вроде +- понятно как было сделать)
//    runtime 1ms beats 83.2% memory 72.38%

//    ну и да, код конечно не красивый пиздец

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
        String s = "";
        s = decodeString("3[a]2[bc]");
        System.out.println("aaabcbc -> " + s + "  result : " + s.equals("aaabcbc"));

        s = decodeString("3[a2[c]]");
        System.out.println("accaccacc -> " + s + "  result : " + s.equals("accaccacc"));

        s = decodeString("2[abc]3[cd]ef");
        System.out.println("abcabccdcdcdef -> " + s + "  result : " + s.equals("abcabccdcdcdef"));

//        System.out.println(decodeString("3[a2[b]]c4[d2[e3[fgh]]]"));

    }
}
