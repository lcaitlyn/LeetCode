import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArrayOfTwoArrays {
//    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//        int [] res = new int [A.length];
//        Set<Integer> setA = new HashSet<>();
//        Set<Integer> setB = new HashSet<>();
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < A.length; i++) {
//            setA.add(A[i]);
//            setB.add(B[i]);
//            if (setB.contains(A[i])) {
//                set.add(A[i]);
//            }
//            if (setA.contains(B[i])) {
//                set.add(B[i]);
//            }
//            res[i] = set.size();
//        }
//
//        return res;
//    }

//          beats 19.43% runtime 7ms. Memory 64% Можно быстрее нах
//          А как сделать быстрее? Отсортировать? точно нет это уже NlogN
//          да и нам нужно знать точный порядок сука
//          подсказка1:
//          Consider keeping a frequency array that stores the count of occurrences of each number till index i.
//          Подумайте о том, чтобы сохранить частотный массив, в котором хранится количество вхождений каждого числа до индекса i.
//          какая-то хуйня блять по моему а не подсказка
//          подсказка2:
//          If a number occurred two times, it means it occurred in both A and B since they’re both permutations so add one to the answer.
//          ну это еще тупее нахуй

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int [] res = new int [A.length];
        int [] mapA = new int[50];
        int [] mapB = new int[50];

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (mapA[A[i]] != -1) mapA[A[i]]++;
            if (mapB[B[i]] != -1) mapB[B[i]]++;
            if (mapA[A[i]] + mapB[A[i]] >= 2) {
                sum++;
                mapA[A[i]] = -1;
                mapB[A[i]] = -1;
            };
            if (mapA[B[i]] + mapB[B[i]] >= 2) {
                sum++;
                mapA[B[i]] = -1;
                mapB[B[i]] = -1;
            }
            res[i] = sum;
        }

        return res;
    }

//    beats 89.41% memory 44%. runtime 2ms Хз вроде кайф. Хз вообзе че поменялось.
//    Хотя сеты наверное медленно отрабатывали

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3, 1, 2})));
    }
}
