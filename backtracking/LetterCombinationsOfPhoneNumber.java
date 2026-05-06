// Problem  : Letter Combinations of a Phone Number
// Link     : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(4^n) | Space: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> letters = new HashMap<>();
        letters.put(2, "abc"); letters.put(3, "def"); letters.put(4, "ghi");
        letters.put(5, "jkl"); letters.put(6, "mno"); letters.put(7, "pqrs");
        letters.put(8, "tuv"); letters.put(9, "wxyz");
        List<String> combinations = new ArrayList<>();
        helper(digits, 0, letters, combinations, new StringBuilder());
        return combinations;
    }

    public void helper(String digits, int pivot, HashMap<Integer, String> letters, List<String> combinations, StringBuilder sb) {
        if (pivot == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        String current = letters.get(digits.charAt(pivot) - '0');
        for (int i = 0; i < current.length(); i++) {
            sb.append(current.charAt(i));
            helper(digits, pivot + 1, letters, combinations, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}