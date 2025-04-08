class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) indegree[i] = 0;
        
        for(int[] edge : prerequisites){
            list.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            topoSort.add(node);
            for(int i : list.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
        }
        if(topoSort.size() == numCourses){
            int[] ans = new int[topoSort.size()];
            int i = 0;
            for(Integer val : topoSort){
                ans[i] = val;
                i++;
            }
            return ans;
        }

        return new int[0];
    }
}