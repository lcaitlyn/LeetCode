import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindKClosestElements {

    private static List<Integer> makeListOfRange(int [] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();

        while (start <= end) {
            list.add(arr[start]);
            start++;
        }

        return list;
    }

//    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        if (arr.length == k) return makeListOfRange(arr, 0, arr.length - 1);
//
//        int l = 0, r = arr.length - 1;
//
//        if (x < arr[l]) {
//            return makeListOfRange(arr, 0, k - 1);
//        }
//
//        if (x > arr[r]) {
//            return makeListOfRange(arr, arr.length - k, arr.length - 1);
//        }
//
//        while (l <= r) {
//            int med = (r - l) / 2 + l;
//            if (arr[med] == x) {
//                k--;
//                l = med - 1;
//                r = med + 1;
//                while (k > 0) {
//                    if (l >= 0 && r < arr.length) {
//                        if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
//                            r++;
//                        } else {
//                            l--;
//                        }
//                    } else if (l >= 0) {
//                        l--;
//                    } else {
//                        r++;
//                    }
//                    k--;
//                }
//                return makeListOfRange(arr, l + 1, r - 1);
//            } else if (x < arr[med]) {
//                r = med - 1;
//            } else {
//                l = med + 1;
//            }
//        }
//
//        int tmp = l; l = r; r = tmp;
//        while (k > 0) {
//            if (l >= 0 && r < arr.length) {
//                if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
//                    r++;
//                } else {
//                    l--;
//                }
//            } else if (l >= 0) {
//                l--;
//            } else {
//                r++;
//            }
//            k--;
//        }
//
//        return makeListOfRange(arr, l + 1, r - 1);
//    }

    // beats 48% 7ms runtime лол memory 76%
    // вот щас я ахуел, когда там делают быстрее 4ms - это средний лучший рантайм по графику.

    // думаю проблема в поиска соседних чисел. потому что он идет в O(n), хотя алгос по поиску числа O(logN) [!!! ошибка расписал ниже почему]
    // добавил вот это : if (arr.length == k) return makeListOfRange(arr, 0, arr.length - 1);
    // скорость не изменилась

    // глянул в решения, там еще складнее чем у меня нах
    // у меня вообще чет огромная ебаная портянка это пиздец

    // я ошибся на самом деле в моём решение сложность O(logN + k), где нам нужно пройти еще K, чтобы найти соседние числа
    // т.е если  K == N, то это тоже самое получится что O(N + logN)

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;

        while (l <= r) {
            int med = (r - l) / 2 + l;
            if (x - arr[med] > arr[med + k] - x) {
                l = med + 1;
            } else {
                r = med;
            }
        }

        return makeListOfRange(arr, l, r);
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 5, 6}, 3, 3));
    }
}
