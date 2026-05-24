// Problem  : Redundant Connection
// Link     : https://leetcode.com/problems/redundant-connection/
// Difficulty: Medium
// Pattern  : Union-Find
// Time     : O(n α(n)) | Space: O(n)

class RedundantConnection {
    private int n;
    private int[] rank;
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] i : edges) {
            if (!union(i[0], i[1])) return i;
        }
        return new int[0];
    }

    public int find(int i) {
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public boolean union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return false;
        if (rank[rx] > rank[ry]) parent[ry] = rx;
        else if (rank[rx] < rank[ry]) parent[rx] = ry;
        else { parent[rx] = ry; rank[ry]++; }
        return true;
    }
}