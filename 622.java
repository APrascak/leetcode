// Design Circular Queue
// 30 March 2020

class MyCircularQueue {
    int[] queue;
    int head, tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = -1;
        this.tail = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (head == -1) {
            head = 0;
            tail = 0;
            queue[0] = value;
            return true;
        }
        if (tail + 1 == queue.length) {
            if (head == 0) {
                return false;
            } else {
                tail = 0;
                queue[tail] = value;
                return true;
            }
        }
        if (tail + 1 == head) {
            return false;
        } else {
            tail++;
            queue[tail] = value;
        }
        return true;
        
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty()) { return false; }
        head++;
        if (head == tail+1) {
            head = -1;
            tail = -1;
        }
        if (head == queue.length) {
            if (tail == queue.length-1) {
                head = -1;
                tail = -1;
            }
            tail = 0;
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (head != -1) {
            return queue[head];
        }
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (tail != -1) {
            return queue[tail];
        }
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (head == -1);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (tail+1 == head) { return true; }
        if (tail == queue.length-1 && head==0) { return true; }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */