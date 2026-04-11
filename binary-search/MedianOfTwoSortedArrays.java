// Problem  : Median of Two Sorted Arrays
// Link     : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Difficulty: Hard
// Pattern  : Binary Search
// Time     : O(log min(m,n)) | Space: O(1)

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;
            int leftMax1  = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int leftMax2  = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int rightMin1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int rightMin2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if (leftMax1 > rightMin2) high = i - 1;
            else if (leftMax2 > rightMin1) low = i + 1;
            else return (m + n) % 2 != 0
                        ? Math.max(leftMax1, leftMax2)
                        : (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
        }
        return 0;
    }
}