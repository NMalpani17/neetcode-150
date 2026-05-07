// Problem  : Implement Trie (Prefix Tree)
// Link     : https://leetcode.com/problems/implement-trie-prefix-tree/
// Difficulty: Medium
// Pattern  : Trie
// Time     : O(n) per operation | Space: O(n)

class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        TrieNode() { this.children = new TrieNode[26]; }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return true;
    }
}