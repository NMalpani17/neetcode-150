// Problem  : Merge Two Sorted Lists
// Link     : https://leetcode.com/problems/merge-two-sorted-lists/
// Difficulty: Easy
// Pattern  : Linked List
// Time     : O(n) | Space: O(1)

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        return dummy.next;
    }
}