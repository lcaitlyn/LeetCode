import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Начиная разбирать приходит мысль, что возможно стоит отсортировать массив
    // и после сортировки нужно число будет ровно по середине, так как оно существует 100%.
    // Но для начала хочу сделать обычный брут форс
    // Буду делать его записывая каждое число в Мапу и из мапы вычислять максимум
    // Знаю, что получится очень не эффективно. Думаю time complexity будет O(n^2)

    // Лол че то не могу пройтись по мапе
    // так что с мапой отменяю

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[(nums.length) / 2];
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
