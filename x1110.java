// Delete Nodes And Return Forest
// 2 June 2020

// O(n) time, O(n) space
class Solution {
    Set<Integer> set;
    List<TreeNode> answer;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        answer = new ArrayList<>();
        for (int num : to_delete)
            set.add(num);
        if (set.contains(root.val)) {
            helper(root,true);
        } else {
            answer.add(root);
            helper(root, false);
        }
        return answer;
    }
    
    private void helper(TreeNode curr, boolean removed) {
        if (curr == null)
            return;
        if (curr.left != null && set.contains(curr.left.val)) {
            helper(curr.left, true);
            curr.left = null;
        } else {
            if (removed && curr.left != null)
                answer.add(curr.left);
            helper(curr.left, false);
        }
        if (curr.right != null && set.contains(curr.right.val)) {
            helper(curr.right, true);
            curr.right = null;
        } else {
            if (removed && curr.right != null)
                answer.add(curr.right);
            helper(curr.right, false);
        }
    }
}