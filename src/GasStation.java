public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0, total = 0, ans = 0;

        for (int i = 0; i < gas.length; i++) {
            if (diff < 0) {
                ans = i;
                diff = 0;
            }
            total += gas[i] - cost[i];
            diff += gas[i] - cost[i];
        }

        if (total < 0) return -1;
        return ans;
    }

//    beats 97.64% memory 68% runtime 2ms
//    че то с первого раза решил. прикол конечно

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
