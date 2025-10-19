import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

//    private static boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] safe, int course) {
//        if (!map.containsKey(course)) return true;
//
//        if (safe[course]) return true;
//
//        if (visited[course]) return false;
//
//        visited[course] = true;
//
//        for (int i : map.get(course)) {
//            if (!dfs(map, visited, safe, i)) return false;
//        }
//        safe[course] = true;
//        return true;
//    }
//
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (int [] courses : prerequisites) {
//            List<Integer> list = map.getOrDefault(courses[1], new ArrayList<>());
//            list.add(courses[0]);
//            map.put(courses[1], list);
//        }
//
//        for (int course : map.keySet()) {
//            if (!dfs(map, new boolean[numCourses], new boolean[numCourses], course)) return false;
//        }
//
//        return true;
//    }

//    beats 5% memory 6% 273ms
//    пиздец не правильно запускал все O(n * (n + v))

    private static boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] safe, int course) {
        if (!map.containsKey(course)) return true;

        if (safe[course]) return true;

        if (visited[course]) return false;

        visited[course] = true;

        for (int i : map.get(course)) {
            if (!dfs(map, visited, safe, i)) return false;
        }
        safe[course] = true;
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] safe = new boolean[numCourses];

        for (int [] courses : prerequisites) {
            List<Integer> list = map.getOrDefault(courses[1], new ArrayList<>());
            list.add(courses[0]);
            map.put(courses[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!safe[i]) {
                if (!dfs(map, new boolean[numCourses], safe, i)) return false;
            }
        }

        return true;
    }

//    beats 72%, memory 16% 6ms runtime

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(canFinish(7, new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
    }
}
