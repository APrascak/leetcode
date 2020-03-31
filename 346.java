// Moving Average from Data Stream
// 30 March 2020

class MovingAverage {
    Queue<Integer> queue;
    int amount, capacity, total;
    double average;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList();
        this.capacity = size;
        this.amount = 0;
        this.total = 0;
    }
    
    public double next(int val) {
        if (amount == 0) {
            average = val;
            queue.offer(val);
            total = val;
            amount++;
            return average;
        } else if (capacity == amount) {
            total -= queue.remove();
            total += val;
            average = ((double) total) / capacity;
            queue.offer(val);
            return average;
        } else {
            amount++;
            total += val;
            average = (double) total / amount;
            queue.offer(val);
            return average;
        }
        
        // return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */