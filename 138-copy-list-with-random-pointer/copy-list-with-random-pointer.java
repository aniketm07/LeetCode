/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tempHead = head;
        Node dummyNode = new Node(-1);
        Node newListHead = dummyNode;
        Map<Node, Node> nodeMap = new HashMap<>();
        while(tempHead != null){
            Node newNode = new Node(tempHead.val);
            dummyNode.next = newNode;
            nodeMap.put(tempHead, newNode);
            dummyNode = dummyNode.next;
            // System.out.println("New List: " + dummyNode.val + " OG List: " + tempHead.val);
            tempHead = tempHead.next;
        }
        tempHead = head;
        while(tempHead != null){
            Node randomPointer = tempHead.random;
            Node currentPositionNode = nodeMap.get(tempHead);
            currentPositionNode.random = nodeMap.get(randomPointer);
            tempHead = tempHead.next;
        }
        return newListHead.next;
    } 
}

/*
(7,null, null)

*/