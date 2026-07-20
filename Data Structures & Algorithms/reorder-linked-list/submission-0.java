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
        if(head==null||head.next==null){
            return;
        }
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null; // cut the first half
        merge(head,second);
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    private void merge(ListNode l1,ListNode l2){
        while(l1!=null&&l2!=null){
            ListNode l1_next=l1.next;
                        ListNode l2_next=l2.next;
            l1.next=l2;
            if(l1_next==null)break;
            l2.next=l1_next;
            l1=l1_next;
            l2=l2_next;
        }

    }
}
