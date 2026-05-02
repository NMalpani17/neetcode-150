// Problem  : Generate Parentheses
// Link     : https://leetcode.com/problems/generate-parentheses/
// Difficulty: Medium
// Pattern  : Backtracking
// Time     : O(4^n / √n) | Space: O(n)

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        helper(parenthesis, new StringBuilder(), 0, 0, n);
        return parenthesis;
    }

    public void helper(List<String> parenthesis, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            parenthesis.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            helper(parenthesis, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            helper(parenthesis, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}