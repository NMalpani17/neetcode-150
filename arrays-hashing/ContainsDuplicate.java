// Problem  : Contains Duplicate
// Link     : https://leetcode.com/problems/contains-duplicate/
// Difficulty: Easy
// Pattern  : Hashing
// Time     : O(n) | Space: O(n)

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicate = new HashSet<>();
        for (int num : nums) {
            if (duplicate.contains(num)) return true;
            duplicate.add(num);
        }
        return false;
    }
}