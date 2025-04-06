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
        if(head==null) return null;
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        temp = head;
        while(temp!=null){
            Node node = temp.next;
            if(temp.random!=null) node.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = temp.next;
        Node ansHead = newHead;
        while(temp!=null){
            temp.next = newHead.next;
            if(temp.next!=null){
                newHead.next = temp.next.next;
            }
            temp = temp.next;
            newHead = newHead.next;
        }
        return ansHead;
    }
}