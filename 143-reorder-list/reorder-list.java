/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head != null && head.next!=null){
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode newHead = reverse(slow.next);
            slow = head;
            fast = newHead;
            ListNode nextSlow = null;
            ListNode nextFast = null;
            while(fast!=null){
                nextSlow = slow.next;
                nextFast = fast.next;
                slow.next = fast;
                fast.next = nextSlow;
                slow = nextSlow;
                fast = nextFast;
            }
            slow.next = null;
        }
    }

    public ListNode reverse(ListNode root){
        ListNode current = null;
        ListNode prev = null;
        while(root!=null){
            current = root;
            root = root.next;
            current.next = prev;
            prev = current;
        }
        return prev;
    }

    void Print(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }
}