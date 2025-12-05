package TinkoffContest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program2 {

    private static int dfs(int[] nums, int i, Set<Integer> set) {
        if (i == nums.length) return set.isEmpty() ? 0 : 1;

        int noTaken = dfs(nums, i + 1, set);

        int taken = 0;
        if (!set.contains(nums[i])) {
            set.add(nums[i]);
            taken = dfs(nums, i + 1, set);
            set.remove(nums[i]);
        }

        return noTaken + taken;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(dfs(nums, 0, new HashSet<>()));
    }
}
