// leetcode 234
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode reversedSecondHalf = reverseList(slow.next);
        ListNode ptr = reversedSecondHalf;
        slow.next = null;
        
        while (ptr != null) {
            if (ptr.val != head.val) {
                return false;
            }
            ptr = ptr.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = ptr;
            ptr = head;
            head = next;
        }
        
        return ptr;
    }
}
