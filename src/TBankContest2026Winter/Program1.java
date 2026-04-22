package TBankContest2026Winter;

import java.util.Arrays;
import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }

        Arrays.sort(nums);

        if (nums[0] == 0 && s.length() > 1) {
            int next = 1;
            while (next < s.length() && nums[next] == 0) {
                next++;
            }

            nums[0] = nums[next];
            nums[next] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
