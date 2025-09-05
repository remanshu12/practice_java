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
    class pair{
        int val;
        ListNode node;
        pair(int value,ListNode n){
            val=value;
            node=n;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(new pair(head.val,head));
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            pair curr=pq.poll();

            temp.next=curr.node;
            temp=temp.next;

            if(curr.node.next!=null){
                pq.add(new pair(curr.node.next.val,curr.node.next));
            }
        }
        return dummy.next;
    }
}