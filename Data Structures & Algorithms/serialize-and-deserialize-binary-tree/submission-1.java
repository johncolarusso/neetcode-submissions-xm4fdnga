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

public class Codec {

    private static final String NULL = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var nodes = new ArrayList<String>();
        dfsSerialize(root, nodes);
        return String.join(",", nodes);
    }

    void dfsSerialize(TreeNode node, List<String> nodes) {
        if (node != null) {
            nodes.add(String.valueOf(node.val));
            dfsSerialize(node.left, nodes);
            dfsSerialize(node.right, nodes);
        } else {
            nodes.add(NULL);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] position = new int[1];
        return dfsDeserialize(nodes, position);
    }

    TreeNode dfsDeserialize(String[] nodes, int[] position) {
        if (nodes[position[0]].equals(NULL)) {
            position[0]++;
            return null;
        } else {
            TreeNode current = new TreeNode(Integer.parseInt(nodes[position[0]]));
            position[0]++;
            current.left = dfsDeserialize(nodes, position);
            current.right = dfsDeserialize(nodes, position);
            return current;
        }
    }
}
