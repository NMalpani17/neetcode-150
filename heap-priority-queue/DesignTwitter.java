// Problem  : Design Twitter
// Link     : https://leetcode.com/problems/design-twitter/
// Difficulty: Medium
// Pattern  : Heap / Priority Queue + HashMap
// Time     : O(n log n) getNewsFeed | Space: O(n)

import java.util.*;

class Twitter {
    int timestamp;
    Map<Integer, List<int[]>> posts;
    Map<Integer, Set<Integer>> following;

    public Twitter() {
        posts = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!posts.containsKey(userId)) posts.put(userId, new ArrayList<>());
        posts.get(userId).add(new int[]{tweetId, timestamp++});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        if (posts.containsKey(userId)) pq.addAll(posts.get(userId));
        if (following.containsKey(userId)) {
            for (int current : following.get(userId)) {
                if (posts.containsKey(current)) pq.addAll(posts.get(current));
            }
        }
        while (!pq.isEmpty() && feed.size() < 10) feed.add(pq.poll()[0]);
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            if (!following.containsKey(followerId)) following.put(followerId, new HashSet<>());
            following.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}