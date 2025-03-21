/*
// Definition for a Node.
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
        if (node == null) {
            return node;
        }
        Map<Integer, Node> visited = new HashMap<>();

        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node newNode = new Node(node.val);

        visited.put(node.val, newNode);
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, visited));
        }

        return newNode;
    }
}