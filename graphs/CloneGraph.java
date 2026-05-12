// Problem  : Clone Graph
// Link     : https://leetcode.com/problems/clone-graph/
// Difficulty: Medium
// Pattern  : Graph BFS + HashMap
// Time     : O(n) | Space: O(n)

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}