public class BinarySearch {
    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int med = max / 2;
        while (true) {
            System.out.println("med = " + med);
            if (med > nums.length - 1) {
                return -1;
            }

            if (max - min < 3) {
                if (min > nums.length - 1) {
                    return -1;
                }

                if (nums[med] == target) {
                    return med;
                } else if (nums[min] == target) {
                    return min;
                } else if (nums[max] == target) {
                    return max;
                } else {
                    return -1;
                }
            }

            if (med == 0 && nums[med] != target) {
                return -1;
            }
            
            if (nums[med] == target) {
                return med;
            }

            if (nums[med] > target) {
                max = med - 1;
                med = max / 2;
            }

            if (nums[med] < target) {
                min = med + 1;
                med = (max - min) / 2 + min;
            }

            System.out.println("min = " + min + ", med = " + med + ", max = " + max);

        }
    }

    public static int searchRec(int [] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (hi - lo) / 2 + lo;
        System.out.println("min = " + lo + ", med = " + mid + ", max = " + hi);
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return searchRec(nums, target, mid + 1, hi);
        }
        return searchRec(nums, target, lo, hi - 1);
    }

    public static void main(String[] args) {
        int [] arr = new int[] {-1,0,3,5,9,12};
        // System.out.println(search(new int[] {-1,0,3,5,9,12,13}, 12));
        // System.out.println(search(new int[] {-1,0,3,5,9,12}, 12));
        // System.out.println(search(new int[]{2, 5},5));
        System.out.println(searchRec(arr, 13, 0, arr.length - 1));
    }
}
