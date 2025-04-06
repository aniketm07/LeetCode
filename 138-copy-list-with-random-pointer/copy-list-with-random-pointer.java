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
        Node dummy = head;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node prev = null;
        while(dummy!=null){
            Node node = new Node(dummy.val);
            nodeMap.put(dummy, node);
            if(prev!=null){
                prev.next = node;
            }
            prev = node;
            dummy = dummy.next;
        }
        Node newHead = nodeMap.get(head);
        Node dummyHead = newHead;
        dummy = head;
        while(dummy!=null){
            Node random = nodeMap.get(dummy.random);
            dummyHead.random = random;
            dummyHead = dummyHead.next;
            dummy = dummy.next;
        }
        return newHead;
    }
}