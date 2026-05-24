/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return inOrderTraversal(root, k);

    }

    int inOrderTraversal(TreeNode root, int k) {
        var stack = new ArrayDeque<TreeNode>();
        diveLeft(root, stack);
        while (!stack.isEmpty()) {
            var current = stack.pop();

            k--;
            if (k == 0) {
                return current.val;
            }
            diveLeft(current.right, stack);
        }
        return -1;
    }
    void diveLeft(TreeNode current, Deque<TreeNode> stack) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }
}
