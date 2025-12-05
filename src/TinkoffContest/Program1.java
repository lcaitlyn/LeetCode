package TinkoffContest;

import java.util.Arrays;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] nums = new int[4];

        for (int i = 3; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(nums);

        if (nums[0] == 0) {
            int next = 1;
            while (next < nums.length && nums[next] == 0) {
                next++;
            }

            nums[0] = nums[next];
            nums[next] = 0;
        }

        int res = nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3];

        System.out.println(res);
    }
}
