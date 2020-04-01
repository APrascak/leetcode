// Min Stack
// 1 April 2020

class MinStack {
    Stack<Integer> data;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (data.isEmpty()) {
            min = x;
        } else {
            min = Math.min(min, x);
        }
        data.push(x);
    }
    
    public void pop() {
        if (data.isEmpty()) return;
        if (data.peek() == min) {
            data.pop();
            if (data.isEmpty()) return;
            min = data.peek();
            Stack<Integer> temp = new Stack<Integer>();
            while (!data.isEmpty()) {
                min = Math.min(min, data.peek());
                temp.push(data.pop());
            }
            while (!temp.isEmpty()) {
                data.push(temp.pop());
            }
        } else {
            data.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */