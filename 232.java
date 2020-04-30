// Implement Queue using Stacks
// 29 April 2020

class MyQueue {
    Stack<Integer> stack;
    int top;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        if (stack.size() == 1) top = x;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> buffer = new Stack<>();
        int curr = stack.peek();
        while (!stack.isEmpty()) {
            curr = stack.peek();
            buffer.push(stack.pop());
        }
        buffer.pop();
        if (!buffer.isEmpty()) top = buffer.peek();
        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
        return curr;
    }
    
    /** Get the front element. */
    public int peek() {
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */