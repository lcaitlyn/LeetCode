public class RemoveAllAdjacentDuplicatesInString {


// ну тут че-то подумал опять через indexOf
// но пришел к выводу что просто через Stack буду делать да и всё

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

//    beats 81.73% runtime 12ms memory 52.65%
//    хз как быстрее
//    через 2 указателя..


    public static void main(String[] args) {

    }
}
