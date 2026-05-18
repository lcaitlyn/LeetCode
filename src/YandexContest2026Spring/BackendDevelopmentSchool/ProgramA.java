package YandexContest2026Spring.BackendDevelopmentSchool;

import java.io.*;
import java.util.*;

public class ProgramA {

    private static class Node {
        String str;
        int counter;

        Node(String str) {
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] lines = s.split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        PriorityQueue<Node>[] pq = new PriorityQueue[26];

        for (int i = 0; i < 26; i++) {
            pq[i] = new PriorityQueue<>((a, b) -> {
                if (a.counter != b.counter) return Integer.compare(a.counter, b.counter);
                return a.str.compareTo(b.str);
            });
        }

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            pq[s.charAt(0) - 'a'].add(new Node(s));
        }

        for (int i = 0; i < k; i++) {
            s = br.readLine();
            int c = s.charAt(0) - 'a';
            int res = 0;

            Node node = pq[c].poll();
            node.counter++;
            System.out.println(node.str);
            pq[c].add(node);
        }
    }
}
