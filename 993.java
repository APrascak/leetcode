// Cousins in Binary Tree
// 6 April 2020

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList();
        Map<Integer, TreeNode> map = new HashMap<>();
        int pos = 0;
        boolean sameLevel = false;
        boolean foundOne = false;
        int xPos = Integer.MAX_VALUE, yPos = Integer.MAX_VALUE;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode ref = queue.poll();
                if (ref == null) {
                    pos++;
                    continue;
                }
                if (ref.val == x) {
                    xPos = pos;
                    if (foundOne) {
                        sameLevel = true;
                    }
                    foundOne = true;
                }
                if (ref.val == y) {
                    yPos = pos;
                    if (foundOne) {
                        sameLevel = true;
                    }
                    foundOne = true;
                }
                map.put(pos, ref);
                pos++;
                queue.offer(ref.left);
                queue.offer(ref.right);
            }
            if (foundOne && !sameLevel) return false;
        }
        if (xPos % 2 == 1) {
            return (yPos != xPos+1);
        } else {
            return (yPos != xPos-1);
        }
        
    }
}