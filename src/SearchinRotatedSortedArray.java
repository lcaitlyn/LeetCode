public class SearchinRotatedSortedArray {
    
    private static int findMin(int [] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        int target;
        if (nums[lo] > nums[hi]) {
            target = hi;
        } else {
            return lo;
        }

        while (lo <= hi) {
            int med = (hi - lo) / 2 + lo;

            if (nums[med] < nums[target]) {
                target = med;
                hi = med - 1;
            } else {
                lo = med + 1;
            }
        }

        return target;
    }

    public static int search(int[] nums, int target) {
        int min = findMin(nums);
        int lo = 0;
        int hi = nums.length - 1;
        
        System.out.println("min = " + min);
        if (min != 0) {
            if (target >= nums[min] && target <= nums[nums.length - 1]) {
                lo = min;
                hi = nums.length - 1;
            } else {
                lo = 0;
                hi = min - 1;
            }
        }

        while (lo <= hi) {
            int med = (hi - lo) / 2 + lo;
            if (nums[med] == target) {
                return med;
            }
            if (target < nums[med]) {
                hi = med - 1;
            } else {
                lo = med + 1;
            }
        }
        
        return -1;
    }

    // runtim 0ms beats 96%. решил с микроподсказкой от Кодируем

    public static void main(String[] args) {
        System.out.println(search(new int[]{4}, 0));
    }
}
