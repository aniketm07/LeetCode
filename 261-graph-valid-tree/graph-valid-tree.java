import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Build an undirected graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); // Undirected
        }

        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1}); // Start from node 0, parent -1
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adjList.get(node)) {
                if (neighbor == parent) continue; // Skip the parent
                if (visited[neighbor]) return false; // Cycle detected
                visited[neighbor] = true;
                queue.offer(new int[]{neighbor, node});
            }
        }

        // Check that all nodes are visited (connected graph)
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }
}