// Problem  : Permutation in String
// Link     : https://leetcode.com/problems/permutation-in-string/
// Difficulty: Medium
// Pattern  : Sliding Window
// Time     : O(n) | Space: O(1)

import java.util.Arrays;

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for (char s : s1.toCharArray()) s1count[s - 'a']++;
        for (int i = 0; i < s1.length(); i++) s2count[s2.charAt(i) - 'a']++;

        if (Arrays.equals(s1count, s2count)) return true;

        for (int j = s1.length(); j < s2.length(); j++) {
            s2count[s2.charAt(j) - 'a']++;
            s2count[s2.charAt(j - s1.length()) - 'a']--;
            if (Arrays.equals(s1count, s2count)) return true;
        }
        return false;
    }
}