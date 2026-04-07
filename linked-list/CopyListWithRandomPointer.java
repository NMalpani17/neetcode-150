// Problem  : Copy List with Random Pointer
// Link     : https://leetcode.com/problems/copy-list-with-random-pointer/
// Difficulty: Medium
// Pattern  : Linked List + HashMap
// Time     : O(n) | Space: O(n)

import java.util.HashMap;

class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node headMain = head;
        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return map.get(headMain);
    }
}