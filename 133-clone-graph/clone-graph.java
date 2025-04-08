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
    public Node cloneGraph(Node root) {
        if(root == null){
            return null;
        }
        Node res = null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(root);
        set.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            Node newNode = new Node(node.val);
            System.out.println(node.val);
            map.put(node, newNode);
            if(res == null){
                res = newNode;
            }
            for(Node adj : node.neighbors){
                if(!set.contains(adj)){
                    queue.offer(adj);
                    set.add(adj);
                }
            }
        }

        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node key = entry.getKey();
            Node value = entry.getValue();
            value.neighbors = new ArrayList<>();
            for(Node adj : key.neighbors){
                value.neighbors.add(map.get(adj));
            }
        }

        return res;
    }
}