public class FindMinimuminRotatedSortedArray {
    
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int target;

        if (nums[hi] < nums[lo]) {
            target = nums[hi];
        } else {
            return nums[lo];
        }

        while (lo <= hi) {
            int med = (hi - lo) / 2 + lo;
            if (nums[med] > target) {
                lo = med + 1;
            } else {
                target = nums[med];
                hi = med - 1;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        
    }
}
