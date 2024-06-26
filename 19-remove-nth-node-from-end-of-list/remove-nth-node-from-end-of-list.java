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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head; 
        ListNode prev = head;

        for(int i = 0; i<n; i++){
            curr = curr.next;
        }

        if(curr == null){
            return head.next;
        }

        while(curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }

        ListNode del = prev.next;
        prev.next = prev.next.next;
        del = null;
        return head;
    }
}