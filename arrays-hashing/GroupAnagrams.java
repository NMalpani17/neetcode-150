// Problem  : Group Anagrams
// Link     : https://leetcode.com/problems/group-anagrams/
// Difficulty: Medium
// Pattern  : Hashing
// Time     : O(n * k) | Space: O(n * k)  — k = max string length

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}