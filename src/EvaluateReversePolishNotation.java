import java.util.Stack;

public class EvaluateReversePolishNotation {
    
    private static int action(int a, int b, char o) {
        if (o == '+') {
            return a + b;
        } else if (o == '-') {
            return a - b;
        } else if (o == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    private static boolean isOperand(String s) {
        return (s.length() == 1 && (s.charAt(0) == '+'
                || s.charAt(0) == '-'
                || s.charAt(0) == '*' 
                || s.charAt(0) == '/')
        );
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        
        int i = 0;
        while (i < tokens.length) {
            if (isOperand(tokens[i])) {
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(action(a, b, tokens[i].charAt(0)));
            } else {
                numbers.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return numbers.pop();
    }

    // Результат 5 мс. Beats 97.77%
    // В принципе решение уже находилось в условиях задачи. Хз почему медиум

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
