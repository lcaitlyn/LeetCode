package Sorting;

import java.util.Arrays;

public class QuickSort {


    private static void quickSort(int[] nums, int l, int r) {
        if (nums.length == 0 || l >= r) return;

        int med = (r - l) / 2 + l;
        int pivot = nums[med];

        int i = l, j = r;
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if (l < i) quickSort(nums, l, j);
        if (r > j) quickSort(nums, i, r);
    }

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length -1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 2, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
