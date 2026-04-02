// Problem  : Search in Rotated Sorted Array
// Link     : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Difficulty: Medium
// Pattern  : Binary Search
// Time     : O(log n) | Space: O(1)

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && nums[mid] > target) j = mid - 1;
                else i = mid + 1;
            } else {
                if (nums[mid] < target && nums[j] >= target) i = mid + 1;
                else j = mid - 1;
            }
        }
        return -1;
    }
}