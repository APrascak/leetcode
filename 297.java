// Serialize and Deserialize Binary Tree
// 27 April 2020

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        String answer = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            String line = "";
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (queue.peek() == null) {
                    line += "null,";
                    queue.poll();
                } else {
                    TreeNode ref = queue.poll();
                    line += ref.val;
                    line += ",";
                    found = true;
                    queue.offer(ref.left);
                    queue.offer(ref.right);
                }
            }
            if (found == true) {
                answer += line;
            } else {
                break;
            }
        }
        return answer;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> queue = new LinkedList();
        String[] arr = data.split(",");
        int i = 0;
        TreeNode ref = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(ref);
        i++;
        while (i < arr.length) {
            TreeNode curr = queue.poll();
            System.out.println("curr: " + curr.val + " " + arr[i]);
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = left;
                queue.offer(left);
            }
            i++;
            System.out.println("curr: " + curr.val + " " + arr[i]);
            if (!arr[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                System.out.println(right.val);
                curr.right = right;
                queue.offer(right);
            }
            i++;
        }
        return ref;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));