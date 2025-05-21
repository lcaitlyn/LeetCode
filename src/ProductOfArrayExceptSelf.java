public class ProductOfArrayExceptSelf {
    

    // public static int[] productExceptSelf(int[] nums) {
    //     int prefix = 1;
    //     int [] prefixArr = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         prefixArr[i] = prefix;
    //         prefix *= nums[i];
    //     }

    //     int postfix = 1;
    //     int [] postfixArr = new int[nums.length];
    //     for (int i = nums.length - 1; i >= 0; i--) {
    //         postfixArr[i] = postfix;
    //         postfix *= nums[i];
    //     }

    //     for (int i = 0; i < postfixArr.length; i++) {
    //         prefixArr[i] *= postfixArr[i];
    //     }

    //     return prefixArr;
    // }

//  Результат 1ms Beats 99.5% Memory 25%


    public static int[] productExceptSelf(int[] nums) {
        int p = 1;
        int [] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = p;
            prefix *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= p;
            p *= nums[i];
        }

        return arr;
    }

    // результаты те же. чуть по мемори выросло

    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3,4};
        for (Integer i : productExceptSelf(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
