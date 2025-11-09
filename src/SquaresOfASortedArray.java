public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[nums.length];

        int i = nums.length - 1;
        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }
            i--;
        }

        return res;
    }

//    beats 100% memory 44%
//    ну это задачу я смотрел разбор в Яндекс мок собес, поэтому по памяти нах решение помню
}
