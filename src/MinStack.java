import java.util.Stack;

public class MinStack {
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(new int[]{val, val});
            return;
        }

        int curMin = stack.peek()[1]; 
        if (val < curMin) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, curMin});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

    // Результат 4ms beats 97%.
    // Крч юзаю обычный стек, но вместо обычного integer, юзаю integer[],
    // где int[0] = значение val, int[1] = минимальное значение на текущей ноде 
