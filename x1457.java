// Pseudo-Palindromic Paths in a Binary Tree
// 24 May 2020

// O(n) time and space
class Solution {
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        helper(root, "");
        return count;
    }
    
    private void helper(TreeNode curr, String s) {
        //System.out.println(String.valueOf(curr.val));
        if (curr.left == null && curr.right == null) {
            s += String.valueOf(curr.val);
            System.out.println(s);
            if (pseudo(s)) {
                count++;
            }
        }
        if (curr.left != null)
            helper(curr.left, s + String.valueOf(curr.val));
        if (curr.right != null)
            helper(curr.right, s+String.valueOf(curr.val));
    }
    
    private boolean pseudo(String s) {
        Set<Character> set = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }
}