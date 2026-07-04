public class RemovingStarsFromAString {

    // хз
// как-будто снова какой-то стек и стрингбилдер и всё?


//    public String removeStars(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        for (char c : s.toCharArray()) {
//            if (c == '*') {
//                if (!sb.isEmpty()) {
//                    sb.delete(sb.length() - 1, sb.length());
//                }
//            } else {
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
//    }

    // да работает

//    beats 77.51% runtime 30ms memory 81.61%

//    мб попробовать быстрее?
//    через 2 указателя
//    а как? а вот так

    public String removeStars(String s) {
        char[] arr = s.toCharArray();

        int l = 0, r = 0;
        while (r < s.length()) {
            arr[l] = arr[r];
            if (arr[r] == '*') {
                l -= (l != 0) ? 2 : 1;
            }
            l++;
            r++;
        }

        return new String(arr, 0, l);
    }

//    beats 96.98% runtime 11ms memory 89.77%
}
