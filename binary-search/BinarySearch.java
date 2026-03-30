// Problem  : Binary Search
// Link     : https://leetcode.com/problems/binary-search/
// Difficulty: Easy
// Pattern  : Binary Search
// Time     : O(log n) | Space: O(1)

class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return -1;
    }
}