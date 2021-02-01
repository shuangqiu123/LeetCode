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
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();
    
    // bottom up approach
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int count = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        
        for (int size=1;size<count;size=size*2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
        }
        
    }
    
    
    
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode ptr = node;
        
        while (list1!=null && list2 != null) {
            if (list1.val > list2.val) {
                ptr.next = list2;
                ptr = ptr.next;
                list2 = list2.next;
            } else {
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            }
        }
        
        if (list1 != null) ptr.next = list1;
        else if (list2 != null) ptr.next = list2;
        
        return node.next;
    }
    
    
    private int getCount(ListNode head) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }
}