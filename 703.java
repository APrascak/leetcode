// Kth Largest Element in a Stream
// 23 March 2020

class KthLargest {

    private int largest;
    private ArrayList<Integer> values;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        values = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            values.add(nums[i]);
        }
        Collections.sort(values);
        if (values.size() - k >= 0) {
            largest = values.get(nums.length-k);
        }
    }
    
    public int add(int val) {
        for (int i = 0; i < this.values.size();) {
            if (this.values.get(i) >= val) {
                this.values.add(i,val);
                break;
            }
            i++;
            if (i == this.values.size()) {
                this.values.add(val);
                i++;
            }
        }
        if (this.values.size() == 0) {
            this.values.add(val);
        }
        if (values.size() - k >= 0) {
            this.largest = this.values.get(this.values.size()-k);
        }
        return this.largest;
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */