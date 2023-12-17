class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if ((c == '(' || c == '[' || c == '{') && !stack.contains(c)) {
                stack.push(c);
            } else if (!stack.empty() && stack.lastElement() != c) {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}
