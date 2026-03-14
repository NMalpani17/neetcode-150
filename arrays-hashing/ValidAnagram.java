// Problem  : Valid Anagram
// Link     : https://leetcode.com/problems/valid-anagram/
// Difficulty: Easy
// Pattern  : Hashing
// Time     : O(n) | Space: O(1)

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}