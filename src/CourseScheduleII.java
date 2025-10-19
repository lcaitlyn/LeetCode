import java.util.*;

public class CourseScheduleII {

    private static boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, boolean[] safe, List<Integer> res, int course) {
        if (visited[course]) return false;

        if (safe[course]) return true;

        if (!map.containsKey(course)) {
            safe[course] = true;
            res.add(course);
            return true;
        }

        visited[course] = true;

        for (int i : map.get(course)) {
            if (!dfs(map, visited, safe, res, i)) return false;
        }
        res.add(course);
        safe[course] = true;
        return true;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] safe = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();

        for (int [] courses : prerequisites) {
            List<Integer> list = map.getOrDefault(courses[1], new ArrayList<>());
            list.add(courses[0]);
            map.put(courses[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!safe[i]) {
                if (!dfs(map, visited, safe, res, i)) return new int[]{};
            }
        }

        res = res.reversed();
        int [] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

//    beats 42.71% memory 28.89% runtime 6ms

    public static void main(String[] args) {
        int [] res;
        res = findOrder(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(Arrays.toString(res));
        res = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        System.out.println(Arrays.toString(res));
    }
}
