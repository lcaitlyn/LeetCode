import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    
    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String s : strs) {
            builder.append(s.length()).append('$').append(s);
        }
        return builder.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '$') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            res.add(str.substring(j + 1, j + len + 1));

            i = j + len + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = encode(Arrays.asList("neet","code","love","you"));

        System.out.println(s);

        decode(s).forEach(System.out::println);
    }
}
