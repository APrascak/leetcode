// LRU Cache
// 1 April 2020

class LRUCache {
    Queue<Integer> queue = new LinkedList();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int n;
    
    public LRUCache(int capacity) {
        n = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Queue<Integer> temp = new LinkedList();
            while (queue.peek() != key) {
                temp.offer(queue.poll());
            }
            queue.poll();
            while (!queue.isEmpty()) {
                temp.offer(queue.poll());
            }
            temp.offer(key);
            queue = temp;
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if (queue.size() == 0) {
            queue.offer(key);
            map.put(key, value);
        } else if (queue.size() == n) {
            if (map.containsKey(key)) {
                map.put(key,value);
                Queue<Integer> temp = new LinkedList();
                while (queue.peek() != key) {
                    temp.offer(queue.poll());
                }
                queue.poll();
                while (!queue.isEmpty()) {
                    temp.offer(queue.poll());
                }
                temp.offer(key);
                queue = temp;
            } else {
                map.remove(queue.poll());
                map.put(key, value);
                queue.offer(key);
            }
        } else {
            if (map.containsKey(key)) {
                map.put(key,value);
                Queue<Integer> temp = new LinkedList();
                while (queue.peek() != key) {
                    temp.offer(queue.poll());
                }
                queue.poll();
                while (!queue.isEmpty()) {
                    temp.offer(queue.poll());
                }
                temp.offer(key);
                queue = temp;
            } else {
                queue.offer(key);
                map.put(key, value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */