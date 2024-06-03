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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = getmiddle(head);
        ListNode middle_next = middle.next;

        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middle_next);

        ListNode sortedList = sortedmerge(left, right);
        return sortedList;
        
    }

    public ListNode getmiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortedmerge(ListNode a, ListNode b){
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedmerge(a.next, b);
        } else {
            result = b;
            result.next = sortedmerge(a, b.next);
        }
        return result;
    }
}