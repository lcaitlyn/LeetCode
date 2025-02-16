public class FindFirstAndLastPositionOfElementInSortedArray {
    
    private static int searchLeft(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                ans = mid;
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private static int searchRight(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                ans = mid;
            }

            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[] {searchLeft(nums, target), searchRight(nums, target)};
    }

    public static void main(String[] args) {
        int [] arr = new int[] {1,2,2,3,3,3,4,5,5,6,6,7,7,8,9};
        int [] res = searchRange(arr, 3);
        System.out.println(res[0] + " " + res[1]);
    }
}
