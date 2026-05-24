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
        var state = new int[]{k, -1};
        inOrderTraversal(root, state);
        return state[1];
    }

    void inOrderTraversal(TreeNode current, int[] state) {
        if (current == null || state[0] == 0) {
            return;
        }

        inOrderTraversal(current.left, state);

        state[0]--;
        if (state[0] == 0) {
            state[1] = current.val;
            return;
        }

        inOrderTraversal(current.right, state);
    }
}
