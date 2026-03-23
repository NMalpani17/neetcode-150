// Problem  : Minimum Window Substring
// Link     : https://leetcode.com/problems/minimum-window-substring/
// Difficulty: Hard
// Pattern  : Sliding Window
// Time     : O(n) | Space: O(1)

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] tcount = new int[128];
        int[] scount = new int[128];

        for (char c : t.toCharArray()) tcount[c]++;

        int required = 0;
        for (int x : tcount) if (x != 0) required++;

        int i = 0, count = 0;
        String ans = "";

        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            scount[current]++;
            if (tcount[current] == scount[current]) count++;

            while (count == required) {
                if (ans.isEmpty() || (j - i + 1) < ans.length()) {
                    ans = s.substring(i, j + 1);
                }
                scount[s.charAt(i)]--;
                if (tcount[s.charAt(i)] > scount[s.charAt(i)]) count--;
                i++;
            }
        }
        return ans;
    }
}