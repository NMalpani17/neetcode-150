// Problem  : Remove Nth Node From End of List
// Link     : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Difficulty: Medium
// Pattern  : Fast & Slow Pointers
// Time     : O(n) | Space: O(1)

class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = new ListNode(-1, head);
        ListNode newHead = left;
        while (n > 0) {
            head = head.next;
            n--;
        }
        while (head != null) {
            head = head.next;
            left = left.next;
        }
        left.next = left.next.next;
        return newHead.next;
    }
}