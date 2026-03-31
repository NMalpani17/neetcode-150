// Problem  : Koko Eating Bananas
// Link     : https://leetcode.com/problems/koko-eating-bananas/
// Difficulty: Medium
// Pattern  : Binary Search on Answer Space
// Time     : O(n log m) | Space: O(1)

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles) max = Math.max(i, max);

        int i = 1, j = max;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (canEat(piles, mid, h)) j = mid - 1;
            else i = mid + 1;
        }
        return i;
    }

    public boolean canEat(int[] piles, int hour, int maxHours) {
        long hours = 0;
        for (int pile : piles) hours += (pile + hour - 1) / hour;
        return hours <= maxHours;
    }
}