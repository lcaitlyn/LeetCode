public class SearchInRotatedSortedArrayII {

//    public static boolean search(int[] nums, int target) {
//        int l = 0, r = nums.length - 1;
//
//        while (l < r && r - l > 1 && nums[l] == nums[r]) {
//            l++;
//            r--;
//        }
//
//        int pivot = (r - l) / 2 + l;
//        if (nums[r] <= nums[l]) {
//            while (l <= r) {
//                int mid = (r - l) / 2 + l;
//                if (nums[mid] == target) return true;
//                if (nums[mid] < nums[pivot]) {
//                    pivot = mid;
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            }
//        }
//
//        while (l <= r) {
//            int mid = (r - l) / 2 + l;
//            if (nums[mid] == target) return true;
//            if (nums[mid] > target) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//
//        return false;
//    }

//    надо доделать на рабочий варик
//    beats 100% RUNTIME 0MS memory 63%

    public static void main(String[] args) {
//        System.out.println("true -> " + search(new int[]{1, 0, 1, 1, 1}, 0));
//        System.out.println("true -> " + search(new int[]{2,5,6,0,0,1,2}, 0));
//        System.out.println("false -> " + search(new int[]{2,5,6,0,0,1,2}, 3));
//        System.out.println("true -> " + search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 13));
//        System.out.println("false -> " + search(new int[]{1}, 0));
//        System.out.println("true -> " + search(new int[]{1, 1}, 1));
//        System.out.println("true -> " + search(new int[]{3, 1}, 1));
    }
}
