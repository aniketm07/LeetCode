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
    public boolean isPalindrome(ListNode head) {
        // print(head);
        if(head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHead = reverse(slow.next);
        // print(reversedHead);
        fast = reversedHead;
        slow = head;
        while(fast!=null){
            if(fast.val!=slow.val){
                reverse(reversedHead);
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        reverse(reversedHead);
        return true;
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

    void print(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }
}