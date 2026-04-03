// Problem  : Time Based Key-Value Store
// Link     : https://leetcode.com/problems/time-based-key-value-store/
// Difficulty: Medium
// Pattern  : Binary Search
// Time     : O(log n) get, O(1) set | Space: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {

    class Timestamp {
        private String value;
        private int timestamp;

        public Timestamp(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, List<Timestamp>> uniquePair;

    public TimeMap() {
        uniquePair = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!uniquePair.containsKey(key)) uniquePair.put(key, new ArrayList<>());
        uniquePair.get(key).add(new Timestamp(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!uniquePair.containsKey(key) || uniquePair.get(key).size() == 0) return "";
        List<Timestamp> values = uniquePair.get(key);
        int i = 0, j = values.size() - 1;
        String res = "";
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (values.get(mid).timestamp <= timestamp) {
                res = values.get(mid).value;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }
}