import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimplifyPath {

//    public static String simplifyPath(String path) {
//

//          первоначальный вариант был такой
//          НЕ РАБОТАЕТ С ..

//        String [] directories = path.split("/");
//        if (directories.length == 0) {
//            directories = new String[1];
//            directories[0] = path;
//        };
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("/");
//        for (int i = 0; i < directories.length; i++) {
//            if (directories[i].isEmpty()) continue;
//
//            if (directories[i].equals("..")) {
//                if (i - 2 < 0) {
//                    sb.replace(0, sb.length(), "/");
//                } else {
//                    sb.delete(sb.length() - directories[i - 1].length() - 1, sb.length());
//                }
//            } else if (!directories[i].equals(".")) {
//                sb.append(directories[i]);
//                sb.append("/");
//            }
//        }
//
//        if (!sb.toString().startsWith("/")) sb.insert(0, "/");
//
//        if (sb.length() != 1 && sb.toString().endsWith("/")) return sb.substring(0, sb.length() - 1);
//
//        return sb.toString();
//    }

    // если че сверху не рабочая тема

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        List<String> list = new ArrayList<>();

        for (String dir : dirs) {
            if (dir.isEmpty() || dir.equals(".")) continue;

            if (dir.equals("..")) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else {
                list.add(dir);
            }
        }

        if (list.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String dir : list) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.toString();
    }

    // beats 98.83%. придумал решение нах за минуту, после утреннего затупа с последним примером
    // memory 60%. Возможно по памяти можно еще улучшить потому что по памяти у меня O(n). Ну точнее O(path.split(path).size())


    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }
}
