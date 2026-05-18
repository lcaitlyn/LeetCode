import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0) {
                while (!s.isEmpty()
                        && s.peek() > 0 && asteroids[i] < 0
                        && s.peek() < Math.abs(asteroids[i])) {
                    s.pop();
                }

                if (!s.isEmpty() && s.peek() > Math.abs(asteroids[i])) continue;

                if (!s.isEmpty() && s.peek() == Math.abs(asteroids[i])) {
                    s.pop();
                    continue;
                }
            }

            s.add(asteroids[i]);
        }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }

//    runtime 6ms beats 20.28% memory 55%

    public static void main(String[] args) {
        System.out.println("[-2, -2 -2] -> " + Arrays.toString(asteroidCollision(new int[]{-2, -2, 1, -2})));
    }
}
