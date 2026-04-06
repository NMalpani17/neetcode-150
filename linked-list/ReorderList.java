// Problem  : Reorder List
// Link     : https://leetcode.com/problems/reorder-list/
// Difficulty: Medium
// Pattern  : Fast & Slow Pointers + Reverse Linked List
// Time     : O(n) | Space: O(1)

class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next, prev = null;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (head != null && prev != null) {
            ListNode next = head.next;
            ListNode prevNext = prev.next;
            head.next = prev;
            prev.next = next;
            prev = prevNext;
            head = next;
        }
    }
}