public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int total = 0, leftSum = 0;

        for (int i = 0; i < nums.length; i++){
            total += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];

            if (leftSum == total) return i;

            leftSum += nums[i];
        }

        return -1;
    }

//    beats 93.43% memory 8.95% runtime 1ms
//    скорее всего тут лаги литкода, потому что памяти тут O(1)

//    дали эту задачу на Алгособесе Яндекса 18.11.2025

    public static void main(String[] args) {

    }
}
