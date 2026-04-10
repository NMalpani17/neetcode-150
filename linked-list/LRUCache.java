// Problem  : LRU Cache
// Link     : https://leetcode.com/problems/lru-cache/
// Difficulty: Medium
// Pattern  : Doubly Linked List + HashMap
// Time     : O(1) get and put | Space: O(n)

import java.util.HashMap;

class LRUCache {

    class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) { this.key = key; this.val = val; }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }
        if (map.size() >= capacity) {
            Node evict = head.next;
            head.next = evict.next;
            head.next.prev = head;
            map.remove(evict.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void moveToTail(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}