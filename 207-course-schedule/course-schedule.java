class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        
        for (int[] edge : prerequisites) {
            list.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);
            for (int neighbor : list.get(node)) {
                indegree[neighbor]--; // ✅ correct here
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoSort.size() == numCourses;
    }
}