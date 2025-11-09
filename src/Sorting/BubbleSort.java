package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int [] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < len) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
                j++;
            }
            len--;
        }
    }

//    tc

    public static void main(String[] args) {
        int[] arr = new int[]{6,2,7,1,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
