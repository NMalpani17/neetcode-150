// Problem  : Find Minimum in Rotated Sorted Array
// Link     : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Difficulty: Medium
// Pattern  : Binary Search
// Time     : O(log n) | Space: O(1)

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] < nums[j]) return nums[i];
            int mid = i + (j - i) / 2;
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            } else if (nums[mid] < nums[j]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}