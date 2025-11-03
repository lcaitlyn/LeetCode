import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // int[0] = index, int[1] = height
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.add(new int[]{i, heights[i]});
            } else {
                if (heights[i] >= stack.peek()[1]) {
                    stack.add(new int[]{i, heights[i]});
                } else {
                    int[] top = stack.peek();
                    while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                        int[] bottom = stack.pop();
                        res = Math.max(res, bottom[1] * (i - bottom[0]));
                        res = Math.max(res, heights[i] * (i - bottom[0] + 1));
                        if (stack.isEmpty() || stack.peek()[1] < heights[i]) stack.add(new int[]{bottom[0], heights[i]});
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] bottom = stack.pop();
            res = Math.max(res, bottom[1] * (heights.length - bottom[0]));
        }
        return res;
    }

//    beats 83% memory 91% runtime 59ms
//    ебал я рот этой хуйни
//    как всегда много корнер кейсов. только с 9 раза запушил сука
//    сделал по гайдам.
//    хули я брут форсом то не сделал нахуй?

    public static void main(String[] args) {
        System.out.println("10 -> " + largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println("4 -> " + largestRectangleArea(new int[]{2, 4}));
        System.out.println("2 -> " + largestRectangleArea(new int[]{1, 1}));
        System.out.println("3 -> " + largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println("8 -> " + largestRectangleArea(new int[]{5,4,1,2}));
        System.out.println("6 -> " + largestRectangleArea(new int[]{0,3,2,5}));
        System.out.println("6 -> " + largestRectangleArea(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("14 -> " + largestRectangleArea(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
        System.out.println("14 -> " + largestRectangleArea(new int[]{0,3,1,4,5,3,2,7,5,3,0}));
    }
}
