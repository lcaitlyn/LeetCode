import java.util.Arrays;

public class DefuseTheBomb {

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if (k == 0) return arr;

        int l = (k > 0) ? 1 : (n + k) % n;
        int r = l;
        if (k < 0) k *= -1;

        int sum = 0;

        for (int i = 0; i < Math.abs(k); i++) {
            sum += code[r];
            r = (r + 1) % n;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = sum;

            sum -= code[l];
            l = (l + 1) % n;

            sum += code[r];
            r = (r + 1) % n;
        }

        return arr;
    }

//    beats 100% runtime 0ms memory 65%

    public static void main(String[] args) {
        System.out.println("[22,26,22,28,29,22,19,22,18,21,28,19] -> ");
        System.out.println(Arrays.toString(decrypt(new int[]{10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)));
    }
}
