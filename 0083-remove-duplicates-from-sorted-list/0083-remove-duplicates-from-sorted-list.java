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
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode next = new ListNode(0);
        ListNode dummy = next;
        while(head != null){
            if(!res.contains(head.val)) res.add(head.val);
            head = head.next;
        }
        for(int i : res){
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        return next.next;
    }
}