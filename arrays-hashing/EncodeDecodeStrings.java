// Problem  : Encode and Decode Strings
// Link     : https://leetcode.com/problems/encode-and-decode-strings/
// Difficulty: Medium
// Pattern  : String Manipulation
// Time     : O(n) | Space: O(n)

import java.util.ArrayList;
import java.util.List;

public class Codec {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        int i = 0;
        List<String> strs = new ArrayList<>();
        while (i < s.length()) {
            int index = s.indexOf("#", i);
            int length = Integer.parseInt(s.substring(i, index));
            String decoded = s.substring(index + 1, index + 1 + length);
            strs.add(decoded);
            i = index + 1 + length;
        }
        return strs;
    }
}