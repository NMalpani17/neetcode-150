// Problem  : Longest Substring Without Repeating Characters
// Link     : https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Difficulty: Medium
// Pattern  : Sliding Window
// Time     : O(n) | Space: O(1)

import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (j < s.length()) {
            if (!uniqueChars.contains(s.charAt(j))) {
                uniqueChars.add(s.charAt(j));
                max = Math.max(max, uniqueChars.size());
                j++;
            } else {
                uniqueChars.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}