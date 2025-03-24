import java.util.List;

public class TwoSumII {

    // private static int binarySearch(int[] arr, int target) {
    //     int lo = 0;
    //     int hi = arr.length;

    //     while (lo <= hi) {
    //         int med = (hi - lo) / 2 + lo;

    //         if (target == arr[med]) {
    //             return med;
    //         } else if (target < arr[med]) {
    //             hi = med - 1;
    //         } else {
    //             lo = med + 1;
    //         }
    //     }
    //     return -1;
    // }

    // public static int[] twoSum(int[] numbers, int target) {
    //     for (int i = 0; i < numbers.length; i++) {
    //         int find = target - numbers[i];
    //         if (find == numbers[i]) {
    //             return new int[] {i + 1, i + 2};
    //         }
    //         int search = binarySearch(numbers, find);
    //         if (search != -1) {
    //             return new int[] {i + 1, search + 1};
    //         }
    //     }
    //     return null;
    // }


    // Результат: Runtime 4 ms (beats 19.83%) (околоидеал)
    // круто конечно что ты смог использовать БС тут, но все же искать надо используя Two Pointers


    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    // runtime 2 ms beats 92.7%, вот это уже ахуенно

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,2,3,4,4,9,56,90}, 8));
    }
}
