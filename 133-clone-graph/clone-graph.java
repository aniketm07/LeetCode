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
        if (node == null) return null;
        return cloneNode(node, new HashMap<>());
    }
    public Node cloneNode(Node node, Map<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) return oldToNew.get(node);
        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);
        List<Node> neighbors = node.neighbors;
        List<Node> newNodeNeighbors = new ArrayList<>();
        for (Node nei : neighbors) {
            newNodeNeighbors.add(cloneNode(nei, oldToNew));
        }
        newNode.neighbors = newNodeNeighbors;
        return newNode;
    }
}