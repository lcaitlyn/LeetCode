public class MissingNumber {
    
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            res += nums[i];
        }


        return sum + nums.length - res;
    }

    public static void main(String[] args) {
        missingNumber(new int[]{3,0,1,4,5});
        missingNumber(new int[]{3,0,1});
        missingNumber(new int[]{3,0,1,4,5,6,7,8,9});
        System.out.println(missingNumber(new int[]{3,2,1,4,0,6,7,8,5}));
    }
}
