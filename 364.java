// Nested List Weight Sum II
// 29 April 2020

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int answer;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<NestedInteger> queue = new LinkedList();
        int depth = 0;
        for (NestedInteger curr : nestedList) {
            queue.offer(curr);
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.poll();
                if (curr.getInteger() != null) {
                    level.add(curr.getInteger());
                    continue;
                } else {
                    for (int j = 0; j < curr.getList().size(); j++) {
                        queue.offer(curr.getList().get(j));
                    }
                }
            }
            levels.add(level);
        }
        int sum = 0;
        for (int i = 0; i < levels.size(); i++) {
            for (Integer num : levels.get(i)) {
                // System.out.println(num * (levels.size() - i));
                sum += num * (levels.size() - i);
            }
        }
        return sum;
    }
}