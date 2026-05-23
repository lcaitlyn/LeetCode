import java.util.Comparator;
import java.util.PriorityQueue;

public class AddingSpacesToAString {

    public static String addSpaces(String s, int[] spaces) {
        if (spaces.length == 0) return s;

        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == spaces[j]) {
                sb.append(' ');
                j++;
            }

            if (j == spaces.length) {
                sb.append(s.substring(i));
                break;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

//    runtime 19ms, beats 90.95% memory 45.02%

    public static void main(String[] args) {
        System.out.println("Leetcode Helps Me Learn -> " + addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }
}
