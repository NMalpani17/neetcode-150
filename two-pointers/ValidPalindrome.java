// Problem  : Valid Palindrome
// Link     : https://leetcode.com/problems/valid-palindrome/
// Difficulty: Easy
// Pattern  : Two Pointers
// Time     : O(n) | Space: O(1)

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i <= j && s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}