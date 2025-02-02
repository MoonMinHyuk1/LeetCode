class MinStack {

    Stack<Integer> stack;
    Map<Integer, Integer> map;

    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int val = stack.pop();
        map.put(val, map.get(val) - 1);
        if (map.get(val) == 0) {
            map.remove(val);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int val: map.keySet()) {
            min = val;
            break;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */