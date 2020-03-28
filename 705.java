// Design HashSet
// 27 March 2020

class MyHashSet {
    Bucket[] container;
    Integer hashKey;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashKey   = 769; // Large prime number as hashing key
        this.container = new Bucket[769]; // Initialize array to hold linked lists
        // Iterate through array and add buckets that are essentially linked lists
        for (int i=0; i<this.hashKey ;i++) {
            this.container[i] = new Bucket();
        }
        
    }
    
    public void add(int key) {
        int index = this.hash(key);
        this.container[index].insert(key);
    }
    
    public void remove(int key) {
        int index = this.hash(key);
        this.container[index].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = this.hash(key);
        return (this.container[index].exists(key));
    }
    
    // Hashing function - extra
    protected int hash(int key) {
        return (key % this.hashKey);
    }
}

class Bucket {
    private LinkedList<Integer> container;
    
    // Constructor initializes linkedlist
    public Bucket() {
        container = new LinkedList<Integer>();
    }
    
    // Adds to linkedlist only if the key already isn't in the bucket
    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }
    
    // Removes the key from the linkedlist
    public void delete(Integer key) {
        this.container.remove(key);
    }
    
    // Returns if the key can be found in the linkedlist
    public boolean exists (Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */