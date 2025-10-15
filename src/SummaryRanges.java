import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int l = 0, r = 0;
        while (l < nums.length) {
            r = l + 1;
            while (r < nums.length && nums[r - 1] + 1 == nums[r]) {
                r++;
            }
            if (nums[l] != nums[r - 1])
                list.add(nums[l] + "->" + nums[r - 1]);
            else
                list.add(String.valueOf(nums[l]));

            l = r;
        }

        return list;
    }

    // beats 82% runtime 5ms, memory 38%
    // бля я не верю чтобы какой-нибудь уебан сделал это при помощи binary search
    // как такое реализвать? наверное брали отрезки и так как эта параша отсортирована то сравнивали
    // 1 2 3 или 8,9,10 мы сто проц знаем что arr[i + 2] - arr[i] == 2, тогда четкий нахуй. крч я думаю эти хуесосы
//     приыгали. типа sliding window мб. щас чекну ответы
//     да не. 1 в 1 как я написал (ну почти, но алгос тот же самый)

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0}));
        System.out.println(summaryRanges(new int[]{0, 1}));
        System.out.println(summaryRanges(new int[]{0, 2}));
        System.out.println(summaryRanges(new int[]{0, 2, 3}));
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
