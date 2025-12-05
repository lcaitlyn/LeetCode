package YandexContest;

import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("input.txt"));
             PrintWriter out = new PrintWriter(new File("output.txt"));) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            out.println(a + b);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
