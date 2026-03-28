// Problem  : Car Fleet
// Link     : https://leetcode.com/problems/car-fleet/
// Difficulty: Medium
// Pattern  : Monotonic Stack
// Time     : O(n log n) | Space: O(n)

import java.util.Arrays;

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleetCount = 0;
        double lowestTime = 0.0;
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (time > lowestTime) {
                lowestTime = time;
                fleetCount++;
            }
        }
        return fleetCount;
    }
}