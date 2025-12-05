package TinkoffContest;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {

    private static void game(int[] nums, int n) {
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (nums[i] > i + 1) {
                System.out.println("Second");
                return;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1 - nums[i];
        }

        if (sum % 2 == 1)
            System.out.println("First");
        else
            System.out.println("Second");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }

            game(nums, n);
        }
    }
}
