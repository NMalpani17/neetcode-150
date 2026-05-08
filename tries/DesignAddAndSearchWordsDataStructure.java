// Problem  : Design Add and Search Words Data Structure
// Link     : https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Difficulty: Medium
// Pattern  : Trie + Backtracking
// Time     : O(n) per operation | Space: O(n)

class WordDictionary {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() { children = new TrieNode[26]; }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word, root, 0);
    }

    public boolean helper(String word, TrieNode root, int idx) {
        if (idx == word.length()) return root.isEnd;
        char c = word.charAt(idx);
        if (c == '.') {
            for (TrieNode child : root.children) {
                if (child != null && helper(word, child, idx + 1)) return true;
            }
            return false;
        }
        TrieNode next = root.children[c - 'a'];
        return next != null && helper(word, next, idx + 1);
    }
}