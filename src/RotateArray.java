import java.util.Arrays;

public class RotateArray {

//    смотря на решения не понимал что тут происходит лол, а на самом деле всё просто
//    эта хуйня просто меняет местами массив (разворачивает)
//    типо было 1 2 3 4 5 -> 5 4 3 2 1
//    и всё, ничего хайпового
    private static void swap(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        swap(nums, 0, n - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, n - 1);
    }

//    beats 100%, memory 68% runtime 0ms
//    смог только с решение сделать ( и то пришлось видео решение открывать )
//    увидел код решения нихуя не понял, а потом посмотроев видео решение
//    сам написал такой же код как и в решениях

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println("[5,6,7,1,2,3,4] --> " + Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 5);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 7);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 4);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 6);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4};
        rotate(arr, 4);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6,7,8,9};
        rotate(arr, 6);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6,7,8,9,10};
        rotate(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
