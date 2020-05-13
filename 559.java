// Maximum Depth of N-ary Tree
// 12 May 2020

// Top-Down Solution: O(n) time and space
class Solution {
    int max;
    
    public int maxDepth(Node root) {
        max = 0;
        helper(root, 1);
        return max;
    }
    
    private void helper(Node root, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        for (Node child : root.children)
            helper(child, depth+1);
    }
}

// Bottom-Up Solution: O(n) time and space
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int curr = 0;
        for (Node child : root.children)
            curr = Math.max(curr, maxDepth(child));
        return curr + 1;
    }
}