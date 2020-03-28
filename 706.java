// Design HashMap
// 27 March 2020

class MyHashMap {
    private Integer hashKey;
    private List<Bucket> hash_table;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hashKey = 769;
        this.hash_table = new ArrayList<Bucket>();
        for (int i = 0; i < this.hashKey; i++) {
            this.hash_table.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int calculatedKey = key % this.hashKey;
        this.hash_table.get(calculatedKey).update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int calculatedKey = key % this.hashKey;
        return this.hash_table.get(calculatedKey).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int calculatedKey = key % this.hashKey;
        this.hash_table.get(calculatedKey).remove(key);
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if (!found) {
            this.bucket.add(new Pair<Integer, Integer>(key,value));
        }
    }
    
    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
    
}

class Pair<U,V> {
    public U first;
    public V second;
    
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */