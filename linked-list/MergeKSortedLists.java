// Problem  : Merge K Sorted Lists
// Link     : https://leetcode.com/problems/merge-k-sorted-lists/
// Difficulty: Hard
// Pattern  : Linked List + Divide and Conquer
// Time     : O(n log k) | Space: O(1)

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int partition = 1;
        while (partition < lists.length) {
            for (int i = 0; i + partition < lists.length; i += 2 * partition) {
                lists[i] = mergeList(lists[i], lists[i + partition]);
            }
            partition *= 2;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) { temp.next = node2; node2 = node2.next; }
            else { temp.next = node1; node1 = node1.next; }
            temp = temp.next;
        }
        if (node1 != null) temp.next = node1;
        if (node2 != null) temp.next = node2;
        return head.next;
    }
}