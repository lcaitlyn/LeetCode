import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                if (k != 0) {
                    nums[i - k] = nums[i];
                }
            }
        }

        for (int i = nums.length - 1; k > 0; k--, i--) {
            nums[i] = 0;
        }
    }

//    beats 79% memory 15% runtime 2ms

//    оказывается можно еще с 2 указателя сделать лол

    public static void main(String[] args) {
         int[] arr;
         arr = new int[]{0,1,0,3,12};
         moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
