import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (l == r) return res + 1;

            if (people[r] + people[r - 1] <= limit) {
                r--;
            } else if (people[r] + people[l] <= limit) {
                l++;
            }

            r--;
            res++;
        }

        return res;
    }

//    beats 22.75% runtime 21ms memory 75%
//    бля очень странно, но там идет (21ms самое поплуряное решение, график идет снизу вверх к нему, а не наоборот)

    public static void main(String[] args) {
        System.out.println("3 -> " + numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
    }
}
