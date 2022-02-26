// leetcode 148
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
        if (head == null || head.next == null) return head;
        
        ListNode middle = findMiddle(head);
        ListNode startLeft = sortList(head);
        ListNode startRight = sortList(middle);
        
        return combineList(startLeft, startRight);
    }
    
    private ListNode combineList(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                ptr.next = left;
                left = left.next;
            }
            else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }
        
        if (left != null) {
            ptr.next = left;
        } else if (right != null) {
            ptr.next = right;
        }
        
        return head.next;
    }
    
    private ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        // 1, 2
        // 1, 2, 3
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }
}