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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list: lists){
            if(list != null){
                q.add(list);
            }
        }

        while(!q.isEmpty()){
            ListNode x = q.poll();
            if(x.next != null){
                q.add(x.next);
            }
            curr.next = x;
            curr = curr.next;
        }

        return dummy.next;
    }
}