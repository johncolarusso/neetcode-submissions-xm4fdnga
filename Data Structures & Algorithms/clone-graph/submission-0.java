/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        var visited = new HashMap<Node, Node>();
        if (node == null) {
            return null;
        }
        return dfs(node, visited);
    }

    Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        var clonedNode = new Node(node.val);
        visited.put(node, clonedNode);

        for (var neighbor : node.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor, visited));
        }
        return clonedNode;
    }
}