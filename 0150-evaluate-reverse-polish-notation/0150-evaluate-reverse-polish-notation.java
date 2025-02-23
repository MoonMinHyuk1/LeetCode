class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String s: tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(a + b));
                } else if (s.equals("-")) {
                    stack.push(String.valueOf(a - b));
                } else if (s.equals("*")) {
                    stack.push(String.valueOf(a * b));
                } else if (s.equals("/")) {
                    stack.push(String.valueOf(a / b));
                }
            } else {
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}