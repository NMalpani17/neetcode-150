// Problem  : Add Two Numbers
// Link     : https://leetcode.com/problems/add-two-numbers/
// Difficulty: Medium
// Pattern  : Linked List
// Time     : O(n) | Space: O(1)

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            carry = sum / 10;
            temp.next = new ListNode(sum % 10, null);
            temp = temp.next;
        }
        return head.next;
    }
}