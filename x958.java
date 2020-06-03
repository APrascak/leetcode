// Check Completeness of a Binary Tree
// 2 June 2020

// O(n) time, O(n) space
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int row = 0;
        while (!queue.isEmpty()) {
            int levelSize = (int) Math.pow(2,row);
            int size = queue.size();
            boolean lastRow = false;
            boolean nextRowIsLastRow = false;
            if (size < levelSize)
                lastRow = true;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    if (lastRow || nextRowIsLastRow)
                        return false;
                    queue.offer(curr.left);
                } else {
                    if (!lastRow && !nextRowIsLastRow) {
                        nextRowIsLastRow = true;
                    }
                }
                if (curr.right != null) {
                    if (lastRow || nextRowIsLastRow)
                        return false;
                    queue.offer(curr.right);
                } else {
                    if (!lastRow && !nextRowIsLastRow) {
                        nextRowIsLastRow = true;
                    }
                }
            }
            row++;
        }
        return true;
    }
}