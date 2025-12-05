package YandexContest;

import java.util.*;

public class ProgramA {

//    private static long dfs(List<List<Integer>> graph, int[] nums, boolean[] visited, int i) {
//        visited[i] = true;
//        long sum = nums[i];
//        for (int path : graph.get(i)) {
//            if (!visited[path]) {
//                sum += dfs(graph, nums, visited, path);
//            }
//        }
//        return sum;
//    }


    private static long dfs(List<List<Integer>> graph, int[] nums, boolean[] visited, int i) {
        visited[i] = true;

        long maxChild = 0;
        for (int path : graph.get(i)) {
            if (!visited[path]) {
                long childSum = dfs(graph, nums, visited, path);
                if (childSum > maxChild) maxChild = childSum;
            }
        }

        visited[i] = false;
        return nums[i] + maxChild;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] visited = new boolean[n];

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        long maxSum = dfs(graph, nums, visited, 0);
//        for (int i = 0; i < n; i++) {
//            maxSum = Math.max();
//        }

        System.out.println(maxSum);
    }
}
