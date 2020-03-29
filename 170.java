// Two Sum III - Data structure design
// 29 March 2020

class TwoSum {
    List<Integer> values;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.values = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.values.add(number);
        Collections.sort(this.values);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int i = 0, j = this.values.size()-1;
        while (i < j) {
            int sum = this.values.get(i) + this.values.get(j);
            if (sum == value) {
                return true;
            } else if (sum < value) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */