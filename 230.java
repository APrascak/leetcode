// Kth Smallest Element in a BST
// 20 May 2020

// O(n) time and O(n) space
// Does not need extra set or list to store values
class Solution {
    int k;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    
    private void helper(TreeNode curr) {
        if (curr == null)
            return;
        helper(curr.left);
        k--;
        if (k == 0) {
            ans = curr.val;
            return;
        }
        helper(curr.right);
    }
}

// O(n) time and O(n) space
// Uses set to store inorder values
class Solution {
    Set<Integer> set;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        set = new HashSet<>();
        this.k = k;
        iterate(root);
        return findKth();
    }
    
    private void iterate(TreeNode curr) {
        if (curr == null)
            return;
        iterate(curr.left);
        if (set.size() < k) {
            set.add(curr.val);
            if (set.size() < k)
                iterate(curr.right);
        } else {
            return;
        }
    }
    
    private int findKth() {
        int ans = Integer.MIN_VALUE;
        for (int num : set)
            ans = Math.max(ans,num);
        return ans;
    }
}