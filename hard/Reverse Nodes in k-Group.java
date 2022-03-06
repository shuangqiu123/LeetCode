// leetcode 25
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode start = new ListNode();
        ListNode node = head;
        ListNode ptr = start;

        while (node != null) {
            // 1
            ListNode beforeFirst = node;
            
            for (int i = 0; i < k - 1 && node != null; i++) {
                node = node.next;
            }
            if (node == null) {
                start.next = beforeFirst;
                break;
            }
            ListNode next = node.next;
            node.next = null;
            // 3
            // 2 --> 1
            ListNode reversedList = reverseNode(beforeFirst);
            // -1 --- > 2 --> 1
            start.next = reversedList;
            // 1
            start = beforeFirst;
            node = next;
        }
        return ptr.next;
    }
    
    private ListNode reverseNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode ptr = null;
        
        while (node != null) {
            ListNode next = node.next;
            node.next = ptr;
            ptr = node;
            node = next;
        }
        return ptr;
    }
}