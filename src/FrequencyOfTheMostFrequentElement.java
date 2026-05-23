import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FrequencyOfTheMostFrequentElement {

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int res = 0;
        long sum = 0;
        while (r < nums.length) {
            sum += nums[r];

            while (l < r && sum + k < (long) nums[r] * (r - l + 1)) {
                sum -= nums[l];
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

//    runtime 36ms beats 47.95% memory 64%
//    хотел я конечно отсортировать, но думал нельзя менять порядок,
//    поэтому использовал PriorityQueue<>(Comarator.reverseOrder())
//    чтобы искать максимальный
//    в итоге можно было просто сортировать

    public static void main(String[] args) {
        System.out.println("3 -> " + maxFrequency(new int[]{1, 2, 4}, 5));
    }
}
