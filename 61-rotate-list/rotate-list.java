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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode front=head;
        ListNode back=head;
        int count=0;
        if(head==null || head.next==null){
            return head;
        }
       
    ListNode temp=head;
    while(temp!=null){
        count++;
        temp=temp.next;
    }
    k=k%count;
     if(k==0){
            return head;
        }
        while(k!=0){
            k--;
            front=front.next;
        }
        while(front.next!=null){
            front=front.next;
            back=back.next;
        }
        ListNode newhead=back.next;
        back.next=null;
        front.next=head;
return newhead;


    }}