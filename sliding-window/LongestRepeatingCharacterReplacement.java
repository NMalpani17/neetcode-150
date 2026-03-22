// Problem  : Longest Repeating Character Replacement
// Link     : https://leetcode.com/problems/longest-repeating-character-replacement/
// Difficulty: Medium
// Pattern  : Sliding Window
// Time     : O(n) | Space: O(1)

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, maxCount = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(j) - 'A']);
            int length = j - i + 1;
            if (length - maxCount <= k) {
                maxLen = Math.max(maxLen, length);
            } else {
                count[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return maxLen;
    }
}