package TBankContest2026Spring;

import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.println("Anya");
        else
            System.out.println("Masha");
    }
}
